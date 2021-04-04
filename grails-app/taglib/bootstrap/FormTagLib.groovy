package bootstrap

class FormTagLib {
    static defaultEncodeAs = [taglib:'none']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    static namespace = "bootstrap"


    Closure formItem = { attrs,body ->
        if (!attrs.name) {
            throwTagError("Tag [searchFormItem] is missing required attribute [name]")
        }
        if (!attrs.labelTitle) {
            throwTagError("Tag [searchFormItem] is missing required attribute [labelTitle]")
        }
        def inputName = attrs.remove('name')
        def id = attrs.remove('id')?:inputName
        def type = attrs.remove('inputType')?:"text"
        def placeholder = attrs.remove('placeholder')?:""
        def value = attrs.remove('value')?:""
        def inputClass = attrs.remove('inputClass')?:""
        ArrayList titleVsContent = attrs.remove('titleVsContent')?:[2,4]

        def labelId = attrs.remove('labelId')?:UUID.randomUUID().toString()
        def labelTitle = attrs.remove('labelTitle')?:""
        def labelClass = attrs.remove('labelClass')?:""


        def writer = out

        writer << "<label id='${labelId}' for=\"${id}\" class=\"col-sm-${titleVsContent[0]} table-primary col-form-label text-right ${labelClass}\">${labelTitle}</label>"
        writer << "<div class=\"col-sm-${titleVsContent[1]}\">"
        if(type=="contents"){
            //input 內容在標籤之間
            writer << body()
        }
        else {
            writer << "    <input type=\"${type}\" name=\"${inputName}\" id=\"${id}\" class='form-control ${inputClass}' placeholder=\"${placeholder}\" value=\"${value}\">"
        }
        writer << "</div>"

    }

    Closure checkBox = {attrs ->
        if (!attrs.name) {
            throwTagError("Tag [searchFormItem] is missing required attribute [name]")
        }
        def inputName = attrs.remove('name')
        def inputId = attrs.remove('id')?:inputName
        def inputClass = attrs.remove('inputClass')?:""
        def value = attrs.remove('value')?:""

        def labelId = attrs.remove('labelId')?:UUID.randomUUID().toString()
        def labelTitle = attrs.remove('labelTitle')?:""
        def labelClass = attrs.remove('labelClass')?:""

        def writer = out

        writer << "<input class=\"form-check-input ${inputClass}\" type=\"checkbox\" value=\"${value}\" id=\"${inputId}\">"
        writer << "<label id=\"${labelId}\" class=\"form-check-label ${labelClass}\" for=\"${inputId}\">${labelTitle}</label>"
    }

    /**
     * 地址連動選單
     */
    Closure addressSelect = { attrs ->
        if(!attrs.nameZip && !attrs.nameCitycode && !attrs.nameTwnspcode && !attrs.nameVilgcode && !attrs.nameAddr){
            throwTagError("Tag [addressSelect] is missing required one attribute [nameZip,nameCitycode,nameTwnspcode,nameVilgcode,nameAddr]")
        }
        String nameZip = attrs.remove("nameZip")
        String nameCitycode = attrs.remove("nameCitycode")
        String nameTwnspcode = attrs.remove("nameTwnspcode")
        String nameVilgcode = attrs.remove("nameVilgcode")
        String nameAddr = attrs.remove("nameAddr")
        String idZip = attrs.remove("idZip")?:nameZip
        String idCitycode = attrs.remove("idCitycode")?:nameCitycode
        String idTwnspcode = attrs.remove("idTwnspcode")?:nameTwnspcode
        String idVilgcode = attrs.remove("idVilgcode")?:nameVilgcode
        String idAddr = attrs.remove("idAddr")?:nameAddr
        def valueZip = attrs.remove("valueZip")?:''
        def valueCitycode = attrs.remove("valueCitycode")?:''
        def valueTwnspcode = attrs.remove("valueTwnspcode")?:''
        def valueVilgcode = attrs.remove("valueVilgcode")?:''
        def valueAddr = attrs.remove("valueAddr")?:''
        out << '<div class="form-row">'
        if(nameZip){
            def nameZipAttrs = [:]
            nameZipAttrs.type = "text"
            nameZipAttrs.id = idZip
            nameZipAttrs.name = nameZip
            nameZipAttrs.value = valueZip
            nameZipAttrs.placeholder = message(code: 'ex100.zip.label')
            out << '<div class="col-2">'
            out << inpitField(nameZipAttrs)
            out << "</div>"
        }

        if(nameCitycode){
            out << '<div class="col-auto">'
            out << "<select id='${idCitycode}' name='${nameCitycode}' class='form-control w-auto d-inline' "
            if(nameTwnspcode){
                out << """onchange='ajaxChangSelectOption(this.value,"${nameTwnspcode}","${createLink(controller: "toolBox",action: "getBs201Select")}");'"""
            }
            out << ' >'
            renderNoSelectionOptionImpl(out, '', '---', valueCitycode)
            out.println()
            out << optionList(bs.Bs200.getAll(),valueCitycode.toString(),"code","textShow")
            out << '</select>'
            out << "</div>"
        }

        if(nameTwnspcode){
            out << '<div class="col-auto">'
            out << "<select id='${idTwnspcode}' name='${nameTwnspcode}' class='form-control w-auto d-inline' "
            if(nameVilgcode){
                out << """onchange='ajaxChangSelectOption(this.value,"${nameVilgcode}","${createLink(controller: "toolBox",action: "getBs202Select")}");'"""
            }
            out << ' >'
            renderNoSelectionOptionImpl(out, '', '---', valueTwnspcode)
            out.println()
            out << optionList(bs.Bs201.findAllByIssureAndBs200Code(2,valueCitycode.toString()),valueTwnspcode.toString(),"code","textShow")
            out << '</select>'
            out << "</div>"
        }

        if(nameVilgcode){
            out << '<div class="col-auto">'
            out << "<select id='${idVilgcode}' name='${nameVilgcode}' class='form-control w-auto d-inline' "
            out << ' >'
            renderNoSelectionOptionImpl(out, '', '---', valueVilgcode)
            out.println()
            out << optionList(bs.Bs202.findAllByIssureAndBs201Code(2,valueTwnspcode.toString()),valueVilgcode.toString(),"code","textShow")
            out << '</select>'
            out << "</div>"
        }

        if(nameAddr){
            attrs.type = "text"
            attrs.id = idAddr
            attrs.name = nameAddr
            attrs.value = valueAddr
            attrs.class = "w-100 d-inline"
            attrs.placeholder = message(code: 'ex100.addr.label')
            out << '<div class="col-5">'
            out << inpitField(attrs)
            out << "</div>"
        }
        out << "</div>"
    }

    /**
     * 產生input
     * @param attrs
     * @return
     */
    private inpitField(attrs){
        String returnVal = ""

        if (!attrs.type) {
            throwTagError("Tag [inpitField] is missing required attribute [type]")
        }
        if (!attrs.name) {
            throwTagError("Tag [inpitField] is missing required attribute [name]")
        }
        String classes = attrs.remove('class')?:""
        String name = attrs.remove('name')?:""
        String id = attrs.remove('id')?:name
        String value = attrs.remove('value')?:""
        String placeholder = attrs.remove('placeholder')?:""
        String style = attrs.remove('style')?:""
        String type = attrs.type?:"text"
        def size = attrs.remove('size')
        boolean readonly = attrs.remove('readonly')?:false
        boolean reset = attrs.remove('reset')?:false

        returnVal = "<input id='${id}' name='${name}' value='${value}'  type='${type}' placeholder='${placeholder}' class='form-control ${reset?"reset":""} ${classes}' ${size?" size='"+size+"'":""} style='${style}' ${readonly?"readonly":""}/>"

        return returnVal
    }

    /**
     * 未選擇選項
     * @param out
     * @param noSelectionKey
     * @param noSelectionValue
     * @param value
     * @return
     */
    def renderNoSelectionOptionImpl(out, noSelectionKey, noSelectionValue, value) {
        // If a label for the '--Please choose--' first item is supplied, write it out
        out << "<option value=\"${(noSelectionKey == null ? '' : noSelectionKey)}\"${noSelectionKey == value ? ' selected="selected"' : ''}>${noSelectionValue.encodeAsHTML()}</option>"
    }

    /**
     *
     * @param from
     * @param value
     * @param optionKey
     * @param optionValue
     * @return option清單
     */
    private String optionList(ArrayList from,String value,String optionKey,String optionValue){
        StringBuffer returnValue = new StringBuffer()

        // create options from list
        from.eachWithIndex {el, i ->
            def keyValue = el[optionKey]
            def text = el[optionValue]
            boolean selected
            returnValue.append('<option ')
            returnValue.append(" value='${keyValue}'' ")

            selected = value.equals(keyValue.toString())

            if(selected){
                returnValue.append("selected")
            }
            returnValue.append(' >')
            if(!keyValue.equals('')){
                returnValue.append("${i+1}.${text}")
            }
            else{
                returnValue.append("${text}")
            }

            returnValue.append('</option>')
        }

        return returnValue.toString()
    }
}
