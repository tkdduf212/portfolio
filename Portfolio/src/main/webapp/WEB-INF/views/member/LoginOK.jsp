<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td rowspan="2"><img id = loginOKImg src="resources/img/${sessionScope.loginMember.p_img }"></td>
			<td id="loginOKInfo">${sessionScope.loginMember.p_id}(<span>${sessionScope.loginMember.p_name }</span>)</td>
		</tr>
		<tr>
			<td>
				<button class="loginOKBtn" onclick="memberUpdate();">정보수정</button>
				<button class="loginOKBtn" onclick="logout();">로그아웃</button>
			</td>
		</tr>
	</table>
</body>
</html>