<%--
  Created by IntelliJ IDEA.
  User: HQIZCC
  Date: 2017/10/19
  Time: 14:19
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
<!--[if lte IE 9]><p class="browsehappy">升级你的浏览器吧！ <a href="http://se.360.cn/" target="_blank">升级浏览器</a>以获得更好的体验！</p>
<![endif]-->


<body>
<header class="am-topbar admin-header">
    <div class="am-topbar-brand"><img src="${ctx}/staticfile/assets/i/logo.png"></div>

    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">
        <ul class="am-nav am-nav-pills am-topbar-nav admin-header-list">

            <li class="am-dropdown tognzhi" data-am-dropdown>
                <button class="am-btn am-btn-primary am-dropdown-toggle am-btn-xs am-radius am-icon-bell-o"
                        data-am-dropdown-toggle> 全部功能<span class="am-badge am-badge-danger am-round">6</span></button>
                <ul class="am-dropdown-content">


                    <li class="am-dropdown-header">所有的功能都在这里</li>


                    <li><a href="#">添加新电影 <span class="am-badge am-badge-danger am-round">556</span></a></li>
                    <li><a href="#">电影列表 <span class="am-badge am-badge-danger am-round">69</span></a></a></li>
                    <li><a href="#">电影分类</a></li>
                    <li><a href="#">用户列表</a></li>


                </ul>
            </li>


            <li class="kuanjie">

                <a href="${ctx}/backend/movieList">电影列表</a>
                <a href="用户列表.html">用户列表</a>
            </li>

            <li class="soso">

                <p>

                    <select data-am-selected="{btnWidth: 70, btnSize: 'sm', btnStyle: 'default'}">
                        <option value="o">电影</option>
                        <option value="o">用户</option>
                    </select>

                </p>

                <p class="ycfg"><input type="text" class="am-form-field am-input-sm" placeholder="搜索全网"/></p>
                <p>
                    <button class="am-btn am-btn-xs am-btn-default am-xiao"><i class="am-icon-search"></i></button>
                </p>
            </li>


            <li class="am-hide-sm-only" style="float: right;"><a href="javascript:;" id="admin-fullscreen"><span
                    class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
        </ul>
    </div>
</header>

<div class="am-cf admin-main">

    <div class="nav-navicon admin-main admin-sidebar">


        <div class="sideMenu am-icon-dashboard" style="color:#aeb2b7; margin: 10px 0 0 0;"> 欢迎系统管理员：清风抚雪</div>
        <div class="sideMenu">
            <h3 class="am-icon-flag"><em></em> <a href="#">电影集中营</a></h3>
            <ul>
                <li><a href="${ctx}/backend/movieList">电影列表</a></li>
                <li><a href="电影分类.html">电影分类</a></li>
            </ul>
            <h3 class="am-icon-cart-plus"><em></em> <a href="#"> 电影管理</a></h3>
            <ul>
                <li><a href="${ctx}/backend/addMovie">添加新电影</a></li>
            </ul>
            <h3 class="am-icon-users"><em></em> <a href="#">用户管理</a></h3>
            <ul>
                <li><a href="用户列表.html">用户列表</a></li>
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

    <div class=" admin-content">

        <div class="daohang">
            <ul>
                <li>
                    <button type="button" class="am-btn am-btn-default am-radius am-btn-xs"> 首页
                </li>
                <li>
                    <button type="button" class="am-btn am-btn-default am-radius am-btn-xs">帮助中心<a
                            href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close="">×</a>
                    </button>
                </li>
                <li>
                    <button type="button" class="am-btn am-btn-default am-radius am-btn-xs">奖金管理<a
                            href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close="">×</a>
                    </button>
                </li>
                <li>
                    <button type="button" class="am-btn am-btn-default am-radius am-btn-xs">产品管理<a
                            href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close="">×</a>
                    </button>
                </li>


            </ul>


        </div>


        <div class="admin-biaogelist">

            <div class="listbiaoti am-cf">
                <ul class="am-icon-flag on"> 栏目名称</ul>

                <dl class="am-icon-home" style="float: right;"> 当前位置： 首页 > <a href="${ctx}/backend/movieList">电影列表</a>
                </dl>

                <dl>
                    <button type="button" class="am-btn am-btn-danger am-round am-btn-xs am-icon-plus"><a href="${ctx}/backend/addMovie">添加新电影</a></button>
                </dl>


            </div>

            <div class="am-btn-toolbars am-btn-toolbar am-kg am-cf">
                <ul>
                    <li>
                        <div class="am-btn-group am-btn-group-xs">
                            <select data-am-selected="{btnWidth: 90, btnSize: 'sm', btnStyle: 'default'}">
                                <option value="b">电影分类</option>
                                <option value="o">电影评分</option>
                            </select>
                        </div>
                    </li>
                    <li>
                        <div class="am-btn-group am-btn-group-xs">
                            <select data-am-selected="{btnWidth: 90, btnSize: 'sm', btnStyle: 'default'}">
                                <option value="b">产品分类</option>
                                <option value="o">下架</option>
                            </select>
                        </div>
                    </li>
                    <li style="margin-right: 0;">
                        <span class="tubiao am-icon-calendar"></span>
                        <input type="text" class="am-form-field am-input-sm am-input-zm  am-icon-calendar"
                               placeholder="上映日期" data-am-datepicker="{theme: 'success',}" readonly/>
                    </li>


                    <li style="margin-left: -10px;">
                        <div class="am-btn-group am-btn-group-xs">
                            <select data-am-selected="{btnWidth: 90, btnSize: 'sm', btnStyle: 'default'}">
                                <option value="b">电影分类</option>
                                <option value="o">下架</option>
                            </select>
                        </div>
                    </li>
                    <li><input type="text" class="am-form-field am-input-sm am-input-xm" placeholder="关键词搜索"/></li>
                    <li>
                        <button type="button" class="am-btn am-radius am-btn-xs am-btn-success"
                                style="margin-top: -1px;">搜索
                        </button>
                    </li>
                </ul>
            </div>


            <form class="am-form am-g">
                <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
                    <thead>
                    <tr class="am-success">
                        <th class="table-check"><input type="checkbox"/></th>
                        <th class="table-id">排序</th>
                        <th class="table-title">电影名称</th>
                        <th class="table-author am-hide-sm-only">上映时间</th>
                        <th class="table-date am-hide-sm-only">所属国家</th>
                        <th width="163px" class="table-set">电影评分</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${movieList}" var="m" varStatus="status">
                        <tr>
                            <td hidden="hidden"><input type="text" value="${m.movieId}"></td>
                            <td><input type="checkbox"/></td>
                            <td>${status.index+1}</td>
                            <td>${m.movieName}</td>
                            <td>${m.showTime}</td>
                            <td class="am-hide-sm-only">${m.country}</td>
                            <td class="am-hide-sm-only">${m.avgscore}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <div class="am-btn-group am-btn-group-xs">
                    <button type="button" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 删除</button>
                    <button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 上架</button>
                    <button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 下架</button>
                    <button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 移动</button>
                    <button type="button" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 新增</button>
                    <button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 保存</button>
                    <button type="button" class="am-btn am-btn-default"><span class="am-icon-archive"></span> 移动
                    </button>
                    <button type="button" class="am-btn am-btn-default"><span class="am-icon-trash-o"></span> 删除
                    </button>
                </div>

                <ul class="am-pagination am-fr">
                    <c:forEach begin="1" end="${allpages}" step="1" var="p">

                        <li><a href="${ctx}/backend/movieList?showpage=${p}">${p}</a></li>

                    </c:forEach>
                </ul>


                <hr/>
                <p style="color:red;">注：各大站内管理员删除数据是请谨慎操作</p>
            </form>


            <div class="foods">
                <ul>
                    版权所有@2017 V_WORD
                </ul>
                <dl>
                    <a href="" title="返回头部" class="am-icon-btn am-icon-arrow-up"></a>
                </dl>
            </div>


        </div>

    </div>


</div>

<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="${ctx}/staticfile/assets/js/polyfill/rem.min.js"></script>
<script src="${ctx}/staticfile/assets/js/polyfill/respond.min.js"></script>
<script src="${ctx}/staticfile/assets/js/amazeui.legacy.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="${ctx}/staticfile/assets/js/amazeui.min.js"></script>
<!--<![endif]-->


</body>
</html>
