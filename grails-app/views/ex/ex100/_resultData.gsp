<table id="table">
    <thead>
    <tr>
        <th data-field="id">ID</th>
        <th data-field="name">Item Name</th>
        <th data-field="price">Item Price</th>
    </tr>
    </thead>
</table>
<script>
    var $table = $('#table')

    $(function() {
        var data = [
            {
                'id': 0,
                'name': 'Item 0',
                'price': '$0'
            },
            {
                'id': 1,
                'name': 'Item 1',
                'price': '$1'
            },
            {
                'id': 2,
                'name': 'Item 2',
                'price': '$2'
            },
            {
                'id': 3,
                'name': 'Item 3',
                'price': '$3'
            },
            {
                'id': 4,
                'name': 'Item 4',
                'price': '$4'
            },
            {
                'id': 5,
                'name': 'Item 5',
                'price': '$5'
            }
        ]
        $table.bootstrapTable({data: data})
    });
</script>