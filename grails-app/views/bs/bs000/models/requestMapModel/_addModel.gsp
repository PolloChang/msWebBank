<div class="modal-body">
    <form id="requestMap-form">
        <g:render template="/domainFroms/security/requestMap" model="[requestMapI:requestMapI]"/>
    </form>
</div>
<div class="modal-footer">
    <bootstrap:button name="close" class="btn btn-secondary" data-dismiss="modal" showText="${message(code:"default.button.close.label")}"/>
    <bootstrap:button
            name="print" class="btn"
            data-active="buttonActive"
            data-action="modelsave"
            data-url="${createLink(controller: "requestmap",action: "save",params: [id:requestMapI?.id,modelId:"edit-model"])}"
            data-formid="requestMap-form"
            data-filterfun="tab2SearchData()"
            showText="${message(code:"default.button.create.label")}YYY"
    />
%{--    data-url="${createLink(controller: "bs",action: "insertRequestMapModel",params: [id:requestMapI?.id,modelId:"edit-model"])}"--}%

</div>