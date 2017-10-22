<%--
  Created by IntelliJ IDEA.
  User: 胡佳豪
  Date: 2017/10/20
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../base.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>电影列表页面</title>
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
    <script src="${ctx}/staticfile/assets/js/app.js"></script>
</head>
<body>
<div class="nav-navicon admin-main admin-sidebar">


    <div class="sideMenu am-icon-dashboard" style="color:#aeb2b7; margin: 10px 0 0 0;"> 欢迎系统管理员：清风抚雪</div>
    <div class="sideMenu">
        <h3 class="am-icon-home"><em></em> <a href="#">乐途后台首页</a></h3>
        <ul>
            <li><a href="${ctx}/backend/index">首页</a></li>
        </ul>
        <h3 class="am-icon-film"><em></em> <a href="#">电影集中营</a></h3>
        <ul>
            <li><a href="${ctx}/backend/movieList">电影列表</a></li>
            <li><a href="电影分类.html">电影分类</a></li>
        </ul>
        <h3 class="icon-facetime-video"><em></em> <a href="#"> 电影管理</a></h3>
        <ul>
            <li><a href="${ctx}/backend/addMovie">添加新电影</a></li>
        </ul>
        <h3 class="am-icon-users"><em></em><a href="#">用户管理</a></h3>
        <ul>
            <li><a href="${ctx}/backend/userList">用户列表</a></li>
            <li><a href="${ctx}/backend/adminList">管理员列表</a></li>
        </ul>
    </div>
    <!-- sideMenu End -->

    <script type="text/javascript">
        jQuery(".sideMenu").slide({
            titCell: "h3", //鼠标触发对象
            targetCell: "ul", //与titCell一一对应，第n个titCell控制第n个targetCell的显示隐藏
            effect: "slideDown", //targetCell下拉效果
            delayTime: 300, //效果时间
            triggerTime: 150, //鼠标延迟触发时间（默认150）
            defaultPlay: true,//默认是否执行效果（默认true）
            returnDefault: true //鼠标从.sideMen移走后返回默认状态（默认false）
        });
    </script>


</div>
</body>
</html>
