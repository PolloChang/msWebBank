package webBaseFunction

class IconTagLib {
    static defaultEncodeAs = [taglib:'none']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    static namespace = "icon"

    /**
     * SVG 圖片
     * 圖片來源：https://material.io/resources/icons/?style=baseline
     */
    Closure svg = { attrs ->
        if (!attrs.iconType) {
            throwTagError("Tag [select] is missing required attribute [name]")
        }
        def iconType = attrs.remove('iconType')
        def width = attrs.remove('width')?:"24"
        def height = attrs.remove('height')?:"24"
        def classes = attrs.remove('class')?:""
        def message = attrs.remove('message')?:""

        def writer = out

        writer << "<svg xmlns='http://www.w3.org/2000/svg' width='${width}' height='${height}' viewBox='0 0 24 24' fill='none' stroke='currentColor' stroke-width='2' stroke-linecap='round' stroke-linejoin='round' class='${classes}'>"

        switch (iconType){
        //首頁
            case "home":
                writer << "<path d='M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z'></path><polyline points='9 22 9 12 15 12 15 22'></polyline>"
                break
        //資料夾
            case "folder":
                writer << "<path d='M10 4H4c-1.1 0-1.99.9-1.99 2L2 18c0 1.1.9 2 2 2h16c1.1 0 2-.9 2-2V8c0-1.1-.9-2-2-2h-8l-2-2z'/><path d='M0 0h24v24H0z' fill='none'/>"
                break
        //空白文件
            case "fileWhite":
                writer << "<path d='M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z'></path><polyline points='13 2 13 9 20 9'></polyline>"
                break
        //有資料的文件
            case "fileText":
                writer << "<path d='M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z'></path><polyline points='14 2 14 8 20 8'></polyline><line x1='16' y1='13' x2='8' y2='13'></line><line x1='16' y1='17' x2='8' y2='17'></line><polyline points='10 9 9 9 8 9'></polyline>"
                break
        //空購物車
            case "shoppingCart":
                writer << "<circle cx='9' cy='21' r='1'></circle><circle cx='20' cy='21' r='1'></circle><path d='M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6'></path>"
                break
        //人們
            case "peoples":
                writer << "<path d='M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2'></path><circle cx='9' cy='7' r='4'></circle><path d='M23 21v-2a4 4 0 0 0-3-3.87'></path><path d='M16 3.13a4 4 0 0 1 0 7.75'></path>"
                break
        //線條
            case "lines":
                writer << "<line x1='18' y1='20' x2='18' y2='10'></line><line x1='12' y1='20' x2='12' y2='4'></line><line x1='6' y1='20' x2='6' y2='14'></line>"
                break
        //方塊疊
            case "cube":
                writer << "<polygon points='12 2 2 7 12 12 22 7 12 2'></polygon><polyline points='2 17 12 22 22 17'></polyline><polyline points='2 12 12 17 22 12'></polyline>"
                break
        //新增
            case "add":
                writer << "<circle cx='12' cy='12' r='10'></circle><line x1='12' y1='8' x2='12' y2='16'></line><line x1='8' y1='12' x2='16' y2='12'></line>"
                break
        //儲存
            case "save":
                writer << '<path xmlns="http://www.w3.org/2000/svg" d="M0 0h24v24H0z" fill="none"/>'
                writer << '<path xmlns="http://www.w3.org/2000/svg" d="M17 3H5c-1.11 0-2 .9-2 2v14c0 1.1.89 2 2 2h14c1.1 0 2-.9 2-2V7l-4-4zm-5 16c-1.66 0-3-1.34-3-3s1.34-3 3-3 3 1.34 3 3-1.34 3-3 3zm3-10H5V5h10v4z"/>'
                break
        //儀錶板
            case "dashboard":
                writer << "<path d='M0 0h24v24H0z' fill='none'/><path d='M3 13h8V3H3v10zm0 8h8v-6H3v6zm10 0h8V11h-8v10zm0-18v6h8V3h-8z'/>"
                break
        //放大鏡
            case "search":
                writer << "<path d='M15.5 14h-.79l-.28-.27C15.41 12.59 16 11.11 16 9.5 16 5.91 13.09 3 9.5 3S3 5.91 3 9.5 5.91 16 9.5 16c1.61 0 3.09-.59 4.23-1.57l.27.28v.79l5 4.99L20.49 19l-4.99-5zm-6 0C7.01 14 5 11.99 5 9.5S7.01 5 9.5 5 14 7.01 14 9.5 11.99 14 9.5 14z'/><path d='M0 0h24v24H0z' fill='none'/>"
                break
        //關閉
            case "close":
                writer << '<path d="M19 6.41L17.59 5 12 10.59 6.41 5 5 6.41 10.59 12 5 17.59 6.41 19 12 13.41 17.59 19 19 17.59 13.41 12z"/>'
                writer << '<path d="M0 0h24v24H0z" fill="none"/>'
                break
        //預設：有資料的文件
            default:
                writer << "<path d='M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z'></path><polyline points='14 2 14 8 20 8'></polyline><line x1='16' y1='13' x2='8' y2='13'></line><line x1='16' y1='17' x2='8' y2='17'></line><polyline points='10 9 9 9 8 9'></polyline>"
        }
        writer << "</svg>"
        writer << "&nbsp;${message}"
    }

}
