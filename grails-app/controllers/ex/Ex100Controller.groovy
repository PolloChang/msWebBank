package ex

class Ex100Controller {

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
}
