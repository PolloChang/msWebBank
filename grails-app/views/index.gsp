<%--
  Created by IntelliJ IDEA.
  User: JamesChang
  Date: 2020/7/26
  Time: 下午 03:53
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="bootstrap"/>
    <style>
        .contentScreen{
            width:100%;
            height: 1080px;
        }
    </style>
    <script type="text/javascript">
        function forwardApp(closeAppId,changId,appName,forwardURL) {

            closeApp(closeAppId);
            setTimeout(function(){
                changeIframeMain(forwardURL,changId,appName);
            }, 20);
        }
    </script>
</head>

<body>
    <nav id="screen-tabs">
        <div class="nav nav-tabs" id="screen-tab" role="tablist">
            <a class="nav-item nav-link active" id="screen-home-tab" data-toggle="tab" href="#screen-home" role="tab" aria-controls="screen-home" aria-selected="true">Home</a>
        </div>
    </nav>
    <div class="tab-content" id="screen-tabContent">
        <div class="tab-pane fade show active" id="screen-home" role="tabpanel" aria-labelledby="screen-home-tab">
            <iframe title='' id='screen-home-content' class='contentScreen'  frameborder='0' src='${createLink(controller: 'information',action: 'index')}' ></iframe>
        </div>
    </div>
</body>
</html>