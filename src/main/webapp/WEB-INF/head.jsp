<%@ page language="java" pageEncoding="utf-8" %>
<style>
    #nav1 {
        margin: 0px auto 0px auto;
        display: inline-block;
    }

    #nav1 .active a {
        background: #fcab2b !important;
    }

    #nav2 {
        margin: 0px auto 0px auto;
        display: inline-block;
    }

    #menu {
        background-color: #000;
        border-bottom: 4px solid #fcab2b;
        text-align: center;
    }

    #menu ul {
        padding: 0px;
        margin: 0px;
        list-style: none;
    }

    #menu ul li {
        display: inline;
    }

    #menu ul form {
        float: left;
        padding: 0px 20px;
    }

    #menu ul a {
        float: left;
        color: #fff;
        text-transform: uppercase;
        padding: 10px 20px;
        font-size: 15px;
        letter-spacing: 2px;
    }

    #menu a:hover {
        background: #fcab2b;
    }

    #menu2 {
        background-color: #000;
        border-bottom: 4px solid #fcab2b;
        text-align: center;
    }

    #menu2 ul {
        padding: 0px;
        margin: 0px;
        list-style: none;
    }

    #menu2 ul li {
        display: inline;
    }

    #menu2 ul form {
        float: left;
        padding: 0px 20px;
    }

    #menu2 ul a {
        float: left;
        color: #fff;
        text-transform: uppercase;
        padding: 0px 20px;
        font-size: 10px;
        letter-spacing: 2px;
    }

    #menu2 a:hover {
        background: #fcab2b;
    }
</style>
<header>
    <div class="top-bar">
        <div class="wrap-top zerogrid">
            <div class="row">
                <div class="col-1-2">
                    <div class="wrap-col">
                        <ul>
                            <li class="mail">
                                <c:if test="${ empty sessionScope.user_login }">
                                    <a style="color: white" href="${ ctx }/login/signin">登录</a>&nbsp;&nbsp;|&nbsp;&nbsp;
                                    <a style="color: white" href="${ ctx }/login/signup">注册</a>
                                </c:if>
                                <c:if test="${ !(empty sessionScope.user_login) }">
                                    欢迎${ user_login.username } 回来,&nbsp;
                                    <a style="color: white" href="${ ctx }/login/logout">退出</a>
                                    &nbsp;&nbsp;|&nbsp;&nbsp;<a href="${ctx}/userPerInfo?userId=${user_login.userId}" style="color: #ffffff;" target="_self">个人信息</a>
                                </c:if>

                                <c:if test="${ !(empty sessionScope.user_login) and user_login.role.roleId!=1 }">
                                    &nbsp;&nbsp;|&nbsp;&nbsp;<a href="/backend/index" style="color: #ffffff;" target="_self">后台管理</a>
                                </c:if>
                            </li>
                            <%--<li class="phone"><a href="#"><p>退出</p></a> </li>  --%>
                        </ul>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <div class="wrap-header zerogrid">
        <div class="row">
            <div class="col-1-2">
                <div class="wrap-col">
                    <div class="logo"><a href="#"><img src="${ctx}/staticfile/images/logo.png"/></a></div>
                </div>
            </div>
            <div class="col-1-2">
                <div class="wrap-col f-right">
                    <form method="get" action="/movie/search" id="search">
                        <input name="search" type="text" size="40" placeholder="SearchEverything..."/>
                        <input type="submit" value="搜索全部">
                    </form>
                </div>
            </div>
        </div>
        <div class="row">
            <div id="menu">
                <nav id="nav1">
                    <div class="wrap-nav">
                        <ul>
                            <li><a href="/movie/showmovie">首页</a></li>
                            <li><a href="#"> </a></li>
                            <li><a href="/rank/list">排行榜</a></li>
                            <li><a href="single.html"> </a></li>
                            <li><a href="/html/baiduMap.html">最近电影院</a></li>
                            <li><a href="#"> </a></li>
                            <li><a href="https://github.com/a350844866/LTYP">关于我们</a></li>
                            <li><a href="#"> </a></li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
        <%--<div class="row">--%>
        <%--<p id="caidan" class="active">--%>
        <%--<div class="wrap-nav">--%>
        <%--<a href="/movie/typeSearch?typeId=1" target="_self">剧情</a>--%>
        <%--<a href="/movie/typeSearch?typeId=10" target="_self">战争</a>--%>
        <%--<a href="/movie/typeSearch?typeId=2" target="_self">动画</a>--%>
        <%--<a href="/movie/typeSearch?typeId=3" target="_self">爱情</a>--%>
        <%--<a href="/movie/typeSearch?typeId=4" target="_self">科幻</a>--%>
        <%--<a href="/movie/typeSearch?typeId=5" target="_self">动作</a>--%>
        <%--<a href="/movie/typeSearch?typeId=6" target="_self">犯罪</a>--%>
        <%--<a href="/movie/typeSearch?typeId=7" target="_self">恐怖</a>--%>
        <%--<a href="/movie/typeSearch?typeId=8" target="_self">励志</a>--%>
        <%--<a href="/movie/typeSearch?typeId=9" target="_self">喜剧</a>--%>
        <%--</div>--%>
        <%--</p>--%>
        <%--</div>--%>
        <div class="row">
            <div id="menu2">
                <nav id="nav2">
                    <div class="wrap-nav">
                        <ul style="margin-right: 100px">
                            <c:forEach items="${allType}" var="type">
                                <a href="/movie/typeSearch?typeId=${type.typeId}" target="_self">${type.typeName}</a>
                                <%--<a href="/movie/typeSearch?typeId=1" target="_self">剧情</a>--%>
                                <%--<a href="/movie/typeSearch?typeId=10" target="_self">战争</a>--%>
                                <%--<a href="/movie/typeSearch?typeId=2" target="_self">动画</a>--%>
                                <%--<a href="/movie/typeSearch?typeId=3" target="_self">爱情</a>--%>
                                <%--<a href="/movie/typeSearch?typeId=4" target="_self">科幻</a>--%>
                                <%--<a href="/movie/typeSearch?typeId=5" target="_self">动作</a>--%>
                                <%--<a href="/movie/typeSearch?typeId=6" target="_self">犯罪</a>--%>
                                <%--<a href="/movie/typeSearch?typeId=7" target="_self">恐怖</a>--%>
                                <%--<a href="/movie/typeSearch?typeId=8" target="_self">励志</a>--%>
                                <%--<a href="/movie/typeSearch?typeId=9" target="_self">喜剧</a>--%>
                            </c:forEach>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
    </div>
</header>