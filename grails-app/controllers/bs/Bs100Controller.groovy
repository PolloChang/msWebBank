package bs

import grails.converters.JSON

/**
 * BS系統選單
 * @author JamesChang
 * @since Grails4.0.1
 */
class Bs100Controller {

    Bs100Service bs100Service

    def index() {
        render view: '/bs/bs100List/index'
    }

    def creatPage = {
        def bs100I = new Bs100()
        render view: '/bs/bs100List/creatBs100', model: [readonly:false,bs100I:bs100I,pageId:params.id]
    }

    /**
     * 編輯畫面
     */
    def editPage = {
        def bs100I = Bs100.get(params?.id)
        render view: '/bs/bs100List/editBs100', model: [readonly:false,bs100I:bs100I,pageId:params.id]
    }

    /**
     * 查詢
     * @return
     */
    JSON filter(){
        LinkedHashMap result = [:]
        if(params?.params){
            result = bs100Service.filter(params)
        }
        else{
            result.rows = []
        }
        render result as JSON
    }

    /**
     * 新增BS100
     * @return result[JSON]
     */
    def doInsert(){
        LinkedHashMap result = bs100Service.doSave(params)
        if(!result.acrtionIsSuccess){
            result.acrtionMessage = g.renderErrors( bean:result.bean,as:'list')
        }
        else{
            result.forWardId = result.bean?.id.toString()
        }
        render result as JSON
    }

    JSON doUpdate(){
        LinkedHashMap result = bs100Service.doSave(params)
        if(!result.acrtionIsSuccess){
            result.acrtionMessage = g.renderErrors( bean:result.bean,as:'list')
        }
        else{
            result.forWardId = result.bean?.id.toString()
        }
        render result as JSON
    }

    /**
     * 刪除
     * @return JSON
     */
    def doDelete(){
        LinkedHashMap result = bs100Service.doDelete(params)
        render result as JSON
    }

    /**
     * 新增BS101頁面
     */
    def creatPageBs101 = {
        def modalId = params?.modalId
        def bs101I = new Bs101()
        bs101I.ptype = params.ptype
        render view: '/bs/bs100List/creatBs101', model: ['modalId':modalId,readonly:false,bs101I:bs101I]
    }

    /**
     * BS101編輯頁面
     */
    def editPageBs101 = {
        def modalId = params?.modalId
        def bs101I = Bs101.get(params?.id)
        render view: '/bs/bs100List/editBs101', model: ['modalId':modalId,readonly:false,bs101I:bs101I]
    }

    /**
     * 新增選單Bs101
     * @return JSON
     */
    def doInsertBs101(){
        LinkedHashMap result = bs100Service.bs101DoSave(params)
        if(!result.acrtionIsSuccess){
            result.acrtionMessage = g.renderErrors( bean:result.bean,as:'list')
        }
        else{
            result.forWardId = result.bean?.id.toString()
        }
        render result as JSON
    }

    /**
     * 更新選單
     * @return JSON
     */
    def doUpdateBs101(){
        LinkedHashMap result = bs100Service.bs101DoSave(params)
        if(!result.acrtionIsSuccess){
            result.acrtionMessage = g.renderErrors( bean:result.bean,as:'list')
        }
        else{
            result.forWardId = result.bean?.id.toString()
        }
        render result as JSON
    }

    /**
     * 刪除選單
     * @return JSON
     */
    def doDeleteBs101(){
        LinkedHashMap result = bs100Service.doDeleteBs101(params)
        render result as JSON
    }

    /**
     *  查詢BS101資料
     * @return JSON
     */
    def filterBs101(){
        LinkedHashMap result = [:]
        if(params?.params){
            result = bs100Service.filterBs101(params)
        }
        else{
            result.rows = []
        }
        render result as JSON
    }
}
