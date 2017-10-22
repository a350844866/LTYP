<%--
  Created by IntelliJ IDEA.
  User: 胡佳豪
  Date: 2017/10/20
  Time: 10:06
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
    <title>用户列表</title>
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
<jsp:include page="backheader.jsp"/>


<div class="am-cf admin-main">

    <jsp:include page="backleft.jsp"/>

    <div class=" admin-content">

        <div class="daohang">
        </div>

        <div class="admin-biaogelist">

            <div class="listbiaoti am-cf">
                <ul class="am-icon-users"> 用户管理</ul>

                <dl class="am-icon-home" style="float: right;">当前位置： 首页 > <a href="#">用户列表</a></dl>

            </div>
            <form class="am-form am-g">
                <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped"
                       style="text-align: center">
                    <thead>
                    <tr class="am-success">
                        <th class="table-check"><input type="checkbox"/></th>

                        <th class="table-username" style="text-align: center">用户名</th>
                        <th class="table-nickname" style="text-align: center">昵称</th>
                        <th class="table-type" style="text-align: center">邮箱</th>
                        <th class="table-author am-hide-sm-only" style="text-align: center">手机号</th>
                        <th width="130px" class="table-set" style="text-align: center">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${userList}" var="u" varStatus="status">
                        <tr>
                            <td><input type="checkbox" value="${u.userId}"/></td>

                            <td>${u.username}</td>
                            <td>${u.userInfo.nickname}</td>
                            <td>${u.userInfo.email}</td>
                            <td>${u.userInfo.phone}</td>
                            <td>
                                <c:if test="${u.ban==0}"><a href="${ctx}/backend/updateBan?userId=${u.userId}&ban=1"
                                                            class="am-btn am-btn-default"><span
                                        class="am-icon-lock"></span> 封号</a></c:if>
                                <c:if test="${u.ban==1}"><a href="${ctx}/backend/updateBan?userId=${u.userId}&ban=0"
                                                            class="am-btn am-btn-default"><span
                                        class="am-icon-unlock"></span> 解封</a></c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <ul class="am-pagination am-fr">
                    <li class="am-disabled"><a href="#">«</a></li>
                    <li class="am-active"><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">»</a></li>
                </ul>

                <hr/>
                <p style="color:red;">注：各大站内管理员删除数据时请谨慎操作</p>
            </form>
            <jsp:include page="backfoot.jsp"/>
        </div>

    </div>


</div>

<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/polyfill/rem.min.js"></script>
<script src="assets/js/polyfill/respond.min.js"></script>
<script src="assets/js/amazeui.legacy.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="assets/js/amazeui.min.js"></script>
<!--<![endif]-->


</body>
</html>