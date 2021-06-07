<%--
  Created by JamesChang
  Date/檔案建立日期: 2020/2/8
  Time/檔案建立時間: 下午 11:02
  File Description/檔案描述:
--%>
<jc:modalContent id="${modalId}" static="true" ariaLabelledby="bs101ModalLabel"
                 modalDialogClass="modal-dialog-scrollable modal-lg"
>
    <jc:moalHeader title="${g.message(code: 'page.default.creat.label')}" ariaLabelledby="bs101ModalLabel">
    </jc:moalHeader>
    <jc:moalBody>
        <span id="bs101-active-message" />
        <form id="bs101-form">
            <g:hiddenField name="bs101.id" value="${bs101I.id}" />
            <g:hiddenField name="bs101.version" value="${bs101I.version}" />
            <table class="table table-bordered">
                <colgroup>
                    <col width="20%">
                    <col width="30%">
                    <col width="20%">
                    <col width="30%">
                </colgroup>
                <tbody>
                <tr>
                    <th class="table-info text-right" scope="row">${g.message(code: 'bs101.ptype.label')}</th>
                    <td>
                        <jc:textField name="bs101.ptype" value="${bs101I?.ptype}" readonly="true" />
                    </td>
                    <th class="table-info text-right" scope="row">${g.message(code: 'bs101.pcode.label')}</th>
                    <td>
                        <jc:numberField name="bs101.pcode" value="${bs101I?.pcode}" readonly="${readonly}" />
                    </td>
                </tr>
                </tbody>
            </table>
            <g:render template="/bs/bs100List/formBs101" model="[bs101I:bs101I,readonly:readonly]"/>
        </form>
    </jc:moalBody>
    <jc:moalFooter>
        <jc:bottom type="button" class="btn btn-primary" onclick="doInsertBs101()">${g.message(code: 'default.button.save.label')}</jc:bottom>
        <jc:bottom type="button" class="btn btn-primary" onclick="doInsertAfterSaveBs101()">${g.message(code: 'default.button.doInsertAfterSave.label')}</jc:bottom>
    </jc:moalFooter>
</jc:modalContent>
<script type="text/javascript">

    /**
     * 儲存
     */
    function doInsertBs101() {
        var nextPageUrl =  "${createLink(controller:'bs100',action: "editPageBs101")}/";
        jQuery.ajax({
            url:"${createLink(controller: "bs100" ,action: "doInsertBs101")}",
            data: $('#bs101-form').serialize(),
            type: "POST",
            ataType: "JSON",
            success: function (json) {
                if(json.acrtionIsSuccess){
                    forwardEditModeAfterDoSave('${modalId}','bs101ModalSpan',nextPageUrl+json.forWardId);
                }
                else{
                    doSaveFaild('bs101-active-message',json.acrtionMessage);
                }
            },
            beforeSend:function(){
                doSaveBeforSend('bs101-active-message');
            }
        });
    }

    /**
     *  儲存後新增下一筆
     */
    function doInsertAfterSaveBs101() {
        var nextPageUrl =  "${createLink(controller:'bs100',action: "creatPageBs101")}?ptype=${bs101I?.ptype}";
        jQuery.ajax({
            url:"${createLink(controller: "bs100" ,action: "doInsertBs101")}",
            data: $('#bs101-form').serialize(),
            type: "POST",
            ataType: "JSON",
            success: function (json) {
                if(json.acrtionIsSuccess){
                    forwardEditModeAfterDoSave('${modalId}','bs101ModalSpan',nextPageUrl);
                }
                else{
                    doSaveFaild('bs101-active-message',json.acrtionMessage);
                }
            },
            beforeSend:function(){
                doSaveBeforSend('bs101-active-message');
            }
        });
    }
</script>