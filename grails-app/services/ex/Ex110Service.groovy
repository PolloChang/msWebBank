package ex

import grails.gorm.transactions.Transactional
import grails.web.databinding.DataBinder
import grails.web.servlet.mvc.GrailsParameterMap
import org.springframework.context.MessageSource
import sys.toolBox.ToolBoxService

@Transactional
class Ex110Service implements DataBinder {

    ToolBoxService toolBoxService
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

        searchData.equalIntegerLists = []
        //相等
        searchData.equalList = []
        //相似
        searchData.likeList = ['string']
        //布林
        searchData.booleanList = []
        //日期
        searchData.dateList = []
        searchData.dateList?.each{
            dateTransform << "${it}1"
            dateTransform << "${it}2"
        }

        params << toolBoxService.paramsTextDateTransform(params: params,list: dateTransform)

        List<Ex110> ex110List = Ex110.createCriteria().list(params) {
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

            searchData.booleanList.each {field ->
                if(params."${field}"){
                    boolean booleanVal = false
                    if(params."${field}" instanceof java.lang.String){
                        booleanVal = Boolean.parseBoolean(params."${field}")
                    }
                    eq(field,booleanVal)
                }
            }

            if(params?.ex100Id){
                eq('ex100I',Ex100.get(params?.ex100Id))
            }

        }

        ex110List.each {
            def row = [:]
            row.id = it?.id?.toString()
            row.showPageName = it?.string?:"編輯資料"
            row.string = it?.string
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
    LinkedHashMap doInsert(GrailsParameterMap params,Ex100 ex100I){
        return _saveInstance(new Ex110(), params, { Ex110 ex110I ->
            ex110I.ex100I = ex100I
            ex110I.manCreated = '系統管理員'
            ex110I.validate()
        })
    }

    /**
     * 更新資料
     * @param params
     * @return
     */
    LinkedHashMap doUpdate(GrailsParameterMap params){
        return _saveInstance(Ex110.get(params.ex110.id), params, { Ex110 ex110I ->
            ex110I.lastUpdated = new Date()
            ex110I.manLastUpdated = '系統管理員'
            ex110I.validate()
        })
    }

    /**
     * 儲存資料
     * @param params
     * @return result[LinkedHashMap]
     */
    LinkedHashMap _saveInstance(Ex110 ex110I,GrailsParameterMap params,Closure<?> closure) {
        LinkedHashMap result = [:]
        result.bean = ex110I
        closure(ex110I)

        bindData(ex110I, params["ex110"], [include:ex110I.updateBindMap])
        int pageDataVersion = params.ex110.version?(params.ex110?.version as int):0
        if(ex110I.version != pageDataVersion && params.ex110.id){

            result.dataVersionDifferent = true
            ex110I.discard()
        } else if (ex110I.hasErrors()) { //失敗

            def errorColumn = []
            ex110I.errors.allErrors.eachWithIndex  {item, index ->
                errorColumn[index] = [item?.arguments,item?.defaultMessage]
            }
            ex110I.discard()
            result.acrtionIsSuccess = false
        }
        else{
            try{
                ex110I.save(flush: true)
                result.acrtionIsSuccess = true
            }catch(Exception ex){
                result.acrtionIsSuccess = false
                ex.printStackTrace()
                ex110I.discard()
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
    LinkedHashMap doDelete(GrailsParameterMap params){
        LinkedHashMap result = [:]
        Ex110 ex110I = Ex110.get(params.ex110.id)

        if(ex110I.version != (params.ex110.version as int)){
            result.dataVersionDifferent = true
            ex110I.discard()
        }else{

            try{
                ex110I.delete(flush: true)
                result.acrtionIsSuccess = true
                result.acrtionMessage = messageSource.getMessage("default.deleted.message", [] as Object[], Locale.TAIWAN)
            }
            catch (Exception ex){
                result.acrtionIsSuccess = false
                result.acrtionMessage = messageSource.getMessage("default.deleted.message", [] as Object[], Locale.TAIWAN)
                ex110I.discard()
                ex.printStackTrace()
            }
            finally {

            }

        }

        return result
    }
}