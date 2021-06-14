package ex

import grails.converters.JSON

class Ex100Controller {

    Ex100Service ex100Service

    /**
     * page: 查詢頁面
     */
    def index = {
        render view: "/ex/ex100/index"
    }

    /**
     * page: 新增資料頁面
     */
    def addPage = {
        render view: "/ex/ex100/addPage", model: [ex100I: new Ex100()]
    }

    /**
     * page: 編輯資料頁面
     */
    def editPage = {
        Ex100 ex100I = Ex100.get(params.id)
        render view: "/ex/ex100/editPage", model: [ex100I:ex100I]
    }

    /**
     * action: 查詢資料
     */
    def filter = {
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
            result.forWardUrl = createLink(controller: 'ex100',action: 'editPage',params: [
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
            result.forWardUrl = createLink(controller: 'ex100',action: 'editPage',params: [
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
            result.forWardUrl = createLink(controller: 'ex100',action: 'editPage',params: [
                    id:result.bean?.id,
            ]) as Object
        }
        render result as JSON
    }
}
