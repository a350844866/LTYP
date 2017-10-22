<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../base.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html lang="en"> <!--<![endif]-->
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
	
	
	<script src="${ctx}/staticfile/lib/jquery-1.7.2.min.js" type="text/javascript"></script>
	
	<script type="text/javascript">
		$(document).ready(function(){
  			commClick();
		});

		function commClick(){
			var a = 1;
			if(a==1){
				$(".commForm").toggle();
			}else{
				
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
				<article>
					<div class="art-header">
						<div class="col-1-3">
							<div class="wrap-col">
								<img src="${ctx}/${movieInfo.poster}" />
							</div>
						</div>
						<div class="col-2-3">
							<div class="wrap-col">
								<ul>
									<li><p>电影名称:${movieInfo.movieName}</p></li>
									<li><p>导演: ${movieInfo.director}</p></li>
									<li><p>演员: ${movieInfo.actor}</p></li>
									<li><p>国家: ${movieInfo.country}</p></li>
									<li><p>上映日期: ${movieInfo.showTime}</p></li>
                                    <li><p>评分: ${movieInfo.avgscore}</p></li>
                                    <li><p>时长: ${movieInfo.playtime}</p></li>
                                    <li><a class="button bt1" onclick="commClick()" href="#comment">评论</a></li>
								</ul>
							</div>
						</div>
						<div class="clear"></div>
					</div>
					<div class="art-content">
						<h3>剧情简介:</h3>
                        <img src="${ctx}/${movieimg.imageUrl}" />
                        ${movieInfo.description}
						<div class="clear"></div>
					</div>
				</article>
				<div class="widget wid-related">
					<div class="wid-header">
						<h5>影评:</h5>
					</div>
					<div class="wid-content">
						<table width="95%" border="1" cellpadding="2" cellspacing="1" style="table-layout:fixed;font-size:18px;">   
						<c:forEach items="${commentList}" var="c">
						<tr>
							<td>
								<!-- 用户 -->
								评价时间:<fmt:formatDate value="${c.createTime}" pattern="yyyy-MM-dd"/> 评价人: ${c.user.username} 评价:
								<br/>
								<!-- 影评内容 -->
								${c.commDetail}
								<br/>
								<button type="submit" value="good" style="margin-left:680px">点赞(5)</button>
								<hr style="height:1px;border:none;border-top:1px dashed #F8F8FF;"/>
							</td>
						</tr>
                        </c:forEach>


						</table>
                        <button class="comm" id="comment" onclick="commClick()">评论</button>

						
						
						<div class="commForm">
						<form action="/movie/commitComment" target="_self">
							<input type="hidden" name="userId" value="${user.userId}">
							<input type="hidden" name="movieId" value="${movieInfo.movieId}">
							<label for="comment">用户评论:</label>
							<textarea name="commDetail" style="width: 600px; height: 80px" placeholder="您对此电影有什么看法呢?小影期待您的评论"></textarea>
                            <button type="submit">提交评论</button>

                        </form>
						</div>

                        <form action="/movie/insertScore" target="_self">
                            <input type="text" name="userId" value="${user_login.userId}" hidden="hidden">
                            <input type="text" name="movieId" value="${movieInfo.movieId}" hidden="hidden">
                            请评分:
                            <input type="radio" name="score" value="1">1
                            <input type="radio" name="score" value="2">2
                            <input type="radio" name="score" value="3">3
                            <input type="radio" name="score" value="4">4
                            <input type="radio" name="score" value="5" checked="checked">5
                            <input type="radio" name="score" value="6">6
                            <input type="radio" name="score" value="7">7
                            <input type="radio" name="score" value="8">8
                            <input type="radio" name="score" value="9">9
                            <input type="radio" name="score" value="10">10
                            <button type="submit">提交评分</button>
                            <p style="color: red">温馨提示:每个用户只有第一次评分有效哦,请慎重评分</p>
                        </form>
                    </div>
				</div>
			</div>
		</div>
        <%@include file="../right.jsp" %>
	</div>
</section> 


</div>

</body>
</html>