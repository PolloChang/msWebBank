<div class="modal-body">
    <form id="ex110-form">
    <g:render template="/domainFroms/ex/ex110" model="[ex110I:ex110I]"/>
    </form>
</div>
<div class="modal-footer">
    <bootstrap:button name="close" class="btn btn-secondary" data-dismiss="modal" showText="${message(code:"default.button.close.label")}"/>
    <bootstrap:button
            name="print" class="btn"
            data-active="buttonActive"
            data-action="modelsave"
            data-url="${createLink(controller: "ex200",action: "insertEx110Model",params: [id:ex110I?.id,modelId:"edit-model"])}"
            data-formid="ex110-form"
            data-filterfun="tab2SearchData()"
            showText="${message(code:"default.button.create.label")}"
    />
</div>