<form id="ex200-form">
    <g:hiddenField name="ex100.id" value="${ex100I?.id}"/>
    <g:hiddenField name="ex100.version" value="${ex100I?.version}"/>
    <g:render template="/domainFroms/ex/ex100" model="[ex100I:ex100I]" />
    <g:render template='/public/updateMessage' model='[instance: ex100I]'/>
</form>
<div>
    <div class="btn-group" role="group">
        <bootstrap:button name="save" showText="${message(code: "default.button.save.label")}"
                          onclick="saveData('ex200-form','${createLink(controller: "ex200" ,action: "ex100Update")}');"
        />
        <bootstrap:button name="delete" showText="${message(code: "default.button.delete.label")}" class="btn-danger"
                          onclick="deleteData('ex200-form','${createLink(controller: "ex200" ,action: "ex100Delete")}','${message(code: "default.button.delete.confirm.message")}');"
        />
        <script type="text/javascript">

        </script>
    </div>
</div>