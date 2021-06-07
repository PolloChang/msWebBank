<%--
  Created by JamesChang
  Date/檔案建立日期: 2020/2/8
  Time/檔案建立時間: 上午 07:49
  File Description/檔案描述:
--%>
<form id="form">
    <g:hiddenField name="bs100.id" value="${bs100I.id}" />
    <g:hiddenField name="bs100.version" value="${bs100I.version}" />
    <table class="table table-bordered">
        <colgroup>
            <col width="20%">
            <col width="30%">
            <col width="20%">
            <col width="30%">
        </colgroup>
        <tbody>
        <tr>
            <th class="table-info text-right" scope="row">${g.message(code: 'bs100.systype.label')}</th>
            <td>
                ${bs100I.systype}
            </td>
            <th class="table-info text-right" scope="row">${g.message(code: 'bs100.ptype.label')}</th>
            <td>
                ${bs100I.ptype}
            </td>
        </tr>
        <tr>
            <th class="table-info text-right" scope="row">${g.message(code: 'bs100.typedesc.label')}</th>
            <td colspan="3">
                <jc:textField name="bs100.typedesc" value="${bs100I.typedesc}"/>
            </td>
        </tr>
        </tbody>
    </table>
    <g:render template='/public/upDataMessage' model='[instance: bs100I]'/>
    <div class="border-top">
        <jc:bottom type="button" class="btn btn-primary" onclick="doUpdate()">${g.message(code: 'default.button.save.label')}</jc:bottom>
        <jc:bottom type="button" class="btn btn-danger" onclick="doDelete()">${g.message(code: 'default.button.delete.label')}</jc:bottom>
    </div>
</form>