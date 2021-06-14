<table
        id="search-result"
        data-toggle="table"
        data-search="true"
        data-pagination="true"
        data-page-list="[10, 25, 50, 100, 200, All]"
>
    <thead>
    <tr>
        <th data-formatter="formatterDataSerialNumber">#</th>
        <th data-field="id" data-formatter="editDataFormatter">${g.message(code: 'bs000.id.label')}</th>
        <th data-field="appName" data-formatter="">${g.message(code: 'bs000.appName.label')}</th>
        <th data-field="parentApp" data-formatter="">${g.message(code: 'bs000.parentApp.label')}</th>
        <th data-field="appCname">${g.message(code: 'bs000.appCname.label')}</th>
        <th data-field="controller">${g.message(code: 'bs000.controller.label')}</th>
        <th data-field="action">${g.message(code: 'bs000.action.label')}</th>
        <th data-field="status">${g.message(code: 'bs000.status.label')}</th>
        <th data-field="showOnMenu">${g.message(code: 'bs000.showOnMenu.label')}</th>
    </tr>
    </thead>
</table>
<script>



    $(function() {

    });
</script>