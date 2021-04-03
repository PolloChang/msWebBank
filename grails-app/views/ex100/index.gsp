<%--
  Created by IntelliJ IDEA.
  User: JamesChang
  Date: 2020/8/1
  Time: 上午 06:35
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="iframePage"/>
</head>
<body>
    <form id="search">
        <div class="">
            <icon:svg iconType="search" message="查詢條件"/>
        </div>
        <div class="searchForm">
            <div class="form-group row">
                <bootstrap:formItem labelTitle="文字" name="staticText" />
                <bootstrap:formItem labelTitle="數字" name="staticNuber" inputType="number" />
            </div>
            <div class="form-group row">
                <bootstrap:formItem labelTitle="選項" name="staticSelect" inputType="contents" >
                    <g:select name="staticSelect" id="staticSelect"
                              from="[[key:1,value:'1'],[key:2,value:'2']]" noSelection="['':'---']"
                              optionKey="key" optionValue="value"
                              class="form-control"
                    />
                </bootstrap:formItem>
                <bootstrap:formItem labelTitle="複選" name="staticText" inputType="contents" >
                    <bootstrap:checkBox name="defaultCheck1" value="1" labelTitle="Default checkbox1"/>
                    <bootstrap:checkBox name="defaultCheck2" value="2" labelTitle="Default checkbox2"/>
                </bootstrap:formItem>
            </div>
            <div class="form-group row">
                <bootstrap:formItem labelTitle="地址" name="staticText" inputType="contents" titleVsContent="[2,10]" >
                    <bootstrap:addressSelect
                            nameZip="ex100.zip" valueZip=""
                            nameCitycode="ex100.citycode" valueCitycode=""
                            nameTwnspcode="ex100.twnspcode" valueTwnspcode=""
                            nameVilgcode="ex100.vilgcode" valueVilgcode=""
                            nameAddr="ex100.addr" valueAddr=""
                    />
                </bootstrap:formItem>
            </div>
        </div>
    </form>
</body>
</html>