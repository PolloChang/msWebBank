<form id="bs000-form">
    <g:hiddenField name="bs000.id" value="${bs000I?.id}"/>
    <g:hiddenField name="bs000.version" value="${bs000I?.version}"/>
    <g:render template="/domainFroms/bs/bs000" model="[bs000I:bs000I]" />
    <g:render template='/public/updateMessage' model='[instance: bs000I]'/>
</form>
<div>
    <div class="btn-group" role="group">
        <bootstrap:button name="save" showText="${message(code: "default.button.save.label")}"
                          onclick="saveData('bs000-form','${createLink(controller: "bs" ,action: "bs000Update")}');"
        />
        <bootstrap:button name="delete" showText="${message(code: "default.button.delete.label")}" class="btn-danger"
                          onclick="deleteData('bs000-form','${createLink(controller: "bs" ,action: "bs000Delete")}','${message(code: "default.button.delete.confirm.message")}');"
        />
    </div>
</div>