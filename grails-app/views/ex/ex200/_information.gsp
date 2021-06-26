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
            ${ex100I?.numbers}
        </td>
        <th>
            ${message(code: "ex100.amts.label")}
        </th>
        <td>
            ${ex100I?.amts}
        </td>
    </tr>
    <tr>
        <th>
            ${message(code: "ex100.string.label")}
        </th>
        <td>
            ${ex100I?.string}
        </td>
        <th>
            ${message(code: "ex100.status.label")}
        </th>
        <td>
            ${ex100I?.statusDesc}
        </td>
    </tr>
    </tbody>
</table>