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
        <icon:svg iconType="modeEdit" message="${message(code: "ex100.label")}"/>
    </div>
    <form id="ex100-form">
        <table class="table edit-black">
            <tbody>
            <tr>
                <th>
                    ${message(code: "ex100.numbers.label")}
                </th>
                <td>
                    <bootstrap:numberField name="ex100.numbers" value="" />
                </td>
                <th>
                    ${message(code: "ex100.amts.label")}
                </th>
                <td>
                    <bootstrap:textField name="ex100.amts" value="" />
                </td>
            </tr>
            <tr>
                <th>
                    ${message(code: "ex100.string.label")}
                </th>
                <td>
                    <bootstrap:numberField name="ex100.string" value="" />
                </td>
                <th>
                    ${message(code: "ex100.status.label")}
                </th>
                <td>
                    <bootstrap:multipleSelect
                            name="ex100.status" value=""
                            from="${[[key:'',val:'---']]}"
                            optionKey="key" optionValue="val"
                    />
                </td>
            </tr>
            <tr>
                <th>
                    ${message(code: "ex100.texts.label")}
                </th>
                <td colspan="3">
                    <bootstrap:textarea name="ex100.texts" value="" />
                </td>
            </tr>
            <tr>
                <th>
                    ${message(code: "ex100.idno.label")}
                </th>
                <td>
                    <bootstrap:textField name="ex100.idno" value="" />
                </td>
                <th>
                    ${message(code: "ex100.name.label")}
                </th>
                <td>
                    <bootstrap:textField name="ex100.name" value="" />
                </td>
            </tr>
            <tr>
                <th>
                    ${message(code: "ex100.sex.label")}
                </th>
                <td>
                    <bootstrap:multipleSelect
                            name="ex100.sex" value=""
                            from="${[[key:'',val:'---']]}"
                            optionKey="key" optionValue="val"
                    />
                </td>
                <th>
                    ${message(code: "ex100.birthday.label")}
                </th>
                <td>
                    <bootstrap:datepicker name="ex100.birthday" value="${new Date()}" />
                </td>
            </tr>
            <tr>
                <th>
                    ${message(code: "ex100.unid.label")}
                </th>
                <td colspan="3">
                    <bootstrap:textField name="ex100.unid" value="" />
                </td>
            </tr>
            <tr>
                <th>
                    ${message(code: "ex100.addr.label")}
                </th>
                <td colspan="3">
                    <bootstrap:addressSelect
                            nameZip="ex100.zip" valueZip=""
                            nameCitycode="ex100.citycode" valueCitycode=""
                            nameTwnspcode="ex100.twnspcode" valueTwnspcode=""
                            nameVilgcode="ex100.vilgcode" valueVilgcode=""
                    />
                    <bootstrap:textField name="ex100.rode" value="" placeholder="${message(code: "ex100.rode.label")}" />
                    <bootstrap:textField name="ex100.addr" value="" placeholder="${message(code: "ex100.addr.label")}" />
                </td>
            </tr>
            </tbody>
        </table>
    </form>
    <div>
        <div class="btn-group" role="group">
            <bootstrap:button name="save" showText="儲存" onclick="save('ex100-form');"/>
        </div>
    </div>
</body>
</html>