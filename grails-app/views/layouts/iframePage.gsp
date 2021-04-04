
%{--iframe專有--}%
<!doctype html>
<html lang="zh-TW" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>
    <asset:stylesheet src="iframe.css"/>
    <g:layoutHead/>
    <asset:javascript src="application.js"/>
</head>
<g:set var="appItem" value="${bs.Bs000.findByControllerAndAction(controllerName,actionName)}" />
<body>
<a id="AU" name="U" accesskey="U" href="#U" title="${message(code: 'system.free.up.label')}">:::</a>
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item active" aria-current="page">
            ${g.message(code: "page.${controllerName}.${actionName}.label")}[${controllerName}/${actionName}]
        </li>
    </ol>
</nav>

<div id="content-parent">
    <div id="content-main">
        <g:layoutBody/>
    </div>
</div>
<script type="text/javascript">
    /**
     * 一進入頁面執行
     */
    $(function() {
        $(".searchForm .form-group").addClass("border");
    });
</script>
</body>
</html>
