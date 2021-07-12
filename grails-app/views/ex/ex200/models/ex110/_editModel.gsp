<div class="modal-body">
    <form id="ex110-form">
        <g:render template="/domainFroms/ex/ex110" model="[ex110I:ex110I]"/>
        <g:render template='/public/updateMessage' model='[instance: ex110I]'/>
    </form>
</div>
<div class="modal-footer">
    <bootstrap:button name="close" class="btn btn-secondary" data-dismiss="modal" showText="${message(code:"default.button.close.label")}"/>
    <bootstrap:button
            name="save" class="btn btn-primary"
            data-active="buttonActive"
            data-action="modelsave"
            data-url="${createLink(controller: "ex200",action: "updateEx110Model",params: [id:ex110I?.id,modelId:"edit-model"])}"
            data-formid="ex110-form"
            data-filterfun="tab2SearchData()"
            showText="${message(code:"default.button.save.label")}"
    />
    <bootstrap:button
            name="delete" class="btn-danger"
            data-active="buttonActive"
            data-action="modelDelete"
            data-formid="ex110-form"
            data-filterfun="tab2SearchData()"
            data-url="${createLink(controller: "ex200",action: "deleteEx110Model",params: [id:ex110I?.id,modelId:"edit-model"])}"
            showText="${message(code: "default.button.delete.label")}"
    />
</div>