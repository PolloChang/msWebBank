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
                    <th class="table-info text-right" scope="row">${g.message(code: 'bsAppList.appName.label')}</th>
                    <td><jc:textField name="appName" /></td>
                    <th class="table-info text-right" scope="row">${g.message(code: 'bsAppList.appCname.label')}</th>
                    <td>
                        <jc:textField name="appCname" />
                    </td>
                </tr>
                <tr>
                    <th class="table-info text-right" scope="row">${g.message(code: 'bsAppList.status.label')}</th>
                    <td>
                        <jc:multipleSelect name="status" from="${bs.Bs101.findAllByPtype('APP_LIST_STATUS')}" optionKey="pcode" optionValue="typedesc" noSelection="['':'---']" />
                    </td>
                    <th class="table-info text-right" scope="row">${g.message(code: 'bsAppList.showOnMenu.label')}</th>
                    <td colspan="1">
                        <jc:multipleSelect name="showOnMenu" from="[
                                [key:'false',val:'不顯示'],[key:'true',val:'顯示']
                        ]" noSelection="['':'---']" optionKey="key" optionValue="val"/>
                    </td>
                </tr>
                <tr>
                    <th class="table-info text-right" scope="row">${g.message(code: 'bsAppList.parentApp.label')}</th>
                    <td colspan="1">
                        <jc:textField name="parentApp" />
                    </td>
                    <th class="table-info text-right" scope="row">${g.message(code: 'bsAppList.actionType.label')}</th>
                    <td colspan="1">
                        <jc:multipleSelect name="actionType" value=""
                                           from="[
                                                   [key:'onlyFunction',val:'單純執行程式'],[key:'isDropdown',val:'底下還有執行程式']
                                           ]" noSelection="['':'---']" optionKey="key" optionValue="val"/>
                    </td>
                </tr>
                <tr>
                    <th class="table-info text-right" scope="row">${g.message(code: 'bsAppList.controller.label')}</th>
                    <td><jc:textField name="controller"/></td>
                    <th class="table-info text-right" scope="row">${g.message(code: 'bsAppList.action.label')}</th>
                    <td colspan="1"><jc:textField name="action"/></td>
                </tr>

                </tbody>
                <tfoot><tr><td colspan="4">
                    <div class="btn-group btn-group-toggle" data-toggle="buttons">
                        <jc:bottom type="button" class="btn btn-outline-primary" onclick="searchFrom('searchTable','search','${createLink(action: 'appListFilter')}')">${g.message(code: 'default.button.search.label')}</jc:bottom>
                        <jc:bottom type="button" class="btn btn-outline-info">${g.message(code: 'default.button.export.label')}</jc:bottom>
                        <jc:bottom type="button" class="btn btn-outline" onclick="clearFrom()">${g.message(code: 'default.button.clear.label')}</jc:bottom>
                    </div>
                    <div class="btn-group btn-group-toggle" data-toggle="buttons">
                        <jc:bottom onclick="openMondal('modalSpan','${createLink(controller: "bs", action: "appListCreat")}');"  type="button" class="btn btn-outline-success">${g.message(code: 'default.button.create.label')}</jc:bottom>
                    </div>
                </td></tr></tfoot>
            </table>
        </div>
    </div>
</form>
<div class="m-2">

    <a id="AC" name="C" accesskey="C" href="#C" title="中間區域"> ::: </a>
    <jc:bootstrapTable id="searchTable" url="${g.createLink(controller: "bs", action: "appListFilter")}">
        <th data-field="id" data-formatter="formatterEditButton">${g.message(code: 'bsAppList.id.label')}</th>
        <th data-field="appName" data-formatter="">${g.message(code: 'bsAppList.appName.label')}</th>
        <th data-field="parentApp" data-formatter="">${g.message(code: 'bsAppList.parentApp.label')}</th>
        <th data-field="appCname">${g.message(code: 'bsAppList.appCname.label')}</th>
        <th data-field="controller">${g.message(code: 'bsAppList.controller.label')}</th>
        <th data-field="action">${g.message(code: 'bsAppList.action.label')}</th>
        <th data-field="status">${g.message(code: 'bsAppList.status.label')}</th>
        <th data-field="showOnMenu">${g.message(code: 'bsAppList.showOnMenu.label')}</th>
    </jc:bootstrapTable>
</div>


<!-- Modal -->
<span id="modalSpan" />
</div>
</div>
<script type="text/javascript">


    /**
     * 編輯按鈕
     * @param value
     * @param row
     * @param index
     * @returns {string}
     */
    function formatterEditButton(value, row, index) {
        var btnTitle ="<b>編輯:</b>"+row.appCname;
        var url = "${createLink(controller:'bs',action: "appListEdit")}/"+row.id;
        var onclickFunction = "openMondal('modalSpan','"+url+"');";
        return '<button type="button" class="btn btn-info search-edit-btn" onclick="'+onclickFunction+'"><i class="mdi mdi-edit"/> '+btnTitle+'</button>';
    }
</script>
</body>
</html>