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
            ${message(code: "ex100.numbers.label")}
        </th>
        <td>
            <bootstrap:numberField name="ex100.numbers" value="${ex100I?.numbers}" />
        </td>
        <th>
            ${message(code: "ex100.amts.label")}
        </th>
        <td>
            <bootstrap:numberField name="ex100.amts" value="${ex100I?.amts}" />
        </td>
    </tr>
    <tr>
        <th>
            ${message(code: "ex100.string.label")}
        </th>
        <td>
            <bootstrap:textField name="ex100.string" value="${ex100I?.string}" />
        </td>
        <th>
            ${message(code: "ex100.status.label")}
        </th>
        <td>
            <bootstrap:multipleSelect
                    name="ex100.status" value="${ex100I?.status}"
                    from="${bs.Bs101.findAllByPtype('EX100_STSTUS')}"
                    optionKey="pcode" optionValue="typedesc"
                    noSelection="['':'---']"
            />
        </td>
    </tr>
    <tr>
        <th>
            ${message(code: "ex100.texts.label")}
        </th>
        <td colspan="3">
            <bootstrap:textarea name="ex100.texts" value="${ex100I?.texts}" />
        </td>
    </tr>
    <tr>
        <th>
            ${message(code: "ex100.idno.label")}
        </th>
        <td>
            <bootstrap:textField name="ex100.idno" value="${ex100I?.idno}" />
        </td>
        <th>
            ${message(code: "ex100.name.label")}
        </th>
        <td>
            <bootstrap:textField name="ex100.name" value="${ex100I?.name}" />
        </td>
    </tr>
    <tr>
        <th>
            ${message(code: "ex100.sex.label")}
        </th>
        <td>
            <bootstrap:multipleSelect
                    name="ex100.sex" value="${ex100I?.sex}"
                    from="${bs.Bs101.findAllByPtype('GENDER')}"
                    optionKey="pcode" optionValue="typedesc"
                    noSelection="['':'---']"
            />
        </td>
        <th>
            ${message(code: "ex100.birthday.label")}
        </th>
        <td>
            <bootstrap:datepicker name="ex100.birthday" value="${ex100I?.birthday}" />
        </td>
    </tr>
    <tr>
        <th>
            ${message(code: "ex100.unid.label")}
        </th>
        <td colspan="3">
            <bootstrap:textField name="ex100.unid" value="${ex100I?.unid}" />
        </td>
    </tr>
    <tr>
        <th>
            ${message(code: "ex100.addr.label")}
        </th>
        <td colspan="3">
            <bootstrap:addressSelect
                    nameZip="ex100.zip" valueZip="${ex100I?.zip}"
                    nameCitycode="ex100.citycode" valueCitycode="${ex100I?.citycode}"
                    nameTwnspcode="ex100.twnspcode" valueTwnspcode="${ex100I?.twnspcode}"
                    nameVilgcode="ex100.vilgcode" valueVilgcode="${ex100I?.vilgcode}"
            />
            <bootstrap:textField name="ex100.rode" value="${ex100I?.rode}" placeholder="${message(code: "ex100.rode.label")}" />
            <bootstrap:textField name="ex100.addr" value="${ex100I?.addr}" placeholder="${message(code: "ex100.addr.label")}" />
        </td>
    </tr>
    </tbody>
</table>