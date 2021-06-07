<%--
  Created by JamesChang
  Date/檔案建立日期: 2020/2/8
  Time/檔案建立時間: 下午 11:04
  File Description/檔案描述: bs101 選單共用頁面
--%>
<table class="table table-bordered">
    <colgroup>
        <col width="20%">
        <col width="30%">
        <col width="20%">
        <col width="30%">
    </colgroup>
    <thead>
    </thead>
    <tbody>
    <tr>
        <th class="table-info text-right" scope="row">${g.message(code: 'bs101.typedesc.label')}</th>
        <td>
            <jc:textField name="bs101.typedesc" value="${bs101I?.typedesc}" readonly="${readonly}" />
        </td>
        <th class="table-info text-right" scope="row">${g.message(code: 'bs101.idx.label')}</th>
        <td>
            <jc:numberField name="bs101.idx" value="${bs101I?.idx}" readonly="${readonly}" />
        </td>
    </tr>
    <tr>
        <th class="table-info text-right" scope="row">${g.message(code: 'bs101.exceptionString1.label')}</th>
        <td colspan="3">
            <jc:textField name="bs101.exceptionString1" value="${bs101I?.exceptionString1}" readonly="${readonly}" />
        </td>
    </tr>
    <tr>
        <th class="table-info text-right" scope="row">${g.message(code: 'bs101.exceptionString2.label')}</th>
        <td colspan="3">
            <jc:textField name="bs101.exceptionString2" value="${bs101I?.exceptionString2}" readonly="${readonly}" />
        </td>
    </tr>
    <tr>
        <th class="table-info text-right" scope="row">${g.message(code: 'bs101.exceptionString3.label')}</th>
        <td colspan="3">
            <jc:textField name="bs101.exceptionString3" value="${bs101I?.exceptionString3}" readonly="${readonly}" />
        </td>
    </tr>
    <tr>
        <th class="table-info text-right" scope="row">${g.message(code: 'bs101.exceptionInt1.label')}</th>
        <td colspan="3">
            <jc:numberField name="bs101.exceptionInt1" value="${bs101I?.exceptionInt1}" readonly="${readonly}" />
        </td>
    </tr>
    <tr>
        <th class="table-info text-right" scope="row">${g.message(code: 'bs101.exceptionInt2.label')}</th>
        <td colspan="3">
            <jc:numberField name="bs101.exceptionInt2" value="${bs101I?.exceptionInt2}" readonly="${readonly}" />
        </td>
    </tr>
    <tr>
        <th class="table-info text-right" scope="row">${g.message(code: 'bs101.exceptionInt3.label')}</th>
        <td colspan="3">
            <jc:numberField name="bs101.exceptionInt3" value="${bs101I?.exceptionInt3}" readonly="${readonly}" />
        </td>
    </tr>
    <tr>
        <th class="table-info text-right" scope="row">${g.message(code: 'bs101.remark.label')}</th>
        <td colspan="3">
            <jc:textarea name="bs101.remark" value="${bs101I?.remark}" readonly="${readonly}" />
        </td>
    </tr>
    </tbody>
</table>