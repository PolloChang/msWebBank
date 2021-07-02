<%--
  新增資料頁面
  Created by IntelliJ IDEA.
  User: JamesChang
  Date: 2021/4/4
  Time: 下午 11:13
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="iframePage"/>
</head>
<body>
<div>
    <icon:svg iconType="modeEdit" message="${message(code: "bs000.label")}"/>
</div>
<div id="message" />
<div class="p-2 border">
    <g:render template="/bs/bs000/information" model="[bs000I:bs000I]" />

</div>
<div class="mt-3 p-2">
    <ul class="nav nav-tabs" id="edit-tabs" role="tablist">
        <li class="nav-item" role="presentation">
            <a
               id="tab1"
               class="nav-link active"
               href="#tab1-content"
               data-toggle="tab"
               data-type="editTab"
               data-url="${createLink(controller: "bs", action:"tab1",params: [id:bs000I.id])}"
            >
                ${message(code: "bs000.page.edit.tab1.label")}
            </a>
        </li>
        <li class="nav-item" role="presentation">
            <a
               id="tab2"
               class="nav-link"
               href="#tab2-content"
               data-toggle="tab"
               data-type="editTab"
               data-url="${createLink(controller: "bs", action:"tab2",params: [id:bs000I.id])}"
            >
                ${message(code: "bs000.page.edit.tab2.label")}
            </a>
        </li>
    </ul>
    <div class="tab-content" id="myTabContent">
        <div class="tab-pane fade active show" id="tab1-content" role="tabpanel" ></div>
        <div class="tab-pane fade" id="tab2-content" role="tabpanel" ></div>
    </div>
</div>
<script type="text/javascript">

    

</script>
</body>
</html>