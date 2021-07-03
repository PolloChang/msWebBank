package ex

import grails.converters.JSON

/**
 * 系統範例-頁面板型2
 */
class Ex200Controller {

    Ex100Service ex100Service
    Ex110Service ex110Service

    /**
     * page: 查詢頁面
     */
    def index() {
        render view: "/ex/ex200/index"
    }

    /**
     * page: 新增資料頁面
     */
    def addPage = {
        render view: "/ex/ex200/addPage", model: [ex100I: new Ex100()]
    }

    /**
     * page: 編輯資料頁面
     */
    def editPage = {
        Ex100 ex100I = Ex100.get(params.id)
        render view: "/ex/ex200/editPage", model: [ex100I:ex100I]
    }

    /**
     * page: tab1
     */
    def tab1 = {
        Ex100 ex100I = Ex100.get(params.id)
        render template: "/ex/ex200/editTabs/tab1", model: [ex100I:ex100I]
    }

    /**
     * page: tab2
     */
    def tab2 = {
        Ex100 ex100I = Ex100.get(params.id)
        render template: "/ex/ex200/editTabs/tab2", model: [ex100I:ex100I]
    }

    /**
     * action: 查詢資料
     */
    JSON filter(){
        LinkedHashMap result = ex100Service.filter(params)
        render result as JSON
    }

    /**
     * action: 新增資料
     */
    JSON ex100Insert(){
        LinkedHashMap result = ex100Service.doInsert(params)
        if(!result.acrtionIsSuccess){
            result.acrtionMessage = g.renderErrors( bean:result.bean,as:'list') as Object
        }
        else{
            //更新tab資訊
            result.tabId = result?.bean?.id?.toString()
            result.tabName = result.bean?.string
            result.forWardUrl = createLink(controller: 'ex200',action: 'editPage',params: [
                    id:result.bean?.id,
            ]) as Object
        }
        render result as JSON
    }

    /**
     * action: 更新資料
     */
    JSON ex100Update(){
        LinkedHashMap result = ex100Service.doUpdate(params)
        if(!result.acrtionIsSuccess){
            result.acrtionMessage = g.renderErrors( bean:result.bean,as:'list') as Object
        }
        else{
            //更新tab資訊
            result.tabId = result?.bean?.id?.toString()
            result.tabName = result.bean?.string
            result.forWardUrl = createLink(controller: 'ex200',action: 'editPage',params: [
                    id:result.bean?.id,
            ]) as Object
        }
        render result as JSON
    }

    /**
     * action: 刪除資料
     * @return
     */
    JSON ex100Delete(){
        LinkedHashMap result = ex100Service.doDelete(params)
        if(!result.acrtionIsSuccess){
            result.acrtionMessage = g.renderErrors( bean:result.bean,as:'list') as Object
        }
        else{
            //更新tab資訊
            result.tabId = result?.bean?.id?.toString()
            result.tabName = result.bean?.string
            result.forWardUrl = createLink(controller: 'ex200',action: 'editPage',params: [
                    id:result.bean?.id,
            ]) as Object
        }
        render result as JSON
    }

    /**
     * action: 查詢資料
     */
    JSON filterEx110(){
        LinkedHashMap result = ex110Service.filter(params)
        render result as JSON
    }
}
