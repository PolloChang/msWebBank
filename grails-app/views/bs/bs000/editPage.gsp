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
<form id="bs000-form">
    <g:hiddenField name="bs000.id" value="${bs000I?.id}"/>
    <g:hiddenField name="bs000.version" value="${bs000I?.version}"/>
    <g:render template="/domainFroms/bs/bs000" model="[bs000I:bs000I]" />
    <g:render template='/public/updateMessage' model='[instance: bs000I]'/>
</form>
<div>
    <div class="btn-group" role="group">
        <bootstrap:button name="save" showText="${message(code: "default.button.save.label")}"
                          onclick="saveData('bs000-form','${createLink(controller: "bs" ,action: "bs000Update")}');"
        />
        <bootstrap:button name="delete" showText="${message(code: "default.button.delete.label")}" class="btn-danger"
                          onclick="deleteData('bs000-form','${createLink(controller: "bs" ,action: "bs000Delete")}','${message(code: "default.button.delete.confirm.message")}');"
        />
    </div>
</div>
<script type="text/javascript">

</script>
</body>
</html>