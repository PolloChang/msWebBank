<bootstrap:systemInfo>
    <p class="text-danger">
        如果CONTROLLER沒有值，則無法查詢出來
    </p>
</bootstrap:systemInfo>
<form id="tab2-search">
    <div>
        <icon:svg iconType="search" message="${message(code: "default.icon.search.label")}"/>
    </div>
    <div class="searchForm">
        <g:hiddenField name="url" value="${bs000I?.controller}"/>
        <bootstrap:fromTable>
            <tbody>
            <tr>
                <td colspan="4">
                    <div class="btn-group" role="group">

                        <bootstrap:button
                                name="search"
                                data-type="actionButton"
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
                                data-url="${createLink(controller: "bs",action: "addRequestMapModel",params: [url:bs000I?.controller])}"
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
        <g:render template="/bs/bs000/editTabs/tab2ResultData" />
    </div>
</form>
<bootstrap:modal name="edit-model" modalTitle="請輸入資料" ></bootstrap:modal>
<script type="text/javascript">
    tab2SearchData();

    /**
     * action: 查詢
     */
    function tab2SearchData() {
        jQuery('#tab2-search-result').bootstrapTable('refresh', {
            url: '${createLink(controller: 'bs' ,action: 'filterRequestMap')}/?' + jQuery('#tab2-search').serialize()
        });
    }

</script>