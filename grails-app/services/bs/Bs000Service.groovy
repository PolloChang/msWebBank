package bs

import grails.gorm.transactions.Transactional
import grails.web.servlet.mvc.GrailsParameterMap
import org.springframework.context.MessageSource

@Transactional
class Bs000Service {

    def toolBoxService
    MessageSource messageSource

    /**
     * 查詢
     * @param params
     * @return  result[Map]
     */
    LinkedHashMap filter(GrailsParameterMap params){
        LinkedHashMap result = [:]
        List dateTransform = []

        //查詢條件集
        def searchData = [:]
        def showRows = []

        searchData.equalIntegerLists = ['amts','numbers']
        //相等
        searchData.equalList = ['sex','citycode','twnspcode','vilgcode','status']
        //相似
        searchData.likeList = ['string','texts','idno','name','unid','zip','addr']
        //日期
        searchData.dateList = ['birthdy']
        searchData.dateList?.each{
            dateTransform << "${it}1"
            dateTransform << "${it}2"
        }

        params << toolBoxService.paramsTextDateTransform(params: params,list: dateTransform)

        List<Bs000> bs000List = Bs000.createCriteria().list(params) {
            //必要條件
            'in'("issure", ['1'.toLong(),'2'.toLong()])
            searchData.equalIntegerLists.each {field ->
                if(params?."${field}") {
                    if(toolBoxService.isNumeric(params."${field}".toString())){
                        or {
                            def searchVal = params."${field}"
                            if(searchVal instanceof java.lang.String){
                                eq(field, searchVal.toLong())
                            }
                            else{
                                eq(field, searchVal.toLong())
                            }
                        }
                    }
                }
            }

            searchData.equalList.each {field ->
                if(params."${field}"){
                    eq(field,params."${field}")
                }
            }

            searchData.likeList.each {field ->
                if(params."${field}"){
                    like(field,'%'+params."${field}"+'%')
                }
            }

            searchData.dateList.each{field->  //date condition
                if(params."${field}1"){
                    ge(field, params."${field}1")
                }
                if(params."${field}2"){
                    lt(field, params."${field}2")
                }
            }

        }

        bs000List.each {
            def row = [:]
            row.id = it?.id?.toString()
            row.showPageName = it?.name?:"編輯資料"
            row.status = it?.statusDesc
            row.addr = it?.addr
            row.birthday = it?.birthday
            row.name = it?.name
            row.citycode = it?.citycodeDesc
            row.issure = it?.issure
            row.texts = it?.texts
            row.numbers = it?.numbers
            row.idno = it?.idno
            row.rode = it?.rode
            row.string = it?.string
            row.sex = it?.sexDesc
            row.twnspcode = it?.twnspcodeDesc
            row.vilgcode = it?.vilgcodeDesc
            row.unid = it?.unid
            row.amts = it?.amts
            row.notes = it?.notes
            row.zip = it?.zip
            row.addrFull = it?.addrFull
            showRows << row
        }
        result.rows = showRows
        return result
    }

    /**
     * 新增資料
     * @param params
     * @return
     */
    def doInsert(GrailsParameterMap params){
        return _saveInstance(new Bs000(), params, { Bs000 bs000I ->
            bs000I.manCreated = '系統管理員'
            bs000I.validate()
        })
    }

    /**
     * 更新資料
     * @param params
     * @return
     */
    def doUpdate(GrailsParameterMap params){
        return _saveInstance(Bs000.get(params.bs000.id), params, { Bs000 bs000I ->
            bs000I.lastUpdated = new Date()
            bs000I.manLastUpdated = '系統管理員'
            bs000I.validate()
        })
    }

    /**
     * 儲存資料
     * @param params
     * @return result[LinkedHashMap]
     */
    def _saveInstance(Bs000 bs000I,GrailsParameterMap params,Closure<?> closure) {
        LinkedHashMap result = [:]
        result.bean = bs000I
        closure(bs000I)

        bindData(bs000I, params["bs000"], [include:bs000I.updateBindMap])
        int pageDataVersion = params.bs000.version?(params.bs000?.version as int):0
        if(bs000I.version != pageDataVersion && params.bs000.id){

            result.dataVersionDifferent = true
            bs000I.discard()
        } else if (bs000I.hasErrors()) { //失敗

            def errorColumn = []
            bs000I.errors.allErrors.eachWithIndex  {item, index ->
                errorColumn[index] = [item?.arguments,item?.defaultMessage]
            }
            bs000I.discard()
            result.acrtionIsSuccess = false
        }
        else{
            try{
                bs000I.save(flush: true)
                result.acrtionIsSuccess = true
            }catch(Exception ex){
                result.acrtionIsSuccess = false
                bs000I.discard()
            }

            if(result.acrtionIsSuccess){
                result.acrtionMessage = messageSource.getMessage("default.updated.message", [] as Object[], Locale.TAIWAN)
            }
            else{
                result.acrtionMessage = messageSource.getMessage("default.updated.message", [] as Object[], Locale.TAIWAN)
            }
        }

        return result
    }

    /**
     * 刪除資料
     * @param params
     */
    def doDelete(GrailsParameterMap params){
        LinkedHashMap result = [:]
        Bs000 bs000I = Bs000.get(params.bs000.id)

        if(bs000I.version != (params.bs000.version as int)){
            result.dataVersionDifferent = true
            bs000I.discard()
        }else{

            try{
                bs000I.delete(flush: true)
                result.acrtionIsSuccess = true
                result.acrtionMessage = messageSource.getMessage("default.deleted.message", [] as Object[], Locale.TAIWAN)
            }
            catch (Exception ex){
                result.acrtionIsSuccess = false
                result.acrtionMessage = messageSource.getMessage("default.deleted.message", [] as Object[], Locale.TAIWAN)
                bs000I.discard()
            }
            finally {

            }

        }

        return result
    }
}
