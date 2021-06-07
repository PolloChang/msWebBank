<%--
  Created by JamesChang
  Date/檔案建立日期: 2020/2/7
  Time/檔案建立時間: 上午 09:45
  File Description/檔案描述:
--%>
<%@ page import="bs.Bs101" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="iframePage"/>
</head>
<body>

<form id="search">
    <div class="container-fluid" >
        <div class="row">
            <table class="table table-bordered">
                <colgroup>
                    <col width="20%">
                    <col width="30%">
                    <col width="20%">
                    <col width="30%">
                </colgroup>
                <thead>
                <tr class="bg-info">
                    <th colspan="4">
                        <icon:svg iconType="search" message="${g.message(code: 'page.default.search.label')}"/>
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th class="table-info text-right" scope="row">${g.message(code: 'bs100.systype.label')}</th>
                    <td><jc:textField name="systype" /></td>
                    <th class="table-info text-right" scope="row">${g.message(code: 'bs100.ptype.label')}</th>
                    <td>
                        <jc:textField name="ptype" />
                    </td>
                </tr>
                <tr>
                    <th class="table-info text-right" scope="row">${g.message(code: 'bs100.typedesc.label')}</th>
                    <td colspan="3"><jc:textField name="typedesc"/></td>
                </tr>

                </tbody>
                <tfoot><tr><td colspan="4">
                    <div class="btn-group btn-group-toggle" data-toggle="buttons">
                        <jc:bottom type="button" class="btn btn-outline-primary" onclick="searchFrom('searchTable','search','${createLink(action: 'filter')}')">${g.message(code: 'default.button.search.label')}</jc:bottom>
                        <jc:bottom type="button" class="btn btn-outline-info">${g.message(code: 'default.button.export.label')}</jc:bottom>
                        <jc:bottom type="button" class="btn btn-outline" onclick="clearFrom()">${g.message(code: 'default.button.clear.label')}</jc:bottom>
                    </div>
                    <div class="btn-group btn-group-toggle" data-toggle="buttons">
                        <jc:bottom onclick="changContent('${createLink(controller: "bs100", action: "creatPage")}/creat-data','creat-data');"  type="button" class="btn btn-outline-success">${g.message(code: 'default.button.create.label')}</jc:bottom>
                    </div>
                </td></tr></tfoot>
            </table>
        </div>
    </div>
</form>
<div class="m-2">

    <a id="AC" name="C" accesskey="C" href="#C" title="${message(code: 'system.free.center.label')}"> ::: </a>
    <jc:bootstrapTable id="searchTable" url="${g.createLink(controller: "bs100", action: "filter")}">
        <th data-field="ptype" data-formatter="formatterEditButton">${g.message(code: 'bs100.ptype.label')}</th>
        <th data-field="systype">${g.message(code: 'bs100.systype.label')}</th>
        <th data-field="typedesc">${g.message(code: 'bs100.typedesc.label')}</th>
    </jc:bootstrapTable>
</div>


<!-- Modal -->
<span id="modalSpan" />
<script type="text/javascript">

    /**
     * 編輯按鈕
     * @param value
     * @param row
     * @param index
     * @returns {string}
     */
    function formatterEditButton(value, row, index) {
        var btnTitle ="編輯:"+row.ptype;
        var url = "${createLink(controller:'bs100',action: "editPage")}/"+row.id;
        var onclickFunction = "changContent('"+url+"','"+row.id+"');";
        return '<button type="button" class="btn btn-info search-edit-btn" onclick="'+onclickFunction+'"><i class="mdi mdi-edit"/> '+btnTitle+'</button>';
    }
</script>
</body>
</html>