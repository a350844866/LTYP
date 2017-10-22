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
                <ul class="am-icon-users"> 管理员新增</ul>

                <dl class="am-icon-home" style="float: right;">当前位置： 首页 > <a href="#">管理员新增</a></dl>

            </div>
            <form class="am-form am-g" action="${ctx}/backend/saveAdmin" method="post">
                <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped"
                       style="text-align: center">
                    <tr>
                        <td>用户名：</td>
                        <td>
                            <input name="username" type="text"/>
                        </td>
                    </tr>
                    <tr>
                        <td>密码：</td>
                        <td>
                            <input name="password" type="password"/>
                        </td>
                    </tr>
                    <tr>
                        <td>姓名：</td>
                        <td>
                            <input name="name" type="text"/>
                        </td>
                    </tr>
                    <tr>
                        <td>年龄：</td>
                        <td>
                            <input name="age" type="text"/>
                        </td>
                    </tr>
                    <tr>
                        <td>性别：</td>
                        <td>
                            <input name="gender" type="radio" value="男"/>男&nbsp;&nbsp;&nbsp;&nbsp;
                            <input name="gender" type="radio" value="女"/>女
                        </td>
                    </tr>
                    <tr>
                        <td>手机号：</td>
                        <td>
                            <input name="phone" type="text"/>
                        </td>
                    </tr>
                    <tr>
                        <td>职位：</td>
                        <td>
                            <select name="roleId">
                                <option value="">---请选择---</option>
                                <c:forEach items="${roleList}" var="r">
                                    <option value="${r.roleId}"
                                            <c:if test="${r.roleId<=2}">hidden="hidden"</c:if>>${r.roleName}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>邮箱号：</td>
                        <td>
                            <input name="email" type="text"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: center">
                            <input width="40px" height="20px" type="submit" value="提 交"/>&nbsp;&nbsp;&nbsp;&nbsp;
                            <input width="40px" height="20px" type="reset" value="重 置"/>
                        </td>
                    </tr>
                </table>

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