<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
	<meta charset="UTF-8">
	<meta name="apple-touch-fullscreen" content="YES" /> 
	<title>探索城市</title>
	<link rel="stylesheet" type="text/css" href="../css/POI.css">
	<script type="text/javascript" src="../resource/jquery-1.3.2.min.js"></script>
	<style type="text/css">
	header{
		background-image:url(${header});
		background-size: cover;
		height: 37%;
	}
	</style>
</head>
<body>
	<header></header>
	<div class="title">
		<div class="center">
			<div class="line"></div>
			<div class="icon"></div>
			<div class="line"></div>
			<h2>${title}<br/>${english_title}</h2>
		</div>
		<div class="score">
			<img src="../resource/img/poi/reviews.png"><!-- 判断 -->
			<div class="reviews">${reviews}分</div>
		</div>
	</div>
	<div class="tips">
		<h2>${foreword}</h2>
		<div class="special">

<c:forEach items="${tags}" var="tag">
			<div class="single first">${tag.name}</div><!-- 需要循环遍历 -->
</c:forEach>

		</div>
	</div>
	<div class="tips">
		<div class="breif">
			<img src="../resource/img/poi/tips.png">
			<h3>简介</h3>
		</div>
		<p class="margin">${breif}</p>
	</div>
	<div class="tips">
		<div class="breif">
			<img src="../resource/img/poi/tips.png">
			<h3>小贴士</h3>
		</div>
		<div class="margin">
			<p>${tips}</p>
		</div>
	</div>
	<!-- 循环遍历开始 -->
	<div class="tips">
		<div class="breif">
			<img src="../resource/img/poi/menu.png">
			<h3>菜品推荐</h3>
		</div>
<c:forEach items="${recommends}" var="recommend">
		<div class="menu first_menu" style="background-image: url($(recommend.coverImage));">
			<img class="overlay" src="../resource/img/poi/overlay.png">
			<div class="type">${recommend.tag}</div>
			<div class="menu_name">${recommend.title}</div>
		</div>
		<p>${recommend.desc}</p>
</c:forEach>
	</div>
	<div class="tips last_tip">
		<div class="breif">
			<img src="../resource/img/poi/comment.png">
			<h3>评论</h3>
		</div>
		<div class="comment">
			<div class="left">
				<img src="../resource/img/poi/google.png"><!-- tripadvisor// google -->
				<p id="comment_from">来自${commentFrom}</p> 
			</div>
			<div class="right">
				<p>${comments.rating}分</p>
				<img src="../resource/img/poi/reviews.png">
			</div>
		</div>
		<p class="main_comment">${comments.title}</p>
		<div class="good_comment"><img src="../resource/img/pgc/yin1.png"><br/>&nbsp;${comments.text}<br/><img class="float_r" src="../resource/img/pgc/yin2.png"></div>
		<div class="message">
			<div class="details" id="detail_price">
				<img src="../resource/img/poi/price.png">
				<p>价格：</p>
				<h3 id="price">${price}</h3>
			</div>
			<div class="details" id="detail_phone">
				<img src="../resource/img/poi/phone.png">
				<p>电话：</p>
				<h3 id="phone">${phone}</h3>
			</div>
			<div class="details" id="detail_web">
				<img src="../resource/img/poi/web.png">
				<p>网址：</p>
				<h3 id="web">${web}</h3>
			</div>
			<div class="details" id="detail_time">
				<img src="../resource/img/poi/time.png">
				<p>时间：</p>
	<c:forEach items="${times}" var="time">
				<h3 id="time">${time}</h3>
	</c:forEach>
			</div>
			<div class="details" id="last_tip">
				<img src="../resource/img/poi/ticket.png">
				<p>设施</p>
				<div class="all">
	<c:forEach items="${facilities}" var="facilitie">
		<c:choose>
				<c:when
					test="${facilitie.wifi =='false'}">
					<div style="display: none" class="little">
						<img class="little" src="../resource/img/poi/wifi.png">
						<div class="text" id="little">提供wifi</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="little">
						<img class="little" src="../resource/img/poi/wifi.png">
						<div class="text" id="little">提供wifi</div>
					</div>
				</c:otherwise>
		</c:choose>


					
	</c:forEach>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="../js/POI.js"></script>
<script type="text/javascript"></script>
</html>