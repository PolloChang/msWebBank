package bootstrap

class ElementTagLib {
    static defaultEncodeAs = [taglib:'none']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    static namespace = "bootstrap"

    /**
     * table
     */
    Closure table = { attrs,body ->

        if (!attrs.name) {
            throwTagError("Tag [textField] is missing required attribute [name]")
        }

        String name = attrs.remove("name")
        String id = attrs.remove("id")?:name
        String toggle = attrs.remove("toggle")?:"table"
        boolean search = attrs.remove("search")?:false
        boolean pagination = attrs.remove("pagination")?:true
        String pageList = attrs.remove("pageList")?:"[10, 25, 50, 100, 200, All]"

        out << """
            <table
                id="${id}"
                name="${name}"
                data-toggle="${toggle}"
                data-search="${search}"
                data-pagination="${pagination}"
                data-page-list="${pageList}"
            >
            <thead>
            <tr>
            <th data-formatter="formatterDataSerialNumber">#</th>
            """
        out << body()
        out << """
            </tr>
            </thead>
        </table>
        <script type='text/javascript'>
            jQuery(document.getElementById('${id}')).bootstrapTable();
        </script>
        """
    }

    /**
     * 系統說明
     */
    Closure systemInfo = { attrs, body ->

        out << """
        <div class="border border">
            <p class="border border-top-0 border-left-0 border-right-0 bg-light">系統說明</p>
        """
        out << body()
        out << """
        </div>
        """
    }
}
