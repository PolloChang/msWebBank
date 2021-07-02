package security

import grails.gorm.transactions.Transactional
import grails.web.databinding.DataBinder
import grails.web.servlet.mvc.GrailsParameterMap
import org.springframework.context.MessageSource
import sys.toolBox.ToolBoxService

@Transactional
class RequestMapService implements DataBinder {
    
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
        searchData.likeList = []
        //布林
        searchData.booleanList = []
        //日期
        searchData.dateList = []
        searchData.dateList?.each{
            dateTransform << "${it}1"
            dateTransform << "${it}2"
        }

        params << toolBoxService.paramsTextDateTransform(params: params,list: dateTransform)

        List<RequestMap> requestMapList = RequestMap.createCriteria().list(params) {
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

            if(params."url"){
                sqlRestriction("INSTR(URL , '${params."url"}') > 0")
            }

        }

        requestMapList.each {
            def row = [:]
            row.id = it?.id?.toString()
            row.showPageName = "編輯資料"
            row.configAttribute = it?.configAttribute?:""
            row.httpMethod = it?.httpMethod?:""
            row.url = it?.url?:""

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
    LinkedHashMap doInsert(GrailsParameterMap params){
        return _saveInstance(new RequestMap(), params, { RequestMap requestMapI ->
            requestMapI.manCreated = '系統管理員'
            requestMapI.validate()
        })
    }

    /**
     * 更新資料
     * @param params
     * @return
     */
    LinkedHashMap doUpdate(GrailsParameterMap params){
        return _saveInstance(RequestMap.get(params.requestMap.id), params, { RequestMap requestMapI ->
            requestMapI.lastUpdated = new Date()
            requestMapI.manLastUpdated = '系統管理員'
            requestMapI.validate()
        })
    }

    /**
     * 儲存資料
     * @param params
     * @return result[LinkedHashMap]
     */
    LinkedHashMap _saveInstance(RequestMap requestMapI,GrailsParameterMap params,Closure<?> closure) {
        LinkedHashMap result = [:]
        result.bean = requestMapI
        closure(requestMapI)

        bindData(requestMapI, params["requestMap"], [include:requestMapI.updateBindMap])
        int pageDataVersion = params.requestMap.version?(params.requestMap?.version as int):0
        if(requestMapI.version != pageDataVersion && params.requestMap.id){

            result.dataVersionDifferent = true
            requestMapI.discard()
        } else if (requestMapI.hasErrors()) { //失敗

            def errorColumn = []
            requestMapI.errors.allErrors.eachWithIndex  {item, index ->
                errorColumn[index] = [item?.arguments,item?.defaultMessage]
            }
            requestMapI.discard()
            result.acrtionIsSuccess = false
        }
        else{
            try{
                requestMapI.save(flush: true)
                result.acrtionIsSuccess = true
            }catch(Exception ex){
                result.acrtionIsSuccess = false
                ex.printStackTrace()
                requestMapI.discard()
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
        RequestMap requestMapI = RequestMap.get(params.requestMap.id)

        if(requestMapI.version != (params.requestMap.version as int)){
            result.dataVersionDifferent = true
            requestMapI.discard()
        }else{

            try{
                requestMapI.delete(flush: true)
                result.acrtionIsSuccess = true
                result.acrtionMessage = messageSource.getMessage("default.deleted.message", [] as Object[], Locale.TAIWAN)
            }
            catch (Exception ex){
                result.acrtionIsSuccess = false
                result.acrtionMessage = messageSource.getMessage("default.deleted.message", [] as Object[], Locale.TAIWAN)
                requestMapI.discard()
                ex.printStackTrace()
            }
            finally {

            }

        }

        return result
    }
}
