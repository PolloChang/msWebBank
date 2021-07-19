<div class="modal-body">
    <form id="requestMap-form">
        <g:hiddenField name="requestMap.id" value="${requestMapI?.id}"/>
        <g:hiddenField name="requestMap.version" value="${requestMapI?.version}"/>
        <g:render template="/domainFroms/security/requestMap" model="[requestMapI:requestMapI]"/>
        <g:render template='/public/updateMessage' model='[instance: requestMapI]'/>
    </form>
</div>
<div class="modal-footer">
    <bootstrap:button name="close" class="btn btn-secondary" data-dismiss="modal" showText="${message(code:"default.button.close.label")}"/>
    <bootstrap:button
            name="save" class="btn btn-primary"
            data-active="buttonActive"
            data-action="modelsave"
            data-url="${createLink(controller: "requestmap",action: "save",params: [id:requestMapI?.id,modelId:"edit-model"])}"
            data-formid="requestMap-form"
            data-filterfun="tab2SearchData()"
            showText="${message(code:"default.button.save.label")}"
    />
    <bootstrap:button
            name="delete" class="btn-danger"
            data-active="buttonActive"
            data-action="modelDelete"
            data-formid="ex110-form"
            data-filterfun="tab2SearchData()"
            data-url="${createLink(controller: "bs",action: "deleteRequestMapModel",params: [id:requestMapI?.id,modelId:"edit-model"])}"
            showText="${message(code: "default.button.delete.label")}"
    />
</div>