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
    <icon:svg iconType="modeEdit" message="${message(code: "ex100.label")}"/>
</div>
<div id="message">
</div>
<form id="ex100-form">
    <g:hiddenField name="ex100.id" value="${ex100I?.id}"/>
    <g:hiddenField name="ex100.version" value="${ex100I?.version}"/>
    <g:render template="/ex/ex100/form" model="[ex100I:ex100I]" />
</form>
<div>
    <div class="btn-group" role="group">
        <bootstrap:button name="save" showText="儲存" onclick="saveData('ex100-form','${createLink(controller: "ex100" ,action: "ex100Update")}');"/>
    </div>
</div>
<script type="text/javascript">

</script>
</body>
</html>