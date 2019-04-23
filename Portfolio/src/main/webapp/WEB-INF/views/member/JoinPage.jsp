<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body onload="bodyOnload('${r}');">
	<form action="do.join" method="post" name="joinForm" enctype="multipart/form-data" onsubmit="return joinCheck();">
		<table id="joinTable">
			<tr>
				<td align="center" class="joinTableTd"><input class="joinInput" name="p_id" id="p_id"
					placeholder="ID" maxlength="10" autocomplete="off"><span class="sub" style="cursor: Default" id="joinIdOk">ID확인</span></td>
			</tr>
			<tr>
				<td align="center"><input class="joinInput" name="p_pw"
					type="password" placeholder="PW, 숫자 하나 반드시" maxlength="10"
					autocomplete="off"></td>
			</tr>
			<tr>
				<td align="center"><input class="joinInput" name="p_pwChk"
					type="password" placeholder="PW확인" maxlength="10"
					autocomplete="off"></td>
			</tr>
			<tr>
				<td align="center"><input class="joinInput" name="p_name"
					placeholder="이름" maxlength="10" autocomplete="off"></td>
			</tr>
			<tr>
				<td align="center">
					<div>
						<select name="year" class="birthSelect">
							<c:forEach var="y" items="${year }">
								<option value="${y }">${y }</option>
							</c:forEach>
						</select>
						<select name="month" class="birthSelect">
							<c:forEach var="m" begin="1" end="12" step="1">
								<option value="${m }">${m }</option>
							</c:forEach>
						</select>
						<select name="day" class="birthSelect">
							<c:forEach var="d" begin="1" end="31">
								<option value="${d }">${d }</option>
							</c:forEach>
						</select>
					<span>성별</span>
					<select	name="p_gender" class="birthSelect">
						<option value="0">선택</option>
						<option value="1">남</option>
						<option value="2">여</option>
					</select>
					</div>
				</td>
			</tr>
			<tr>
				<td align="center" class="joinTableTd"><input class="joinInput" name="p_adds1" id="p_adds1" readonly="readonly"
					placeholder="우편번호" maxlength="10" autocomplete="off"><span class="sub" style="cursor: pointer;" id="joinAddrSearchBtn">검색<span></td>
			</tr>
			<tr>
				<td align="center"><input class="joinInput" name="p_adds2" id="p_adds2" readonly="readonly"
					placeholder="주소" maxlength="10" autocomplete="off"></td>
			</tr>
			<tr>
				<td align="center"><input class="joinInput" name="p_adds3" id="p_adds3"
					placeholder="상세주소" maxlength="10" autocomplete="off"></td>
			</tr>
			<tr>
				<td align="center">아이디/비밀번호 힌트</td>
			</tr>
			<tr>
				<td align="center"><input class="joinInput" placeholder="아이디 힌트" maxlength="10"
					name="p_id_hint"></td>
			</tr>
			<tr>
				<td align="center"><input class="joinInput" placeholder="비밀번호 힌트" maxlength="10"
					name="p_pw_hint"></td>
			</tr>
			<tr>
				<td align="center"><input class="joinInput" name="p_img"
					type="file"></td>
			</tr>
			<tr>
				<td align="center"><button class="joinBtn">가입</button></td>
			</tr>
		</table>
	</form>
</body>
</html>