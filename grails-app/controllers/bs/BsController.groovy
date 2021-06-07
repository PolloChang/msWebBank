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
}
