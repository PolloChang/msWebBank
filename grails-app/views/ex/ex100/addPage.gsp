<%--
  新增資料頁面
  Created by IntelliJ IDEA.
  User: JamesChang
  Date: 2021/4/4
  Time: 下午 11:13
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="iframePage"/>
</head>
<body>
    <div>
        <icon:svg iconType="modeEdit" message="${message(code: "ex100.label")}"/>
    </div>
    <div id="message">
    </div>
    <form id="ex100-form">
        <g:render template="/ex/ex100/form" />
    </form>
    <div>
        <div class="btn-group" role="group">
            <bootstrap:button name="save" showText="儲存" onclick="saveData('ex100-form');"/>
        </div>
    </div>
    <script type="text/javascript">
        function saveData(formId) {
            jQuery.ajax({
                url:"${createLink(controller: "ex100" ,action: "ex100Insert")}",
                data: $('#'+formId).serialize(),
                type: "POST",
                ataType: "JSON",
                success: function (json) {
                    if(json.acrtionIsSuccess){

                    }
                    else{
                        Swal.fire('失敗','儲存失敗','error')
                            .then((result) => {
                                var alertDiv = jQuery(document.createElement("div"));
                                alertDiv.attr("class","alert alert-danger message");
                                alertDiv.attr("role","alert");
                                alertDiv.append(json.acrtionMessage);
                                jQuery('#message').append(alertDiv);
                            });
                    }
                    console.log(json);
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
    </script>
</body>
</html>