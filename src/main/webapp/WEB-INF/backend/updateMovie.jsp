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
    <title>更新电影详细信息</title>
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
    <script type="text/javascript" src="${ctx}/staticfile/assets/datepicker/WdatePicker.js"></script>
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

            <dl class="am-icon-home" style="float: right;"> 当前位置： 首页 > <a href="#">电影修改</a></dl>


        </div>
        <div class="fbneirong">
            <form class="am-form" action="${ctx}/backend/update" method="post" enctype="multipart/form-data">
                <input name="poster" hidden="hidden" value="">
                <input name="movieId" hidden="hidden" value="${movieId}">
                <div class="am-form-group am-cf">
                    <div class="zuo">电影名称：</div>
                    <div class="you">
                        <input type="text" name="movieName" class="am-input-sm" id="doc-ipt-email-1"
                               value="${movieInfo.movieName}"/>
                    </div>
                </div>
                <div class="am-form-group am-cf">
                    <div class="zuo">上映时间：</div>
                    <div class="you">
                        <input type="text" name="showTime"
                               class="am-form-field am-input-sm am-input-zm  am-icon-calendar"
                               data-am-datepicker="{theme: 'success',}" value="${movieInfo.showTime}">
                    </div>
                </div>
                <div class="am-form-group am-cf">
                    <div class="zuo">电影描述：</div>
                    <div class="you">
                        <textarea class="" name="description" rows="2" id="doc-ta-1">${movieInfo.description}</textarea>
                    </div>
                </div>
                <div class="am-form-group am-cf">
                    <div class="zuo">电影导演：</div>
                    <div class="you">
                        <input type="text" name="director" class="am-input-sm" id="doc-ipt-email-1"
                               value="${movieInfo.director}">
                    </div>
                </div>
                <div class="am-form-group am-cf">
                    <div class="zuo">电影演员：</div>
                    <div class="you">
                        <input type="text" name="actor" class="am-input-sm" id="doc-ipt-email-1"
                               value="${movieInfo.actor}">
                    </div>
                </div>
                <div class="am-form-group am-cf">
                    <div class="zuo">电影海报：</div>
                    <div class="you"><img id="doc-ipt-file-1" src="${ctx}/${movieInfo.poster}"
                                          style="width: 230px;height: 150px">
                        <input type="file" id="doc-ipt-file-1" name="file" value="${movieInfo.poster}">
                    </div>
                </div>
                <div class="am-form-group am-cf">
                    <div class="zuo">详情页1：</div>
                    <div class="you"><img id="doc-ipt-file-1" src="${ctx}/${movieImage0.imageUrl}"
                                          style="width: 230px;height: 150px">
                        <input type="file" id="doc-ipt-file-1" name="file" value="${movieImage0.imageUrl}">
                    </div>
                </div>
                <div class="am-form-group am-cf">
                    <div class="zuo">详情页2：</div>
                    <div class="you"><img id="doc-ipt-file-1" src="${ctx}/${movieImage1.imageUrl}"
                                          style="width: 230px;height: 150px">
                        <input type="file" id="doc-ipt-file-1" name="file" value="${movieImage1.imageUrl}">
                    </div>
                </div>
                <div class="am-form-group am-cf">
                    <div class="zuo">电影时长：</div>
                    <div class="you">
                        <input type="text" name="playtime" class="am-input-sm" id="doc-ipt-email-1"
                               value="${movieInfo.playtime}">
                    </div>
                </div>
                <div class="am-form-group am-cf">
                    <div class="zuo">电影来源地：</div>
                    <div class="you" style="height: 45px;">
                        <input type="text" name="country" id="doc-ipt-file-1" value="${movieInfo.country}">
                    </div>
                </div>
                <div class="am-form-group am-cf">
                    <div class="zuo">电影类型：</div>
                    <div class="you" style="height: 45px;">
                        <c:forEach var="type" items="${typeList}">
                            <input type="checkbox" name="typeId" value="${type.typeId}"
                                    <c:forEach var="id" items="${idList}">
                                        <c:if test="${id==type.typeId}">
                                            checked="checked"
                                        </c:if>
                                    </c:forEach>
                            >${type.typeName}</input>
                        </c:forEach>
                    </div>
                </div>
                <div class="am-form-group am-cf">
                    <div class="you" style="margin-left: 11%;">
                        <a href="#" class="am-btn am-btn-success am-radius"
                           onclick="formSubmit2('update','_self');this.blur();">更新</a>&nbsp; &raquo; &nbsp;
                        <a href="#" class="am-btn am-btn-secondary am-radius"
                           onclick="window.history.go(-1);this.blur();">
                        返回</a>
                    </div>
                </div>
            </form>
        </div>


        <jsp:include page="backfoot.jsp"/>


    </div>

</div>

</div>




</body>
<%--<script type="text/javascript">--%>
<%--$(function() {//页面加载的时候触发--%>
<%--var boxObj = $("input:checkbox[name='typeId']");  //获取所有的复选框--%>
<%--var typeids = ${typeids}; //用el表达式获取在控制层存放的复选框的值为字符串类型--%>
<%--var target = typeids.split(','); //去掉它们之间的分割符“，”--%>
<%--for(i=0;i<boxObj.length;i++){--%>
<%--for(j=0;j<target.length;j++){--%>
<%--if(boxObj[i].value() == target[j])  //如果值与修改前的值相等--%>
<%--{--%>
<%--alert(boxObj[i].value());--%>
<%--boxObj[i].checked= checked;--%>
<%--break;--%>
<%--}--%>
<%--}--%>
<%--}--%>
<%--})--%>
<%--</script>--%>
</html>
