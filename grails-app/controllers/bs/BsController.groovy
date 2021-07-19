package bs

import grails.converters.JSON
import grails.plugin.springsecurity.SpringSecurityService
import security.RequestMap
import security.RequestMapService

/**
 * @author JamesChang
 * @since Grails4.0.1
 */
class BsController {

    Bs000Service bs000Service
    RequestMapService requestMapService
    SpringSecurityService springSecurityService

    /**
     * page: 查詢頁面
     */
    def bsAppList = {
        render view: "/bs/bs000/index"
    }

    /**
     * page: 新增資料頁面
     */
    def addPage = {
        render view: "/bs/bs000/addPage", model: [bs000I: new Bs000(showOnMenu: true,status: 5,issure: 2)]
    }

    /**
     * page: 編輯資料頁面
     */
    def editPage = {
        Bs000 bs000I = Bs000.get(params.id)
        render view: "/bs/bs000/editPage", model: [bs000I:bs000I]
    }

    /**
     * page: 程式資訊
     */
    def tab1 = {
        Bs000 bs000I = Bs000.get(params.id)
        render template: "/bs/bs000/editTabs/tab1", model: [bs000I:bs000I]
    }

    /**
     * page: 使用權限
     */
    def tab2 = {
        Bs000 bs000I = Bs000.get(params.id)
        render template: "/bs/bs000/editTabs/tab2", model: [bs000I:bs000I]
    }

    /**
     * action: 查詢資料
     */
    def filter = {
        LinkedHashMap result = bs000Service.filter(params)
        render result as JSON
    }

    /**
     * action: 新增資料
     */
    JSON bs000Insert(){
        LinkedHashMap result = bs000Service.doInsert(params)
        if(!result.acrtionIsSuccess){
            result.acrtionMessage = g.renderErrors( bean:result.bean,as:'list') as Object
        }
        else{
            //更新tab資訊
            result.tabId = result?.bean?.id?.toString()
            result.tabName = result.bean?.appCname
            result.forWardUrl = createLink(controller: 'bs',action: 'editPage',params: [
                    id:result.bean?.id,
            ]) as Object
        }
        render result as JSON
    }

    /**
     * action: 更新資料
     */
    JSON bs000Update(){
        LinkedHashMap result = bs000Service.doUpdate(params)
        if(!result.acrtionIsSuccess){
            result.acrtionMessage = g.renderErrors( bean:result.bean,as:'list') as Object
        }
        else{
            //更新tab資訊
            result.tabId = result?.bean?.id?.toString()
            result.tabName = result.bean?.appCname
            result.forWardUrl = createLink(controller: 'bs',action: 'editPage',params: [
                    id:result.bean?.id,
            ]) as Object
        }
        render result as JSON
    }

    /**
     * action: 刪除資料
     * @return
     */
    JSON bs000Delete(){
        LinkedHashMap result = bs000Service.doDelete(params)
        if(!result.acrtionIsSuccess){
            result.acrtionMessage = g.renderErrors( bean:result.bean,as:'list') as Object
        }
        else{
            //更新tab資訊
            result.tabId = result?.bean?.id?.toString()
            result.tabName = result.bean?.appCname
            result.forWardUrl = createLink(controller: 'bs',action: 'editPage',params: [
                    id:result.bean?.id,
            ]) as Object
        }
        render result as JSON
    }

    /**
     * action: 查詢可以使用該程式的系統角色
     * @return JSON
     */
    JSON filterRequestMap(){
        if(params.url == ""){
            params.url = "nothing"
        }
        LinkedHashMap result = requestMapService.filter(params)
        render result as JSON
    }

    /**
     * page: 新增使用權限
     */
    def addRequestMapModel = {
        RequestMap requestMapI = new RequestMap(url: params?.url)
        render template: "/bs/bs000/models/requestMapModel/addModel", model: [requestMapI:requestMapI]
    }

    /**
     * page: 修改使用權限
     */
    def editRequestMapModel = {
        println params
        render template: "/bs/bs000/models/requestMapModel/editModel", model: [requestMapI:RequestMap.get(params?.id)]
    }

    /**
     * action: 新增 RequestMapModel
     * @return
     */
    JSON insertRequestMapModel(){


        println 155
        HashMap result = [:]

        println 157
        if(!result.acrtionIsSuccess){
            result.acrtionMessage = g.renderErrors( bean:result.bean,as:'list') as Object
        }
        else{
            result.modelId = params?.modelId
            result.forWardUrl = createLink(controller: 'bs',action: 'editRequestMapModel',params: [
                    id:result.bean?.id,
            ]) as Object
        }
        return result as JSON

    }

    /**
     * action: 更新 RequestMapModel
     * @return
     */
    JSON updateRequestMapModel(){

        HashMap result = requestMapService.doUpdate(params)

        if(!result.acrtionIsSuccess){
            result.acrtionMessage = g.renderErrors( bean:result.bean,as:'list') as Object
        }
        else{
            springSecurityService.clearCachedRequestmaps()
            result.modelId = params?.modelId
            result.forWardUrl = createLink(controller: 'bs',action: 'editRequestMapModel',params: [
                    id:result.bean?.id,
            ]) as Object
        }

        return result as JSON

    }

    /**
     * action: 刪除 RequestMap
     * @return
     */
    JSON deleteRequestMapModel(){
        LinkedHashMap result = requestMapService.doDelete(params)
        if(!result.acrtionIsSuccess){
            result.acrtionMessage = g.renderErrors( bean:result.bean,as:'list') as Object
        }
        else{
            springSecurityService.clearCachedRequestmaps()
            result.modelId = params?.modelId
        }
        render result as JSON
    }
}
