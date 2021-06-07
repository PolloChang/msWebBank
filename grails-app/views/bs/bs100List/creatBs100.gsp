<%--
  Created by JamesChang
  Date/檔案建立日期: 2020/2/7
  Time/檔案建立時間: 下午 07:28
  File Description/檔案描述:
--%>
<!doctype html>
<html>
<head>
    <meta name="layout" content="iframePageContent"/>
</head>
<body>
<div class="row">
    <div class="col-12">
        <icon:svg iconType="cube" message="${message(code: 'system.editPage.header.title.label')}"/>
    </div>
</div>
<div class="row">
    <div class="col-12 border-bottom">
        <span id="activeMessage" />
    </div>
    <div class="col-12 mt-2">
        <form id="form">
            <g:hiddenField name="bs100.id" value="${bs100I.id}" />
            <g:hiddenField name="bs100.version" value="${bs100I.version}" />
            <table class="table table-bordered">
                <colgroup>
                    <col width="20%">
                    <col width="30%">
                    <col width="20%">
                    <col width="30%">
                </colgroup>
                <tbody>
                <tr>
                    <th class="table-info text-right" scope="row">${g.message(code: 'bs100.systype.label')}</th>
                    <td>
                        <jc:textField name="bs100.systype" value="${bs100I.systype}"/>
                    </td>
                    <th class="table-info text-right" scope="row">${g.message(code: 'bs100.ptype.label')}</th>
                    <td>
                        <jc:textField name="bs100.ptype" value="${bs100I.ptype}"/>
                    </td>
                </tr>
                <tr>
                    <th class="table-info text-right" scope="row">${g.message(code: 'bs100.typedesc.label')}</th>
                    <td colspan="3">
                        <jc:textField name="bs100.typedesc" value="${bs100I.typedesc}"/>
                    </td>
                </tr>
                </tbody>
            </table>
            <div class="border-top">
                <jc:bottom type="button" class="btn btn-primary" onclick="doInsert()">${g.message(code: 'default.button.save.label')}</jc:bottom>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript">

    /**
     * 儲存
     */
    function doInsert() {
        var nextPageUrl =  "${createLink(controller:'bs100',action: "editPage")}/";
        jQuery.ajax({
            url:"${createLink(controller: "bs100" ,action: "doInsert")}",
            data: $('#form').serialize(),
            type: "POST",
            ataType: "JSON",
            success: function (json) {
                if(json.acrtionIsSuccess){
                    parent.forwardEditPageAfterDoSave('${pageId}',json.forWardId,nextPageUrl+json.forWardId);
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
</body>
</html>