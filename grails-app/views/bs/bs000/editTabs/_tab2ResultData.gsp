<bootstrap:table name="tab2-search-result">
    <th data-field="id" data-formatter="editDataFormatter">${message(code:"default.button.edit.label")}</th>
    <th data-field="configAttribute" data-formatter="">${g.message(code: 'requestMap.configAttribute.label')}</th>
    <th data-field="httpMethod" data-formatter="">${g.message(code: 'requestMap.httpMethod.label')}</th>
    <th data-field="url">${g.message(code: 'requestMap.url.label')}</th>
</bootstrap:table>