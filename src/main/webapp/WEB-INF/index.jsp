<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="base.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <%@include file="head.jsp"%>
<!--////////////////////////////////////Header-->
 
<div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >企业网站模板</a></div>

<!--////////////////////////////////////Container-->
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
										<a href="single.html" class="info" title="Full Image"><img src="${ctx}/staticfile/images/play_button_64.png" /></a>
									  </div>

									</div>
									<div class="clear"></div>
									<a href="single.html"><h3>${m.movieName}</h3></a>
									<span>${m.country}</span>
								</div>
							</div>
						</div>
						<%--<div class="col-1-4">--%>
							<%--<div class="wrap-col">--%>
								<%--<div class="post">--%>
									<%--<div class="view effect">  --%>
									  <%--<img class="thumb" src="${ctx}/staticfile/images/2.jpg"  />--%>
									  <%--<div class="mask">  --%>
										<%--<a href="single.html" class="info" title="Full Image"><img src="${ctx}/staticfile/images/play_button_64.png" /></a>--%>
									  <%--</div>  --%>
									<%--</div>--%>
									<%--<a href="single.html"><h3>Film's Name</h3></a>--%>
									<%--<span>Lorem ipsum dolor sit</span>--%>
								<%--</div>--%>
							<%--</div>--%>
						<%--</div>--%>
						<%--<div class="col-1-4">--%>
							<%--<div class="wrap-col">--%>
								<%--<div class="post">--%>
									<%--<div class="view effect">  --%>
									 <%--<img class="thumb" src="${ctx}/staticfile/images/4.jpg"  />--%>
									  <%--<div class="mask">  --%>
										<%--<a href="single.html" class="info" title="Full Image"><img src="${ctx}/staticfile/images/play_button_64.png" /></a>--%>
									  <%--</div>  --%>
									<%--</div>--%>
									<%--<a href="single.html"><h3>Lord Of War</h3></a>--%>
									<%--<span>Lorem ipsum dolor sit</span>--%>
								<%--</div>--%>
							<%--</div>--%>
						<%--</div>--%>
						<%--<div class="col-1-4">--%>
							<%--<div class="wrap-col">--%>
								<%--<div class="post">--%>
									<%--<div class="view effect"> --%>
									  <%--<img class="thumb" src="${ctx}/staticfile/images/5.jpg"  />--%>
									  <%--<div class="mask">  --%>
										<%--<a href="single.html" class="info" title="Full Image"><img src="${ctx}/staticfile/images/play_button_64.png" /></a>--%>
									  <%--</div>  --%>
									<%--</div>--%>
									<%--<a href="single.html"><h3>The Sorcerer's Apprentice</h3></a>--%>
									<%--<span>Lorem ipsum dolor sit</span>--%>
								<%--</div>--%>
							<%--</div>--%>
						<%--</div>--%>
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
                                            <a href="single.html" class="info" title="Full Image"><img src="${ctx}/staticfile/images/play_button_64.png" /></a>
                                        </div>

                                    </div>
                                    <div class="clear"></div>
                                    <a href="single.html"><h3>${m.movieName}</h3></a>
                                    <span>${m.country}</span>
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
						<%--<div class="col-1-4">--%>
							<%--<div class="wrap-col">--%>
								<%--<div class="post">--%>
									<%--<div class="view effect">  --%>
									  <%--<img class="thumb" src="${ctx}/staticfile/images/2.jpg"  />--%>
									  <%--<div class="mask">  --%>
										<%--<a href="single.html" class="info" title="Full Image"><img src="${ctx}/staticfile/images/play_button_64.png" /></a>--%>
									  <%--</div>  --%>
									<%--</div>--%>
									<%--<a href="single.html"><h3>Film's Name</h3></a>--%>
									<%--<span>Lorem ipsum dolor sit</span>--%>
								<%--</div>--%>
							<%--</div>--%>
						<%--</div>--%>
                    <%--</div>--%>
						<%--<div class="col-1-4">--%>
							<%--<div class="wrap-col">--%>
								<%--<div class="post">--%>
									<%--<div class="view effect">  --%>
									 <%--<img class="thumb" src="${ctx}/staticfile/images/4.jpg"  />--%>
									  <%--<div class="mask">  --%>
										<%--<a href="single.html" class="info" title="Full Image"><img src="${ctx}/staticfile/images/play_button_64.png" /></a>--%>
									  <%--</div>  --%>
									<%--</div>--%>
									<%--<a href="single.html"><h3>Lord Of War</h3></a>--%>
									<%--<span>Lorem ipsum dolor sit</span>--%>
								<%--</div>--%>
							<%--</div>--%>
						<%--</div>--%>
						<%--<div class="col-1-4">--%>
							<%--<div class="wrap-col">--%>
								<%--<div class="post">--%>
									<%--<div class="view effect"> --%>
									  <%--<img class="thumb" src="${ctx}/staticfile//images/5.jpg"  />--%>
									  <%--<div class="mask">  --%>
										<%--<a href="single.html" class="info" title="Full Image"><img src="${ctx}/staticfile/images/play_button_64.png" /></a>--%>
									  <%--</div>  --%>
									<%--</div>--%>
									<%--<a href="single.html"><h3>The Sorcerer's Apprentice</h3></a>--%>
									<%--<span>Lorem ipsum dolor sit</span>--%>
								<%--</div>--%>
							<%--</div>--%>
						<%--</div>--%>


					<div class="row">

                        <c:forEach items="${movieList3}" var="m">
                            <div class="col-1-4">
                                <div class="wrap-col">
                                    <div class="post">
                                        <div class="view effect">
                                            <img class="thumb" src="${ctx}/${m.poster}"/>
                                            <div class="mask">
                                                <a href="single.html" class="info" title="Full Image"><img src="${ctx}/staticfile/images/play_button_64.png" /></a>
                                            </div>

                                        </div>
                                        <div class="clear"></div>
                                        <a href="single.html"><h3>${m.movieName}</h3></a>
                                        <span>${m.country}</span>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
						<%--<div class="col-1-4">--%>
							<%--<div class="wrap-col">--%>
								<%--<div class="post">--%>
									<%--<div class="view effect">  --%>
									  <%--<img class="thumb" src="${ctx}/staticfile/images/6.jpg"  />--%>
									  <%--<div class="mask">  --%>
										<%--<a href="single.html" class="info" title="Full Image"><img src="${ctx}/staticfile/images/play_button_64.png" /></a>--%>
									  <%--</div>  --%>
									<%--</div>--%>
									<%--<a href="single.html"><h3>Seeking Justice</h3></a>--%>
									<%--<span>Lorem ipsum dolor sit</span>--%>
								<%--</div>--%>
							<%--</div>--%>
						<%--</div>--%>
						<%--<div class="col-1-4">--%>
							<%--<div class="wrap-col">--%>
								<%--<div class="post">--%>
									<%--<div class="view effect">  --%>
									  <%--<img class="thumb" src="${ctx}/staticfile/images/7.jpg"  />--%>
									  <%--<div class="mask">  --%>
										<%--<a href="single.html" class="info" title="Full Image"><img src="${ctx}/staticfile/images/play_button_64.png" /></a>--%>
									  <%--</div>  --%>
									<%--</div>--%>
									<%--<a href="single.html"><h3>Season Of The Witch</h3></a>--%>
									<%--<span>Lorem ipsum dolor sit</span>--%>
								<%--</div>--%>
							<%--</div>--%>
						<%--</div>--%>
						<%--<div class="col-1-4">--%>
							<%--<div class="wrap-col">--%>
								<%--<div class="post">--%>
									<%--<div class="view effect">  --%>
									  <%--<img class="thumb" src="${ctx}/staticfile/images/8.jpg"  />--%>
									  <%--<div class="mask">  --%>
										<%--<a href="single.html" class="info" title="Full Image"><img src="${ctx}/staticfile/images/play_button_64.png" /></a>--%>
									  <%--</div>  --%>
									<%--</div>--%>
									<%--<a href="single.html"><h3>Three Mustketeers</h3></a>--%>
									<%--<span>Lorem ipsum dolor sit</span>--%>
								<%--</div>--%>
							<%--</div>--%>
						<%--</div>--%>
                    <center>
                    <c:forEach begin="1" end="${pages}" step="1" var="p">
                        <a class="page gradient" href="${ctx}/movie/findeAllPage?page=${p}">${p}</a>
                    </c:forEach>
                    </center>
				</div>
		</div>

		<div id="sidebar" class="col-1-3">
			<div class="wrap-sidebar">
				<!---- Start Widget ---->
				<div class="widget wid-new-updates">
					<div class="wid-header">
						<h5>热门推荐!</h5>
					</div>
					<div class="wid-content">
						<ul>
						<li><a href="#">Mad Max: Fury Road</a><span><img src="${ctx}/staticfile/images/hot.png" /></span></li>
						<li><a href="#">The Age of Adaline</a><span><img src="${ctx}/staticfile/images/hot.png" /></span></li>
						<li><a href="#">Pound of Flesh</a><span><img src="${ctx}/staticfile/images/hot.png" /></span></li>
						<li><a href="#">Bloodbath Island</a><span><img src="${ctx}/staticfile/images/hot.png" /></span></li>
						<li><a href="#">Pound of Flesh</a><span><img src="${ctx}/staticfile/images/hot.png" /></span></li>
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
						<h5>Lastest Updates</h5>
					</div>
					<div class="wid-content">
						<div class="post">
							<a href="#"><img src="${ctx}/staticfile/images/1.jpg"/></a>
							<div class="wrapper">
							  <a href="#"><h6>A Blue Morning</h6></a>
							  <p>March 1, 2015</p>
							  <a href="#"><img src="${ctx}/staticfile/images/star.png" /></a>
							</div>
						</div>
						<div class="post">
							<a href="#"><img src="${ctx}/staticfile/images/2.jpg"/></a>
							<div class="wrapper">
							 <a href="#"><h6>A Blue Morning</h6></a>
							  <p>March 1, 2015</p>
							  <a href="#"><img src="${ctx}/staticfile/images/star.png" /></a>
							</div>
						</div>
						<div class="post">
							<a href="#"><img src="${ctx}/staticfile/images/3.jpg"/></a>
							<div class="wrapper">
							 <a href="#"><h6>A Blue Morning</h6></a>
							  <p>March 1, 2015</p>
							  <a href="#"><img src="${ctx}/staticfile/images/star.png" /></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
    </div>
</section>

 
 <!--尾部*******************************-->
    <%@include file="footer.jsp"%>

</div>
<script src="${ctx}/staticfile/js/css3-mediaqueries.js"></script>
<script src="${ctx}/staticfile/js/jquery.min.js"></script>
</body></html>