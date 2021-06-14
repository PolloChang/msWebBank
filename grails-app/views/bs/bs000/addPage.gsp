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
    <div id="message">
    </div>
    <form id="bs000-form">
        <g:render template="/domainFroms/bs/bs000" model="[bs000I:bs000I]" />
    </form>
    <div>
        <div class="btn-group" role="group">
            <bootstrap:button name="save" showText="${message(code: "default.button.save.label")}"
                              onclick="saveData('bs000-form','${createLink(controller: "bs" ,action: "bs000Insert")}');"
            />
        </div>
    </div>
    <script type="text/javascript">

    </script>
</body>
</html>