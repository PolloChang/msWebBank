<form id="tab2-search">
    <div>
        <icon:svg iconType="search" message="${message(code: "default.icon.search.label")}"/>
    </div>
    <div class="searchForm">
        <g:hiddenField name="ex100Id" value="${ex100I?.id}"/>
        <bootstrap:fromTable>
            <tbody>
            <tr>
                <td colspan="4">
                    <div class="btn-group" role="group">

                        <bootstrap:button
                                name="search"
                                data-active="buttonActive"
                                data-action="dofunction"
                                data-onclick="tab2SearchData()"
                                showText="${message(code:"default.button.refresh.label")}"
                        />
                        <bootstrap:button name="clear" inputType="clear" class="btn-light" showText="清除條件"/>
                        <bootstrap:button name="print" class="btn-secondary" showText="匯出"/>
                    </div>
                    <div class="btn-group" role="group">
                        <bootstrap:button
                                name="add"
                                class="btn-success"
                                data-active="buttonActive"
                                data-action="openModel"
                                data-modelid="edit-model"
                                data-url="${createLink(controller: "ex200",action: "addEx110Model",params: [id:ex100I?.id])}"
                                showText="${message(code: "default.button.create.label")}"
                        />
                    </div>
                </td>
            </tr>
            </tbody>
        </bootstrap:fromTable>
    </div>
    <div>
        <icon:svg iconType="list" message="${message(code: "default.icon.list.label")}"/>
    </div>
    <div class="searchForm">
        <g:render template="/ex/ex200/editTabs/tab2ResultData" />
    </div>
</form>
<!-- Modal -->
<bootstrap:modal name="edit-model" modalTitle="請輸入資料" >
</bootstrap:modal>
<script type="text/javascript">
    tab2SearchData();

    /**
     * action: 查詢
     */
    function tab2SearchData() {
        jQuery('#tab2-search-result').bootstrapTable('refresh', {
            url: '${createLink(controller: 'ex200' ,action: 'filterEx110')}/?' + jQuery('#tab2-search').serialize()
        });
    }

</script>