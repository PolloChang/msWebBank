<%--
  Created by IntelliJ IDEA.
  User: jameschang
  Date: 2021/6/7
  Time: 下午5:16
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="iframePage"/>
</head>
<body>
<form id="search">

    <div>
        <icon:svg iconType="search" message="查詢條件"/>
    </div>
    <div class="searchForm">
        <div class="form-group row">
            <bootstrap:formItem labelTitle="${g.message(code: 'bsAppList.status.label')}" name="statusSelect" inputType="contents" >
                <g:select name="status" id="status"
                          from="${bs.Bs101.findAllByPtype('APP_LIST_STATUS')}" optionKey="pcode" optionValue="typedesc" noSelection="['':'---']"
                          class="form-control"
                />
            </bootstrap:formItem>
            <bootstrap:formItem labelTitle="${g.message(code: 'bsAppList.showOnMenu.label')}" name="showOnMenuSelect" inputType="contents" >
                <g:select name="showOnMenu" id="showOnMenu"
                          from="${bs.Bs101.findAllByPtype('APP_LIST_STATUS')}" optionKey="pcode" optionValue="typedesc" noSelection="['':'---']"
                          class="form-control"
                />
            </bootstrap:formItem>
        </div>

        <div class="form-group row">
            <div class="btn-group" role="group">
                <bootstrap:button name="search" onclick="searchData()" showText="查詢"/>
                <bootstrap:button name="clear" inputType="clear" class="btn-light" showText="清除條件"/>
                <bootstrap:button name="print" class="btn-secondary" showText="匯出"/>
            </div>
            <div class="btn-group" role="group">
                <bootstrap:button name="add-data" class="btn-success" showText="新增" onclick="addData();"/>
            </div>
        </div>
    </div>

    <div>
        <icon:svg iconType="list" message="查詢結果"/>
    </div>
    <div class="searchForm">
        <g:render template="/bs/bs000/resultData" />
    </div>
</form>

<script type="text/javascript">

    /**
     * action: 新增資料
     */
    function addData() {
        parent.changeIframeMain('${createLink(controller: 'ex100',action: 'addPage')}','blank','新增頁面');
    }


    function editData(id,showPageName) {
        parent.changeIframeMain('${createLink(controller: 'ex100',action: 'editPage')}/'+id,id,showPageName);
    }

    /**
     * action: 查詢
     */
    function searchData() {
        $('#search-result').bootstrapTable('refresh', {
            url: '${createLink(controller: 'ex100' ,action: 'filter')}/?' + $('#search').serialize()
        });
    }
</script>

</body>
</html>
