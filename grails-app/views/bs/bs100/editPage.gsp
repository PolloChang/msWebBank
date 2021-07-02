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
    <icon:svg iconType="modeEdit" message="${message(code: "bs100.label")}"/>
</div>
<div id="message">
</div>
<form id="bs100-form">
    <g:hiddenField name="bs100.id" value="${bs100I?.id}"/>
    <g:hiddenField name="bs100.version" value="${bs100I?.version}"/>
    <g:render template="/domainFroms/bs/bs100" model="[bs100I:bs100I]" />
    <g:render template='/public/updateMessage' model='[instance: bs100I]'/>
</form>
<div>
    <div class="btn-group" role="group">
        <bootstrap:button name="save" showText="${message(code: "default.button.save.label")}"
                          onclick="saveData('bs100-form','${createLink(controller: "bs100" ,action: "bs100Update")}');"
        />
        <bootstrap:button name="delete" showText="${message(code: "default.button.delete.label")}" class="btn-danger"
                          onclick="deleteData('bs100-form','${createLink(controller: "bs100" ,action: "bs100Delete")}','${message(code: "default.button.delete.confirm.message")}');"
        />
    </div>
</div>
<script type="text/javascript">

</script>
</body>
</html>