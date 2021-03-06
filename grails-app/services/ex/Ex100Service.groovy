package ex

import grails.web.databinding.DataBinder
import grails.web.servlet.mvc.GrailsParameterMap
import grails.gorm.transactions.Transactional
import org.springframework.context.MessageSource
import sys.toolBox.ToolBoxService

/**
 * Date/檔案建立日期: 2020-02-07
 *Time/檔案建立時間: 09:31
 * File Description/檔案描述:範例程式
 * @author JamesChang
 * @since Grails4.0.1
 */
@Transactional
class Ex100Service implements DataBinder {


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

        searchData.equalIntegerLists = ['amts','numbers']
        //相等
        searchData.equalList = ['sex','citycode','twnspcode','vilgcode','status']
        //相似
        searchData.likeList = ['string','texts','idno','name','unid','zip','addr']
        //布林
        searchData.booleanList = []
        //日期
        searchData.dateList = ['birthdy']
        searchData.dateList?.each{
            dateTransform << "${it}1"
            dateTransform << "${it}2"
        }

        params << toolBoxService.paramsTextDateTransform(params: params,list: dateTransform)

        List<Ex100> ex100List = Ex100.createCriteria().list(params) {
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

        }

        ex100List.each {
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
    LinkedHashMap doInsert(GrailsParameterMap params){
        return _saveInstance(new Ex100(), params, { Ex100 ex100I ->
            ex100I.manCreated = '系統管理員'
            ex100I.validate()
        })
    }

    /**
     * 更新資料
     * @param params
     * @return
     */
    LinkedHashMap doUpdate(GrailsParameterMap params){
        return _saveInstance(Ex100.get(params.ex100.id), params, { Ex100 ex100I ->
            ex100I.lastUpdated = new Date()
            ex100I.manLastUpdated = '系統管理員'
            ex100I.validate()
        })
    }

    /**
     * 儲存資料
     * @param params
     * @return result[LinkedHashMap]
     */
    LinkedHashMap _saveInstance(Ex100 ex100I,GrailsParameterMap params,Closure<?> closure) {
        LinkedHashMap result = [:]
        result.bean = ex100I
        closure(ex100I)

        bindData(ex100I, params["ex100"], [include:ex100I.updateBindMap])
        int pageDataVersion = params.ex100.version?(params.ex100?.version as int):0
        if(ex100I.version != pageDataVersion && params.ex100.id){

            result.dataVersionDifferent = true
            ex100I.discard()
        } else if (ex100I.hasErrors()) { //失敗

            def errorColumn = []
            ex100I.errors.allErrors.eachWithIndex  {item, index ->
                errorColumn[index] = [item?.arguments,item?.defaultMessage]
            }
            ex100I.discard()
            result.acrtionIsSuccess = false
        }
        else{
            try{
                ex100I.save(flush: true)
                result.acrtionIsSuccess = true
            }catch(Exception ex){
                result.acrtionIsSuccess = false
                ex.printStackTrace()
                ex100I.discard()
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
        Ex100 ex100I = Ex100.get(params.ex100.id)

        if(ex100I.version != (params.ex100.version as int)){
            result.dataVersionDifferent = true
            ex100I.discard()
        }else{

            try{
                ex100I.delete(flush: true)
                result.acrtionIsSuccess = true
                result.acrtionMessage = messageSource.getMessage("default.deleted.message", [] as Object[], Locale.TAIWAN)
            }
            catch (Exception ex){
                result.acrtionIsSuccess = false
                result.acrtionMessage = messageSource.getMessage("default.deleted.message", [] as Object[], Locale.TAIWAN)
                ex100I.discard()
                ex.printStackTrace()
            }
            finally {

            }

        }

        return result
    }
}
