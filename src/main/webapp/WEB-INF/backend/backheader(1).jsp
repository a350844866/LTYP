<%--
  Created by IntelliJ IDEA.
  User: 胡佳豪
  Date: 2017/10/20
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../base.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>管理界面头部</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="${ctx}/staticfile/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="${ctx}/staticfile/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="stylesheet" href="${ctx}/staticfile/assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="${ctx}/staticfile/assets/css/admin.css">
    <script src="${ctx}/staticfile/assets/js/jquery.min.js"></script>
    <script src="${ctx}/staticfile/js/jquery.min.js"></script>
    <script src="${ctx}/staticfile/assets/js/app.js"></script>
</head>
<body>
<header class="am-topbar admin-header">
    <div class="am-topbar-brand"><img src="${ctx}/staticfile/assets/i/logo.png"></div>

    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">
        <ul class="am-nav am-nav-pills am-topbar-nav admin-header-list">


            <li class="soso">
                <form class="am-form" name="search">
                    <p>
                        <select id="searchType" data-am-selected="{btnWidth: 70, btnSize: 'sm', btnStyle: 'default'}"
                                name="search">
                            <option value="movie">电影</option>
                            <option value="user">用户</option>
                        </select>
                    </p>

                    <p class="ycfg"><input type="text" class="am-form-field am-input-sm" placeholder="搜索全站" name="key"/>
                    </p>
                    <p>
                        <a href="#" class="am-btn am-btn-default"
                           onclick="getSearchTypeAndSubmit()"><i
                                class="am-icon-search"></i></a>
                    </p>
                </form>
            </li>


            <li class="am-hide-sm-only" style="float: right;"><a href="javascript:;" id="admin-fullscreen"><span
                    class="am-icon-arrows-alt"></span> <span class="admin-fullText">欢迎你</span></a></li>
        </ul>
    </div>
</header>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="${ctx}/staticfile/assets/js/polyfill/rem.min.js"></script>
<script src="${ctx}/staticfile/assets/js/polyfill/respond.min.js"></script>
<script src="${ctx}/staticfile/assets/js/amazeui.legacy.js"></script>
<script src="${ctx}/staticfile/assets/js/amazeui.min.js"></script>
<script type="text/javascript">
    function getSearchTypeAndSubmit() {
        var selectedVal = $("#searchType").val();
        formSubmit('${ctx}/backend/search/' + selectedVal, '_self')
    }
</script>
</body>
</html>
