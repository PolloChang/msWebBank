<%--
  Created by JamesChang
  Date/檔案建立日期: 2020/2/7
  Time/檔案建立時間: 上午 10:27
  File Description/檔案描述:第二階選單畫面
--%>
<!doctype html>
<html>
<head>
    <meta name="layout" content="iframePageContent"/>
</head>
<body>
<div class="row">
    <div class="col-11">
        <icon:svg iconType="cube" message="${message(code: 'system.editPage.header.title.label')}"/>
    </div>
</div>
<div class="row">
    <div class="col-12 border-bottom">
        <span id="activeMessage" />
    </div>
    <div class="col-12 mt-2">
        <g:render template="/bs/bs100List/bs100Form" model="[bs100I:bs100I]" />
    </div>
</div>

<div class="row border-top mt-2">
    <div class="col-12 mt-2">
        <icon:svg iconType="cube" message="子選單"/>
    </div>
    <div class="col-12 mt-2">
        <g:render template="/bs/bs100List/bs101List" model="[bs100I:bs100I]" />
    </div>
</div>
<script type="text/javascript">

    /**
     * 更新
     */
    function doUpdate() {
        var nextPageUrl =  "${createLink(controller:'bs100',action: "editPage")}/";
        jQuery.ajax({
            url:"${createLink(controller: "bs100" ,action: "doUpdate")}",
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

    /**
     * 刪除
     */
    function doDelete() {
        Swal.fire({
            title: '${message(code: 'system.check.delete.title.label')}',
            text: "${message(code: 'system.check.delete.text.label')}",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
        }).then((result) => {
            if (result.value) {
                jQuery.ajax({
                    url:"${createLink(controller: "bs100" ,action: "doDelete")}",
                    data: $('#form').serialize(),
                    type: "POST",
                    ataType: "JSON",
                    success: function (json) {
                        forwardEditPageAfterDoDelete('${pageId}');
                    }
                });
            }
        });
    }
</script>
</body>
</html>