<%--
  Created by IntelliJ IDEA.
  User: jameschang
  Date: 2021/6/25
  Time: 下午10:42
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="iframePage"/>
</head>
<body>
<div>
    <icon:svg iconType="modeEdit" message="${message(code: "ex100.label")}"/>
</div>
<div id="message" />
<div class="p-2 border">
    <g:render template="/ex/ex200/information" model="[ex100I:ex100I]" />
    <div class="btn-group" role="group">
        <bootstrap:button name="button1" showText="按鈕1"/>
        <bootstrap:button name="button2" showText="按鈕2"/>
    </div>
</div>

<div class="mt-3 p-2">
    <ul class="nav nav-tabs" role="tablist">
        <li class="nav-item" role="presentation">
            <a id="tab1"
               class="nav-link active"
               href="#tab1-content"
               data-toggle="tab"
               data-type="editTab"
               data-url="${createLink(controller: "ex200", action:"tab1",params: [id:ex100I.id])}"
            >
                Tab1
            </a>
        </li>
        <li class="nav-item" role="presentation">
            <a id="tab2"
               class="nav-link"
               href="#tab2-content"
               data-toggle="tab"
               data-type="editTab"
               data-url="${createLink(controller: "ex200", action:"tab2",params: [id:ex100I.id])}"
            >
                Tab2
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