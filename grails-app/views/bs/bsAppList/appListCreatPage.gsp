<jc:modalContent id="${modalId}" static="true" ariaLabelledby="exampleModalLabel"
                 modalDialogClass="modal-dialog-scrollable modal-lg"
>
    <jc:moalHeader title="新增資料" ariaLabelledby="exampleModalLabel">
    </jc:moalHeader>
    <jc:moalBody>
        <span id="activeMessage" />
        <form id="form">
            <g:hiddenField name="bsAppList.id" value="${bsAppListI.id}" />
            <g:hiddenField name="bsAppList.version" value="${bsAppListI.version}" />
            <g:render template="bsAppList/form" model="[bsAppListI:bsAppListI,readonly:readonly]"/>
        </form>
    </jc:moalBody>
    <jc:moalFooter>
        <jc:bottom type="button" class="btn btn-primary" onclick="doInsert()">${g.message(code: 'default.button.save.label')}</jc:bottom>
    </jc:moalFooter>
</jc:modalContent>
<script type="text/javascript">


    /**
     * 儲存
     */
    function doInsert() {
        var nextPageUrl =  "${createLink(controller:'bs',action: "appListEdit")}/";
        jQuery.ajax({
            url:"${createLink(controller: "bs" ,action: "appListDoUpdate")}",
            data: $('#form').serialize(),
            type: "POST",
            ataType: "JSON",
            success: function (json) {
                if(json.acrtionIsSuccess){
                    forwardEditModeAfterDoSave('${modalId}','modalSpan',nextPageUrl+json.forWardId);
                }
                else{
                    doSaveFaild('activeMessage',json.acrtionMessage);
                }
            },
            beforeSend:function(){
                doSaveBeforSend('activeMessage');
            }
        });
    }
</script>
