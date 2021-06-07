<table class="table table-bordered">
    <colgroup>
        <col width="20%">
        <col width="30%">
        <col width="20%">
        <col width="30%">
    </colgroup>
    <tbody>
    <tr>
        <th class="table-info text-right" scope="row">${g.message(code: 'bsAppList.appName.label')}</th>
        <td colspan="3">
            <jc:textField name="bsAppList.appName" value="${bsAppListI?.appName}" readonly="${readonly}" />
        </td>
    </tr>
    <tr>
        <th class="table-info text-right" scope="row">${g.message(code: 'bsAppList.appCnameI18n.label')}</th>
        <td><jc:textField name="bsAppList.appCnameI18n" value="${bsAppListI?.appCnameI18n}" readonly="${readonly}" /></td>
        <th class="table-info text-right" scope="row">${g.message(code: 'bsAppList.appCname.label')}</th>
        <td>
            <jc:textField name="bsAppList.appCname" value="${bsAppListI?.appCname}" readonly="${readonly}" />
        </td>
    </tr>
    <tr>
        <th class="table-info text-right" scope="row">${g.message(code: 'bsAppList.controller.label')}</th>
        <td>
            <jc:multipleSelect name="bsAppList.controller" value="${bsAppListI?.controller}"
                           from="${grailsApplication.controllerClasses.sort { it.fullName } }"
                           optionKey="logicalPropertyName" optionValue="fullName" noSelection="['':'---']" readonly="${readonly}" />
        </td>
        <th class="table-info text-right" scope="row">${g.message(code: 'bsAppList.action.label')}</th>
        <td>
            <jc:textField name="bsAppList.action" value="${bsAppListI?.action}" readonly="${readonly}" />
        </td>
    </tr>
    <tr>
        <th class="table-info text-right" scope="row">${g.message(code: 'bsAppList.idx.label')}</th>
        <td><jc:numberField name="bsAppList.idx" value="${bsAppListI?.idx}" readonly="${readonly}" /></td>
        <th class="table-info text-right" scope="row">${g.message(code: 'bsAppList.parentApp.label')}</th>
        <td>
            <jc:multipleSelect name="bsAppList.parentApp" value="${bsAppListI?.parentApp}" from="${bs.BsAppList.findAllByIssureAndAppNameIsNotNullAndActionType(2,'isDropdown')}"
                           optionKey="appName" optionValue="appCname" noSelection="['':'---']" readonly="${readonly}" />
        </td>
    </tr>
    <tr>
        <th class="table-info text-right" scope="row">${g.message(code: 'bsAppList.status.label')}</th>
        <td>
            <jc:multipleSelect name="bsAppList.status" value="${bsAppListI?.status}" from="${bs.Bs101.findAllByPtype('APP_LIST_STATUS')}" optionKey="pcode" optionValue="typedesc" noSelection="['':'---']" readonly="${readonly}" />
        </td>
        <th class="table-info text-right" scope="row">${g.message(code: 'bsAppList.showOnMenu.label')}</th>
        <td>
            <jc:multipleSelect name="bsAppList.showOnMenu" value="${bsAppListI?.showOnMenu}" class="" from="[[key:'false',val:'不顯示'],[key:'true',val:'顯示']]" noSelection="['':'---']" optionKey="key" optionValue="val"/>
        </td>
    </tr>
    <tr>
        <th class="table-info text-right" scope="row">
            ${g.message(code: 'bsAppList.actionType.label')}
        </th>
        <td colspan="3">
            <jc:multipleSelect name="bsAppList.actionType" value="${bsAppListI?.actionType}"
                           from="[
                                   [key:'onlyFunction',val:'單純執行程式'],[key:'isDropdown',val:'底下還有執行程式']
                           ]" noSelection="['':'---']" optionKey="key" optionValue="val"/>
        </td>
    </tr>
    </tbody>
</table>