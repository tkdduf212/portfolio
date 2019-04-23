<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트</title>
<link rel="stylesheet" href="resources/css/index.css">
<link rel="stylesheet" href="resources/css/sns.css">
<link rel="stylesheet" href="resources/css/LoginOK.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script type="text/javascript" src="resources/js/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<script type="text/javascript" src="resources/js/go.js"></script>
<script type="text/javascript" src="resources/js/validCheck.js"></script>
<script type="text/javascript" src="resources/js/check.js"></script>
<script type="text/javascript" src="resources/js/summonInput.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
	function bodyOnload(r) {
		if (r != "") {
			alert(r);
		}
	}
	$(function() {
		$("#doJoin").click(function() {
			location.href = "go.join";
		});
		$("#findPage").click(function() {
			location.href = "findPage";//페이지 구현 미정
		});
		connectIdCheckEvent()
		connectSummonEventLogin()
		connectSummonEvent()
		connectSummonAddrInputEvent()
		mainImgSlide()
	});
</script>
</head>
<body onload="bodyOnload('${r}');">
	<div id="mainMenu">
		<a href="/pf"><img width="30px" height="30px" src="resources/img/home_img.png"></a>
		<a href="bbs"><img width="70px" height="30px" src="resources/img/community_img.png"></a>
	</div>
	<div id="mainHead">게시판</div>
	<span id="loginSummon">
		<img id="loginImg" src="resources/img/loginIcon.png">
		<div id="loginArea">
			<jsp:include page="${login }"></jsp:include>
		</div>
	</span>
	<div id="contentArea">
		<jsp:include page="${contentPage }"></jsp:include>
	</div>
</body>
</html>