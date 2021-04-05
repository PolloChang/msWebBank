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
        render view: "/ex/ex100/addPage"
    }

    /**
     * action: 新增資料
     */
    def ex100Insert(){
        LinkedHashMap result = ex100Service.doInsert(params)
        if(!result.acrtionIsSuccess){
            result.acrtionMessage = g.renderErrors( bean:result.bean,as:'list')
        }
        else{
            result.forWardId = result.bean?.id.toString()
        }
        render result as JSON
    }
}
