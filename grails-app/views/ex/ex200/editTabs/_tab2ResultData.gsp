<bootstrap:table name="tab2-search-result">
    <th data-field="id" data-formatter="editDataFormatter2" >${message(code: "default.button.edit.label")}</th>
    <th data-field="string">${message(code: "ex100.string.label")}</th>
</bootstrap:table>
<script type="text/javascript">

    function editDataFormatter2(value,row, index){
        return [
            '<button type="button" class="btn btn-primary" ',
            ' data-active="buttonActive" ',
            ' data-action="openModel" ',
            ' data-modelid="edit-model" ',
            ' data-url="${createLink(controller: "ex200",action: "editEx110Model")}/',
            ''+row.id+'">',
            '編輯',
            '</button>'
        ].join('');
    }

</script>