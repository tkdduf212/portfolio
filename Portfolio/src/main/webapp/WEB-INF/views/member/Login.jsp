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
		<form action="do.login" method="POST" name="loginForm" onsubmit="return loginCheck();">
			<tr>
				<td><input class="loginInput" placeholder="아이디" name="p_id"></td>
				<td rowspan="3">
					<button id="doLogin">로그인</button>
				</td>
			</tr>
			<tr>
				<td><input class="loginInput" placeholder="비번" name="p_pw" type="password"></td>
			</tr>
		</form>
			<tr>
				<td colspan="2">
					<button id="doJoin">회원가입</button>
					<button id="findPage">아이디/비번찾기</button>
				</td>
			</tr>
		</table>
</body>
</html>