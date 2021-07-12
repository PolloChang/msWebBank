<g:hiddenField name="ex110.id" value="${ex110I?.id}"/>
<g:hiddenField name="ex110.version" value="${ex110I?.version}"/>
<g:hiddenField name="ex110.ex100IId" value="${ex110I?.ex100IId}"/>
<bootstrap:fromTable>
    <tbody>
    <tr>
        <th>
            ${message(code: "ex110.string.label")}
        </th>
        <td colspan="3">
            <bootstrap:textField name="ex110.string" value="${ex110I?.string}" />
        </td>
    </tr>
    </tbody>
</bootstrap:fromTable>