<table class="table table-bordered edit-black">
    <colgroup>
        <col width="15%"/>
        <col width="35%"/>
        <col width="15%"/>
        <col width="35%"/>
    </colgroup>
    <tbody>
    <tr>
        <th scope="row" rowspan="2">
            ${message(code:"default.updateMessage.label")}
        </th>
        <td colspan="3">
            <span class="text-black-50">
                <g:formatDate date="${instance?.dateCreated}" format="yyyy-MM-dd HH24:mm:ss" />
                ${instance?.manCreated} ${message(code:"default.manCreated.label")}
            </span>
        </td>
    </tr>
    <tr>
        <td colspan="3">
            <span class="text-black-50">
                <g:formatDate date="${instance?.lastUpdated}" format="yyyy-MM-dd HH24:mm:ss" />
                ${instance?.manLastUpdated} ${message(code:"default.manLastUpdated.label")}
            </span>
        </td>
    </tr>
    </tbody>
</table>