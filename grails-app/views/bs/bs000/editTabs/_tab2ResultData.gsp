<bootstrap:table name="tab2-search-result">
    <th data-field="id" data-formatter="editDataFormatter2">${message(code:"default.button.edit.label")}</th>
    <th data-field="configAttribute" data-formatter="">${g.message(code: 'requestMap.configAttribute.label')}</th>
    <th data-field="httpMethod" data-formatter="">${g.message(code: 'requestMap.httpMethod.label')}</th>
    <th data-field="url">${g.message(code: 'requestMap.url.label')}</th>
</bootstrap:table>
<script type="text/javascript">

    function editDataFormatter2(value,row, index){
        return [
            '<button type="button" class="btn btn-primary" ',
            ' data-active="buttonActive" ',
            ' data-action="openModel" ',
            ' data-modelid="edit-model" ',
            ' data-url="${createLink(controller: "bs",action: "editRequestMapModel")}/',
            ''+row.id+'">',
            '編輯',
            '</button>'
        ].join('');
    }

</script>