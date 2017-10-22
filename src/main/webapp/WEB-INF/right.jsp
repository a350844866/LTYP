<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/21
  Time: 8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="sidebar" class="col-1-3">
    <div class="wrap-sidebar">
        <!---- Start Widget ---->
        <div class="widget wid-new-updates">
            <div class="wid-header">
                <h5>热门推荐!</h5>
            </div>
            <div class="wid-content">
                <ul>
                    <li><a href="#">Mad Max: Fury Road</a><span><img
                            src="${ctx}/staticfile/images/hot.png"/></span></li>
                    <li><a href="http://www.dytt8.net/html/gndy/dyzz/20171010/55256.html">猩球崛起3:终极之战</a><span><img
                            src="${ctx}/staticfile/images/hot.png"/></span></li>
                    <li><a href="#">Pound of Flesh</a><span><img
                            src="${ctx}/staticfile/images/hot.png"/></span></li>
                    <li><a href="#">Bloodbath Island</a><span><img
                            src="${ctx}/staticfile/images/hot.png"/></span></li>
                    <li><a href="#">Pound of Flesh</a><span><img
                            src="${ctx}/staticfile/images/hot.png"/></span></li>
                </ul>
            </div>
        </div>
        <!---- Start Widget ---->
        <div class="widget wid-tag">
            <div class="wid-header">
                <h5>最近搜索</h5>
            </div>
            <div class="wid-content">
                <ul>
                    <li><a href="#">animals</a></li>
                    <li><a href="#">ssdad</a></li>
                    <li><a href="#">ss</a></li>
                    <li><a href="#">asdas</a></li>
                    <li><a href="#">asdsals</a></li>
                    <li><a href="#">dasdas</a></li>
                    <li><a href="#">animals</a></li>
                    <li><a href="#">aasdasls</a></li>
                </ul>
            </div>
        </div>
        <!---- Start Widget ---->


        <!---- Start Widget ---->
        <div class="widget wid-last-updates">
            <div class="wid-header">
                <h5>最近 更新</h5>
            </div>
            <c:forEach items="${newUpdate}" var="u">
                <div class="wid-content">
                    <div class="post">
                        <a href="/movie/single?movieId=${u.movieId}"><img src="${ctx}/${u.poster}"/></a>
                        <br>
                        <a href="/movie/single?movieId=${u.movieId}"><h6>${u.movieName}</h6></a>
                        <p>上映时间:${u.showTime}</p>
                            <%--<p>演员:${u.actor}</p>--%>
                        <p>国家:${u.country}</p>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
