package bs

import grails.converters.JSON

/**
 * @author JamesChang
 * @since Grails4.0.1
 */
class BsController {

    Bs000Service bs000Service

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
        render view: "/bs/bs000/addPage", model: [bs000I: new Bs000()]
    }

    /**
     * page: 編輯資料頁面
     */
    def editPage = {
        Bs000 bs000I = Bs000.get(params.id)
        render view: "/bs/bs000/editPage", model: [bs000I:bs000I]
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
        println result.bean
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
}
