<%@ page language="java" pageEncoding="utf-8" %>
<%@ include file="base.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <!-- Basic Page Needs
  ================================================== -->
    <meta charset="utf-8">
    <title>乐途影评网</title>
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

</head>
<body>
<div class="wrap-body">
    <%@include file="head.jsp" %>
    <div class="copyrights">Collect from <a href="http://www.cssmoban.com/">企业网站模板</a></div>
    <section id="container">
        <div class="wrap-container zerogrid">
            <div id="main-content" class="col-2-3">
                <div class="wrap-content">
                    <div class="movie">
                        <div class="row type">
                            <div class="title">
                                <center><h2>MOVIE</h2></center>
                            </div>
                        </div>
                        <div class="row">
                            <c:forEach items="${movieList}" var="m">
                                <div class="col-1-4">
                                    <div class="wrap-col">
                                        <div class="post">
                                            <div class="view effect">
                                                <img class="thumb" src="${ctx}/${m.poster}"/>
                                                <div class="mask">
                                                    <a href="/movie/single?movieId=${m.movieId}" class="info"
                                                       title="Full Image"><img
                                                            src="${ctx}/staticfile/images/play_button_64.png"/></a>
                                                </div>
                                            </div>
                                            <div class="clear"></div>
                                            <a href="/movie/single?movieId=${m.movieId}"><h3>${m.movieName}</h3></a>
                                            <span>${m.country}</span>
                                        </div>
                                    </div>
                                </div>

                            </c:forEach>
                        </div>


                        <div class="row">
                            <c:forEach items="${movieList2}" var="m">
                                <div class="col-1-4">
                                    <div class="wrap-col">
                                        <div class="post">
                                            <div class="view effect">
                                                <img class="thumb" src="${ctx}/${m.poster}"/>
                                                <div class="mask">
                                                    <a href="/movie/single?movieId=${m.movieId}" class="info"
                                                       title="Full Image"><img
                                                            src="${ctx}/staticfile/images/play_button_64.png"/></a>
                                                </div>
                                            </div>
                                            <div class="clear"></div>
                                            <a href="/movie/single?movieId=${m.movieId}"><h3>${m.movieName}</h3></a>
                                            <span>${m.country}</span>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <div class="row">
                            <c:forEach items="${movieList3}" var="m">
                                <div class="col-1-4">
                                    <div class="wrap-col">
                                        <div class="post">
                                            <div class="view effect">
                                                <img class="thumb" src="${ctx}/${m.poster}"/>
                                                <div class="mask">
                                                    <a href="/movie/single?movieId=${m.movieId}" class="info"
                                                       title="Full Image"><img
                                                            src="${ctx}/staticfile/images/play_button_64.png"/></a>
                                                </div>

                                            </div>
                                            <div class="clear"></div>
                                            <a href="/movie/single?movieId=${m.movieId}"><h3>${m.movieName}</h3></a>
                                            <span>${m.country}</span>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>

                        <center>
                            <c:forEach begin="1" end="${pages}" step="1" var="p">
                                <a class="page gradient" href="${ctx}/movie/findeAllPage?page=${p}">${p}</a>
                            </c:forEach>
                        </center>
                    </div>
                </div>
                <%@include file="right.jsp" %>
            </div>
        </div>
    </section>


    <!--尾部*******************************-->
    <%@include file="footer.jsp" %>

</div>
<script src="${ctx}/staticfile/js/css3-mediaqueries.js"></script>
<script src="${ctx}/staticfile/js/jquery.min.js"></script>
</body>
</html>