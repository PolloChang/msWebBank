
%{--iframe專有--}%
<!doctype html>
<html lang="zh-TW" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>
    <asset:stylesheet src="iframe.css"/>
    <g:layoutHead/>
    <asset:javascript src="application.js"/>
</head>
<g:set var="appItem" value="${bs.Bs000.findByControllerAndAction(controllerName,actionName)}" />
<body>
<a id="AU" name="U" accesskey="U" href="#U" title="${message(code: 'system.free.up.label')}">:::</a>
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item active" aria-current="page">
            ${g.message(code: "page.${controllerName}.${actionName}.label")}[${controllerName}/${actionName}]
        </li>
    </ol>
</nav>

<div id="content-parent">
    <div id="content-main">
        <g:layoutBody/>
    </div>
</div>
<script type="text/javascript">
    /**
     * 一進入頁面執行
     */
    $(function() {
        $(".searchForm .form-group").addClass("border");
    });

    /**
     * 儲存資料
     * */
    function saveData(formId,actionUrl,comfiremMessage) {
        if(comfiremMessage){
            Swal.fire({
                title: comfiremMessage,
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: '${message(code: 'default.button.confirm.yes.label')}',
                cancelButtonText: '${message(code: 'default.button.confirm.no.label')}',
            }).then((result) => {
                if (result.value) {
                    saveDataAction(formId,actionUrl);
                }
            })
        } else{
            saveDataAction(formId,actionUrl);
        }
    }

    function saveDataAction(formId,actionUrl) {
        jQuery.ajax({
            url:actionUrl,
            data: $('#'+formId).serialize(),
            type: "POST",
            ataType: "JSON",
            success: function (json) {
                if(json.acrtionIsSuccess){
                    Swal.fire({
                        title:'儲存成功',
                        text:'系統將重新整理資料',
                        icon:'success',
                        timer: 2000
                    }).then((result) => {
                            parent.forwardApp('${params?.changId}',json.tabId,json.tabName,json.forWardUrl);
                        });
                }else if(json.dataVersionDifferent){
                    Swal.fire('資料已異動','資料有被其他人異動過，請重新查詢後再繼續動作','warning')
                        .then((result) => {
                            var alertDiv = jQuery(document.createElement("div"));
                            alertDiv.attr("class","alert alert-danger message");
                            alertDiv.attr("role","alert");
                            alertDiv.append(json.acrtionMessage);
                            jQuery('#message').append(alertDiv);
                        });
                }else{
                    Swal.fire('失敗','儲存失敗','error')
                        .then((result) => {
                            var alertDiv = jQuery(document.createElement("div"));
                            alertDiv.attr("class","alert alert-danger message");
                            alertDiv.attr("role","alert");
                            alertDiv.append(json.acrtionMessage);
                            jQuery('#message').append(alertDiv);
                        });
                }
            },
            beforeSend:function(){
                $(".message ").alert('close');
            },
            statusCode: {
                404: function() {
                    Swal.fire('400','找不到頁面','warning');
                },
                500:function() {
                    Swal.fire('500','系統發生錯誤','warning');
                }
            }
        });
    }

    /**
     * 刪除資料
     * @param formId
     * @param actionUrl
     * @param comfiremMessage
     */
    function deleteData(formId,actionUrl,comfiremMessage) {
        if(comfiremMessage){
            Swal.fire({
                title: comfiremMessage,
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: '${message(code: 'default.button.confirm.yes.label')}',
                cancelButtonText: '${message(code: 'default.button.confirm.no.label')}',
            }).then((result) => {
                if (result.value) {
                    jQuery.ajax({
                        url:actionUrl,
                        data: $('#'+formId).serialize(),
                        type: "POST",
                        ataType: "JSON",
                        success: function (json) {
                            if(json.acrtionIsSuccess){
                                Swal.fire({
                                    title:'刪除成功',
                                    text:'系統將關閉此分頁',
                                    icon:'success',
                                    timer: 2000
                                }).then((result) => {
                                    parent.closeApp('${params?.changId}');
                                });

                            }else if(json.dataVersionDifferent){
                                Swal.fire('資料已異動','資料有被其他人異動過，請重新查詢後再繼續動作','warning')
                                    .then((result) => {
                                        var alertDiv = jQuery(document.createElement("div"));
                                        alertDiv.attr("class","alert alert-danger message");
                                        alertDiv.attr("role","alert");
                                        alertDiv.append(json.acrtionMessage);
                                        jQuery('#message').append(alertDiv);
                                    });
                            }else{
                                Swal.fire('失敗','刪除失敗','error')
                                    .then((result) => {
                                        var alertDiv = jQuery(document.createElement("div"));
                                        alertDiv.attr("class","alert alert-danger message");
                                        alertDiv.attr("role","alert");
                                        alertDiv.append(json.acrtionMessage);
                                        jQuery('#message').append(alertDiv);
                                    });
                            }
                        },
                        beforeSend:function(){
                            $(".message ").alert('close');
                        },
                        statusCode: {
                            404: function() {
                                Swal.fire('400','找不到頁面','warning');
                            },
                            500:function() {
                                Swal.fire('500','系統發生錯誤','warning');
                            }
                        }
                    });
                }
            })
        }
    }
</script>
</body>
</html>
