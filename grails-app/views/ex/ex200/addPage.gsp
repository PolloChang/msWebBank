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
<form id="ex200-form">
    <g:render template="/domainFroms/ex/ex100" model="[ex100I:ex100I]" />
</form>
<div>
    <div class="btn-group" role="group">
        <bootstrap:button
                name="save" showText="${message(code: "default.button.save.label")}"
                onclick="saveData('ex200-form','${createLink(controller: "ex200" ,action: "ex100Insert")}');"
        />
    </div>
</div>
<script type="text/javascript">

</script>
</body>
</html>