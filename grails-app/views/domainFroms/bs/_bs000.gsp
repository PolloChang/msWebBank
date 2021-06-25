<table class="table table-bordered edit-black">
    <colgroup>
        <col width="15%"/>
        <col width="35%"/>
        <col width="15%"/>
        <col width="35%"/>
    </colgroup>
    <tbody>
    <tr>
        <th>
           ${message(code: "bs000.appName.label")}
        </th>
        <td>
            <bootstrap:textField name="bs000.appName" value="${bs000I.appName}" />
        </td>
        <th>
            ${message(code:"bs000.parentApp.label")}
        </th>
        <td>
            <bootstrap:multipleSelect
                    name="bs000.parentApp" value="${bs000I?.parentApp}"
                    from="${bs.Bs000?.findAllByActionType('isDropdown')}"
                    optionKey="appName" optionValue="appCname"
                    noSelection="['':'---']"
            />
        </td>
    </tr>
    <tr>
        <th>
            ${message(code:"bs000.appCnameI18n.label")}
        </th>
        <td>
            <bootstrap:textField name="bs000.appCnameI18n" value="${bs000I.appCnameI18n}" />
        </td>
        <th>
            ${message(code:"bs000.appCname.label")}
        </th>
        <td>
            <bootstrap:textField name="bs000.appCname" value="${bs000I.appCname}" />
        </td>
    </tr>
    <tr>
        <th>
            ${message(code:"bs000.controller.label")}
        </th>
        <td>
            <bootstrap:multipleSelect
                    name="bs000.controller" value="${bs000I?.controller}"
                    from="${grailsApplication.controllerClasses.sort { it.fullName }}"
                    optionKey="logicalPropertyName" optionValue="fullName"
                    noSelection="['':'未設定']"
            />
        </td>
        <th>
            ${message(code:"bs000.action.label")}
        </th>
        <td>
            <bootstrap:textField name="bs000.action" value="${bs000I.action}"/>
        </td>
    </tr>
    <tr>
        <th>
            ${message(code:"bs000.idx.label")}
        </th>
        <td>
            <bootstrap:numberField name="bs000.idx" value="${bs000I.idx}" />
        </td>
        <th>
            ${message(code:"bs000.actionType.label")}
        </th>
        <td>
            <bootstrap:multipleSelect
                    name="bs000.actionType" value="${bs000I?.actionType}"
                    from="${bs.Bs101.findAllByPtype('BS000_ACTION_TYPE')}"
                    optionKey="pcode" optionValue="typedesc"
                    noSelection="['':'---']"
            />
        </td>
    </tr>
    <tr>
        <th>
            ${message(code:"bs000.status.label")}
        </th>
        <td>
            <bootstrap:multipleSelect
                    name="bs000.status" value="${bs000I?.status}"
                    from="${bs.Bs101.findAllByPtype('APP_LIST_STATUS')}"
                    optionKey="pcode" optionValue="typedesc"
                    noSelection="['':'---']"
            />
        </td>
        <th>
            ${message(code:"bs000.showOnMenu.label")}
        </th>
        <td>
            <bootstrap:multipleSelect
                    name="bs000.showOnMenu" value="${bs000I?.showOnMenu}"
                    from="[[key:'false',val:'不顯示'],[key:'true',val:'顯示']]"
                    optionKey="key" optionValue="val"
                    noSelection="['':'---']"
                />
        </td>
    </tr>
    </tbody>
</table>