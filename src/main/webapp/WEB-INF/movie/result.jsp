<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="../base.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!DOCTYPE html>
<!--[if lt IE 7 ]>
<html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]>
<html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]>
<html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="en"> <!--<![endif]-->
<head>

    <!-- Basic Page Needs
  ================================================== -->
    <meta charset="utf-8">
    <title>zMovie</title>
    <meta name="description" content="Free Responsive Html5 Css3 Templates | zerotheme.com">
    <meta name="author" content="www.zerotheme.com">

    <!-- Mobile Specific Metas
  ================================================== -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <!-- CSS
  ================================================== -->
    <link rel="stylesheet" href="${ctx}/staticfile/css/zerogrid.css">
    <link rel="stylesheet" href="${ctx}/staticfile/css/style.css">
    <link rel="stylesheet" href="${ctx}/staticfile/css/responsive.css">

    <style>

    </style>


    <script src="${ctx}/staticfile/lib/jquery-1.7.2.min.js" type="text/javascript"></script>

    <script type="text/javascript">
        $(document).ready(function () {

            commClick();
        });

        function commClick() {
            var a = 1;
            if (a == 1) {
                $(".commForm").toggle();
            } else {

            }

        }

    </script>

</head>
<body>
<%@include file="../head.jsp" %>
<div class="wrap-body">


    <!--////////////////////////////////////Container-->
    <section id="container">
        <div class="wrap-container zerogrid">
            <div id="main-content" class="col-2-3">
                <div class="wrap-content">

                    <%--<h1 style="font-size:40px;padding-top:50px;">搜索结果</h1>--%>
                    <br/>

                    <div class="widget wid-related">
                        <div class="wid-header">
                            <h5>搜索结果:</h5>
                        </div>
                        <div class="wid-content">
                            <table width="95%" border="1" cellpadding="2" cellspacing="1"
                                   style="table-layout:fixed;font-size:18px;">
                                <c:forEach items="${movieInfoList}" var="m">
                                    <tr>
                                        <td>
                                            <!-- 用户 -->
                                            <a href="/movie/single?movieId=${m.movieId}"><img
                                                    style="display: inline-block;width:100px" src="${ctx}/${m.poster}"
                                                    style="width:70px;height:100px"/></a>

                                            <ul style="display: inline-block;width: 600px">
                                                <li>电影名称:${m.movieName}</li>
                                                <li>演员:${m.actor}</li>
                                                <li>国家:${m.country}</li>
                                                <li>上映时间:${m.showTime}</li>
                                                <li>导演:${m.director}</li>
                                                <li>评分:${m.avgscore} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                    <a style="color: #c7254e" href="/movie/single?movieId=${m.movieId}">查看详情</a>
                                                </li>
                                            </ul>
                                            <hr style="height:1px;border:none;border-top:1px dashed #F8F8FF;"/>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                            <center>
                                <c:forEach begin="1" end="${pages}" step="1" var="p">
                                    <a class="page gradient"
                                       href="${ctx}/movie/findeResultPage?page=${p}&search=${search}">${p}</a>
                                </c:forEach>
                            </center>
                            <center>
                                <c:forEach begin="1" end="${typepages}" step="1" var="p">
                                    <a class="page gradient"
                                       href="${ctx}/movie/typeSearch?page=${p}&typeId=${typeId}">${p}</a>
                                </c:forEach>
                            </center>
                        </div>
                    </div>
                </div>
            </div>


            <!---- Start Widget ---->
            <%@include file="../right.jsp" %>

        </div>
    </section>


</div>

</body>
</html>