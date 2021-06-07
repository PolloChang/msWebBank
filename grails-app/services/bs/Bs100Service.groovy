
package bs

import grails.gorm.transactions.Transactional
import grails.web.databinding.DataBinder
import grails.web.servlet.mvc.GrailsParameterMap

/**
 * Date/檔案建立日期: 2020-02-07
 * Time/檔案建立時間: 09:31
 * File Description/檔案描述:BS系統選單
 * @author JamesChang
 * @since Grails4.0.1
 */
@Transactional
class Bs100Service implements DataBinder {

    def i18nService,toolBoxService

    /**
     * 查詢
     * @param params
     * @return  result[Map]
     */
    def filter(GrailsParameterMap params) {
        LinkedHashMap result = [:]

        def searchData = [:]
        def showRows = []

        //相似
        searchData.likeList = ['systype','ptype','typedesc']

        def bs100List = Bs100.createCriteria().list(params) {
            //必要條件
            'in'("issure", [1,2])

            searchData.likeList.each {field ->
                if(params."${field}"){
                    like(field,'%'+params."${field}"+'%')
                }
            }
        }

        bs100List.each {
            def row = [:]
            row.id = it?.id.toString()
            row.ptype = it?.ptype
            row.systype = it?.systype
            row.typedesc = it?.typedesc

            showRows << row
        }

        result.rows = showRows
        return result

    }

    /**
     * 儲存資料
     * @param params
     * @return result[LinkedHashMap]
     */
    def doSave(GrailsParameterMap params) {
        LinkedHashMap result = [:]
        Bs100 bs100I
        if(params.bs100.id){
            bs100I = toolBoxService.beforeUpdate(Bs100.get(params.bs100.id),bs100I)
        }
        else {
            bs100I = toolBoxService.beforeInsert(new Bs100(),bs100I)
            bs100I.systype = params?.bs100?.systype
            bs100I.ptype = params?.bs100?.ptype
        }
        result.bean = bs100I

        bindData(bs100I, params["bs100"], [include:bs100I.updateBindMap])

        bs100I.validate()
        if (bs100I.hasErrors() || !bs100I.save(flush: true)) { //失敗
            def errorColumn = []
            bs100I.errors.allErrors.eachWithIndex  {item, index ->
                errorColumn[index] = [item?.arguments,item?.defaultMessage]
            }
            bs100I.discard()
            result.acrtionIsSuccess = false
            return result
        }
        result.acrtionIsSuccess = true
        result.acrtionMessage = i18nService.msg("default.updated.message", "", [""])
        return result
    }

    /**
     * 刪除資料
     * @param params
     * @return
     */
    def doDelete(GrailsParameterMap params){
        LinkedHashMap result = [:]
        Bs100 bs100I = Bs100.get(params.bs100.id)
        def bs101L = Bs101.findAllByPtype(bs100I.ptype)
        try{
            bs100I.delete(flush: true)
            bs101L.each {
                Bs101 bs101I = Bs101.get(it.id)
                bs101I.delete(flush: true)
            }
            result.acrtionIsSuccess = true
            result.acrtionMessage=i18nService.msg("default.deleted.message", "", [""])
        }
        catch (Exception ex){
            result.acrtionIsSuccess = false
            result.acrtionMessage=i18nService.msg("default.not.deleted.message", "", [""])
        }
        finally {
            return result
        }

    }

    /**
     * 儲存選單
     * @param params
     * @return
     */
    def bs101DoSave(GrailsParameterMap params){
        LinkedHashMap result = [:]
        Bs101 bs101I
        if(params.bs101.id){
            bs101I = toolBoxService.beforeUpdate(Bs101.get(params.bs101.id),bs101I)
        }
        else {
            bs101I = toolBoxService.beforeInsert(new Bs101(),bs101I)
            bs101I.ptype = params.bs101.ptype
            bs101I.pcode = params.bs101.pcode.toLong()
        }
        result.bean = bs101I

        bindData(bs101I, params["bs101"], [include:bs101I.updateBindMap])

        bs101I.validate()
        if (bs101I.hasErrors() || !bs101I.save(flush: true)) { //失敗
            def errorColumn = []
            bs101I.errors.allErrors.eachWithIndex  {item, index ->
                errorColumn[index] = [item?.arguments,item?.defaultMessage]
            }
            bs101I.discard()
            result.acrtionIsSuccess = false
            return result
        }
        result.acrtionIsSuccess = true
        result.acrtionMessage = i18nService.msg("default.updated.message", "", [""])
        return result
    }

    /**
     * 刪除選單
     * @param params
     * @return
     */
    def doDeleteBs101(GrailsParameterMap params){
        LinkedHashMap result = [:]
        Bs101 bs101I = Bs101.get(params.bs101.id)
        try{
            bs101I.delete(flush: true)
            result.acrtionIsSuccess = true
            result.acrtionMessage=i18nService.msg("default.deleted.message", "", [""])
        }
        catch (Exception ex){
            result.acrtionIsSuccess = false
            result.acrtionMessage=i18nService.msg("default.not.deleted.message", "", [""])
        }
        finally {
            return result
        }

    }

    /**
     * 查詢BS101資料
     * @param params
     * @return LinkedHashMap
     */
    def filterBs101(GrailsParameterMap params){
        LinkedHashMap result = [:]
        def searchData = [:]
        def showRows = []

        //相等
        searchData.equalList = ['ptype']
        //相等
        searchData.equalIntegerList = ['pcode']
        //相似
        searchData.likeList = ['typedesc']

        def bs101L = Bs101.createCriteria().list {
            'in'("issure", ['1'.toInteger(),'2'.toInteger()])

            searchData.equalList.each {field ->
                if(params."${field}"){
                    eq(field,params."${field}")
                }
            }

            searchData.equalIntegerList.each {field ->
                if(params."${field}"){
                    eq(field,params."${field}".toLong())
                }
            }

            searchData.likeList.each {field ->
                if(params."${field}"){
                    like(field,'%'+params."${field}"+'%')
                }
            }

        }

        bs101L.each {
            def row = [:]
            row.id = it?.id.toString()
            row.ptype = it?.ptype
            row.pcode = it?.pcode
            row.ptype = it?.ptype
            row.typedesc = it?.typedesc

            showRows << row
        }

        result.rows = showRows
        return result

    }

}
