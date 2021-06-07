<%--
  Created by JamesChang
  Date/檔案建立日期: 2020/2/8
  Time/檔案建立時間: 上午 07:52
  File Description/檔案描述:bs101查詢畫面
--%>
<form id="search-form-bs101">
    <g:hiddenField name="ptype" value="${bs100I.ptype}" />
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
            <th class="table-info text-right" scope="row">${g.message(code: 'bs101.pcode.label')}</th>
            <td><jc:numberField name="pcode"/></td>
            <th class="table-info text-right" scope="row">${g.message(code: 'bs101.typedesc.label')}</th>
            <td>
                <jc:textField name="typedesc" />
            </td>
        </tr>

        </tbody>
        <tfoot><tr><td colspan="4">
            <div class="btn-group btn-group-toggle" data-toggle="buttons">
                <jc:bottom type="button" class="btn btn-outline-primary" onclick="searchFrom('searchTable-bs101L','search-form-bs101','${createLink(action: 'filterBs101',controller: 'bs100')}')">${g.message(code: 'default.button.search.label')}</jc:bottom>
                <jc:bottom type="button" class="btn btn-outline-info">${g.message(code: 'default.button.export.label')}</jc:bottom>
                <jc:bottom type="button" class="btn btn-outline" onclick="clearFrom()">${g.message(code: 'default.button.clear.label')}</jc:bottom>
            </div>
            <div class="btn-group btn-group-toggle" data-toggle="buttons">
                <jc:bottom onclick="openMondal('bs101ModalSpan','${createLink(controller: "bs100", action: "creatPageBs101",params: [ptype:bs100I.ptype])}');"  type="button" class="btn btn-outline-success">${g.message(code: 'default.button.create.label')}</jc:bottom>
            </div>
        </td></tr></tfoot>
    </table>
    <a id="AC" name="C" accesskey="C" href="#C" title="${message(code: 'system.free.center.label')}"> ::: </a>
    <jc:bootstrapTable id="searchTable-bs101L" url="${g.createLink(controller: "bs100", action: "filter")}">
        <th data-field="typedesc" data-formatter="formatterEditButton" data-width="150">${g.message(code: 'bs101.ptype.label')}</th>
        <th data-field="pcode" data-width="50">${g.message(code: 'bs101.pcode.label')}</th>
        <th data-field="ptype" data-width="200">${g.message(code: 'bs101.ptype.label')}</th>
        <th data-field="typedesc">${g.message(code: 'bs101.typedesc.label')}</th>
    </jc:bootstrapTable>
    <!-- Modal -->
    <span id="bs101ModalSpan" />
</form>
<script type="text/javascript">


    /**
     * 編輯按鈕
     * @param value
     * @param row
     * @param index
     * @returns {string}
     */
    function formatterEditButton(value, row, index) {
        var btnTitle ="<b>編輯:</b>"+row.typedesc;
        var url = "${createLink(controller:'bs100',action: "editPageBs101")}/"+row.id;
        var onclickFunction = "openMondal('bs101ModalSpan','"+url+"');";
        return '<button type="button" class="btn btn-info search-edit-btn" onclick="'+onclickFunction+'"><i class="mdi mdi-edit"/> '+btnTitle+'</button>';
    }
</script>