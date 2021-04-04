package sys.toolBox

import grails.converters.JSON

/**
 * 工具箱
 * @author JamesChang
 * @since Grails4.0.1
 */
class ToolBoxController {

    def toolBoxService

    /**
     * 取得鄉鎮市行政區清單
     */
    def getBs201Select = {
        String whereBs200Code = params?.whereItem
        def result = toolBoxService.getBs2xxSelect("Bs201",whereBs200Code)
        def exportData = []
        exportData << [text:'---',value:'']
        result.dataBean.eachWithIndex{ value,index ->
            exportData << [text:"${index+1}:${value?.textShow}",value:value?.code]
        }
        result.exportData = exportData
        render result as JSON
    }

    /**
     * 取得里別區清單
     */
    def getBs202Select = {
        String whereBs201Code = params?.whereItem
        def result = toolBoxService.getBs2xxSelect("Bs202",whereBs201Code)
        def exportData = []
        exportData << [text:'---',value:'']
        result.dataBean.eachWithIndex{ value,index ->
            exportData << [text:"${index+1}:${value?.textShow}",value:value?.code]
        }
        result.exportData = exportData
        render result as JSON
    }
}
