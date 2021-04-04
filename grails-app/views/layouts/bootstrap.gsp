<%--
  Created by IntelliJ IDEA.
  User: JamesChang
  Date: 2020/7/26
  Time: 下午 03:54
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <!doctype html>
    <html lang="en" class="no-js">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <title>
            <g:layoutTitle default="Grails"/>
        </title>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>
        <asset:stylesheet src="application.css"/>

        <g:layoutHead/>
    </head>
</head>

<body>
    <nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow" role="navigation">
        <span class="navbar-brand col-sm-3 col-md-4 col-lg-3 col-xl-3 mr-0">
            <asset:image class="" src="grails.svg" alt="Logo"/>
            <span class=""> <g:message code="page.index.ststem.title" /></span>
        </span>
        <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
        <ul class="navbar-nav px-3">
            <sec:ifLoggedIn>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                        <sec:loggedInUserInfo field='fullname'/>
                    </a>
                    <div class="dropdown-menu navbar-dark">
                        <g:form controller="logout">
                            <g:submitButton class="dropdown-item navbar-dark color-light" name="Submit" value="Logout" style="color:gray" />
                        </g:form>
                    </div>
                </li>
            </sec:ifLoggedIn>
        </ul>
    </nav>
    <div class="">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
            <div class="sidebar-sticky">
                <div class="accordion" id="accordionExample">
                    <ul class='nav flex-column'>
                        <li class='nav-item'>
                            <a class='nav-link' href='#' onclick="changeIframeMain('','selecter-first')">
                                <icon:svg iconType="dashboard" message="${message(code: 'default.dashboard.lable')}" />
                            </a>
                        </li>
                    </ul>
                    <g:render template="/public/navList" />
                </div>
            </div>
        </nav>

        <main id="tabs-parent" role="main" class="col-md-10 ml-sm-auto col-lg-10 px-4">
            <g:layoutBody/>
        </main>
    </div>

    <asset:javascript src="application.js"/>
</body>
</html>