<%--
  Created by JamesChang
  Date/檔案建立日期: 2020/4/5
  Time/檔案建立時間: 上午 09:10
  File Description/檔案描述: 系統登入頁面
--%>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Register</title>
</head>

<body>
<div class="row">
    <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
            <div class="card-body">
                <h5 class="card-title text-center">${message(code: "springSecurity.register.title.label")}</h5>
                <g:if test='${flash.message}'>
                    <div class="alert alert-danger" role="alert">${flash.message}</div>
                </g:if>
                <form class="form-signin" action="register" method="POST" id="loginForm" autocomplete="off">
                    <div class="form-group">
                        <label for="role">${message(code: "role.authority.label")}</label>
                        <g:select
                            name="role.id" id="role" class="form-control"
                            from="${security.Role.list()}" noSelection="['':'請選擇']"
                            optionKey="id" optionValue="authorityName"
                        />
                    </div>

                    <div class="form-group">
                        <label for="username">${message(code: "role.firstName.label")}</label>
                        <input type="text" placeholder="Your firstName" class="form-control" name="firstName" id="firstName" autocapitalize="none"/>
                    </div>

                    <div class="form-group">
                        <label for="username">${message(code: "role.lastName.label")}</label>
                        <input type="text" placeholder="Your lastName" class="form-control" name="lastName" id="lastName" autocapitalize="none"/>
                    </div>

                    <div class="form-group">
                        <label for="username">${message(code: "role.email.label")}</label>
                        <input type="text" placeholder="Your eMail" class="form-control" name="email" id="email" autocapitalize="none"/>
                    </div>

                    <div class="form-group">
                        <label for="username">${message(code: "role.username.label")}</label>
                        <input type="text" placeholder="Your username" class="form-control" name="username" id="username" autocapitalize="none"/>
                    </div>

                    <div class="form-group">
                        <label for="password">${message(code: "role.password.label")}</label>
                        <input type="password" placeholder="Your password" class="form-control" name="password" id="password"/>
                    </div>

                    <div class="form-group">
                        <label for="password">${message(code: "role.repassword.label")}</label>
                        <input type="password" placeholder="Re-enter password" class="form-control" name="repassword" id="repassword"/>
                    </div>

                    <button id="submit" class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">${message(code: "springSecurity.button.register.label")}</button>
                    <hr class="my-4">
                    <p>${message(code: "springSecurity.AlreadyHaveAnAccount.label")} <g:link controller="login" action="auth">${message(code: "springSecurity.button.login.label")}</g:link></p>
                </form>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    document.addEventListener("DOMContentLoaded", function(event) {
        document.forms['loginForm'].elements['username'].focus();
    });
</script>
</body>
</html>