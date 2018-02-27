<%--
  Created by IntelliJ IDEA.
  User: HQIZCC
  Date: 2017/10/19
  Time: 16:10
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
    <title>电影新增</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="${ctx}/staticfile/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="${ctx}/staticfile/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="${ctx}/staticfile/assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="${ctx}/staticfile/assets/css/admin.css">
    <script src="${ctx}/staticfile/assets/js/jquery.min.js"></script>
    <script src="${ctx}/staticfile/assets/js/app.js"></script>
    <script type="text/javascript" src="${ctx}/staticfile/assets/datepicker/WdatePicker.js"></script>
</head>


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
                <ul class="am-icon-flag on"> 电影</ul>

                <dl class="am-icon-home" style="float: right;"> 当前位置： 首页 > <a href="#">电影添加</a></dl>



            </div>
            <div class="fbneirong">
                <form class="am-form" action="${ctx}/backend/toMovieList"  method="post" enctype="multipart/form-data">
                    <input name="poster" hidden="hidden" value="">
                    <div class="am-form-group am-cf">
                        <div class="zuo">电影名称：</div>
                        <div class="you">
                            <input type="text" name="movieName" class="am-input-sm" id="doc-ipt-email-1" placeholder="请输入名称">
                        </div>
                    </div>
                    <div class="am-form-group am-cf">
                        <div class="zuo">上映时间：</div>
                        <div class="you">
                            <input type="text" name="showTime" class="am-form-field am-input-sm am-input-zm  am-icon-calendar" placeholder="上映日期" data-am-datepicker="{theme: 'success',}" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="am-form-group am-cf">
                        <div class="zuo">电影描述：</div>
                        <div class="you">
                            <textarea class="" name="description" rows="2" id="doc-ta-1"></textarea>
                        </div>
                    </div>
                    <div class="am-form-group am-cf">
                        <div class="zuo">电影导演：</div>
                        <div class="you">
                            <input type="text" name="director" class="am-input-sm" id="doc-ipt-email-1" placeholder="请输入导演名称">
                        </div>
                    </div>
                    <div class="am-form-group am-cf">
                        <div class="zuo">电影演员：</div>
                        <div class="you">
                            <input type="text" name="actor" class="am-input-sm" id="doc-ipt-email-1" placeholder="请输入演员">
                        </div>
                    </div>
                    <div class="am-form-group am-cf">
                        <div class="zuo">电影海报：</div>
                        <div class="you"><input type="file" id="doc-ipt-file-1" name="file">
                            <p class="am-form-help">请选择要上传的文件...</p></div>
                    </div>
                    <div class="am-form-group am-cf">
                        <div class="zuo">详情页1：</div>
                        <div class="you"><input type="file" id="doc-ipt-file-1" name="file">
                            <p class="am-form-help">请选择要上传的文件...</p></div>
                    </div>
                    <div class="am-form-group am-cf">
                        <div class="zuo">详情页2：</div>
                        <div class="you"><input type="file" id="doc-ipt-file-1" name="file">
                            <p class="am-form-help">请选择要上传的文件...</p></div>
                    </div>
                    <div class="am-form-group am-cf">
                        <div class="zuo">电影时长：</div>
                        <div class="you">
                            <input type="text" name="playtime" class="am-input-sm" id="doc-ipt-email-1" placeholder="请输入电影放映总时长">
                        </div>
                    </div>
                    <div class="am-form-group am-cf">
                        <div class="zuo">电影来源地：</div>
                        <div class="you" style="height: 45px;">
                            <input type="text" name="country" id="doc-ipt-file-1" placeholder="请输入上映国家"></input>
                        </div>
                    </div>
                    <div class="am-form-group am-cf">
                        <div class="zuo">电影类型：</div>
                        <div class="you" style="height: 45px;">
                            <c:forEach var="type" items="${typeList}">
                                <input type="checkbox" name="typeId" value="${type.typeId}">${type.typeName}</input>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="am-form-group am-cf">
                        <div class="you" style="margin-left: 11%;">
                            <button type="submit" class="am-btn am-btn-success am-radius">发布并关闭窗口</button>&nbsp;  &raquo; &nbsp; <button type="submit" class="am-btn am-btn-secondary am-radius">发布并继续发布</button>
                        </div>
                    </div>
                </form>
            </div>


            <jsp:include page="backfoot.jsp"/>




        </div>

    </div>




</div>

</body>
</html>
