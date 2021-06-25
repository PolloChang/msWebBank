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
        """
    }
}
