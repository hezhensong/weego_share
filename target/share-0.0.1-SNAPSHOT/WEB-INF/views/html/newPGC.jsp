<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
	<meta charset="UTF-8">
	<title>PGC活动</title>
	<link rel="stylesheet" type="text/css" href="../css/PGC.css">
	<script type="text/javascript" src="../resource/jquery-1.3.2.min.js"></script>
	<style type="text/css">
	header{
		background-image: url(${header});
		background-size: cover;
		height: 41%;
		width: 100%;

	}
	.page .poi{
		height: 420px;
		background-image: url(${poi_bg});
		background-size: cover;
		margin: 30px 0;
	}
	</style>
</head>
<body>
	<header>
		<h1>${title}</h1>
	</header>

	<div class="author">
		<div class="head">
			<img id="author_pic" src="${author_pic}">
		</div>
		<h1 id="author_name">${author_name}</h1>>
		<p>${author_breif}</p>
		<div class="line"></div>
	</div>

	<div class="from">作者：<span id="author">${author}</span>,来源：<span id="from">${from}</span>
	</div>

	<div class="drb"><img class="float-l" src="../resource/img/pgc/yin1.png"><br/>
	<span style="font-size:20px;">&nbsp;&nbsp;&nbsp;</span>${breif}</br><img class="float-r" src="../resource/img/pgc/yin2.png"></div>
<c:forEach items="${poilist}" var="PgcPoi">
	<div class="page">

			<c:choose>
				<c:when>
					test="${PgcPoi.imageTitle =='' || ActivityParagraphs.imageTitle == 'null'}">
					<div style="display: none" id="text_title">${ActivityParagraphs.imageTitle}</div>
				</c:when>
				<c:otherwise>
					<div id="text_title">${ActivityParagraphs.imageTitle}</div>
				</c:otherwise>
			</c:choose>


		<div class="page_title">
			<div class="small">
			</div>
			<h2 id="text_title">${PgcPoi.text_title}</h2>
		</div>

		<div id="text" class="drb">${PgcPoi.paragraphDesc}</div>
		<div class="poi" id="poi">
			<img class="overlay" id="poi_pic" src="../resource/img/pgc/overlay.png">
			<div class="type" id="poi_tag">${PgcPoi.poi_tag}</div>
			<div class="center">
				<div class="line"></div>
				<img class="icon" alt="${type}" src="">
				<div class="line"></div>
				<h2 id="poi_title">${PgcPoi.paragraphTitle}</h2>
			</div>
		</div>
		<div class="page_pic">
			<img id="pic" src="${page_pic}">
			<h3 class="resource">(图片来源：<span id="pic_resource">${PgcPoi.pic_resource}</span>)</h3>
		</div>
	</div>
</c:forEach>

	<footer>
		<h5>由weego重新排版&nbsp;<a href="${read_all}">阅读原文</a></h5>
		<div class="logo"><img src="${public_logo}"></div>
		<p class="accounts">${accounts}</p>
		<div class="accounts_breif">${accounts_breif}</div>
	</footer>
</body>
<script type="text/javascript" src="../js/PGC.js"></script>
</html>