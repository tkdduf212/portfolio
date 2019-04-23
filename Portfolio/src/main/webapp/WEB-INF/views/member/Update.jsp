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
		<table id="joinTable">
	<form action="member.update" method="post" name="updateForm" enctype="multipart/form-data" onsubmit="return updateMemberCheck();">
			<tr>
				<td align="center"><input class="joinInput" name="p_id" id="p_id" value="${sessionScope.loginMember.p_id }" readonly="readonly"
					placeholder="ID" maxlength="10" autocomplete="off"></td>
			</tr>
			<tr>
				<td align="center"><input class="joinInput" name="p_pw" value="${sessionScope.loginMember.p_pw }"
					type="password" placeholder="PW, 숫자 하나 반드시" maxlength="10"
					autocomplete="off"></td>
			</tr>
			<tr>
				<td align="center"><input class="joinInput" name="p_pwChk" value="${sessionScope.loginMember.p_pw }"
					type="password" placeholder="PW확인" maxlength="10"
					autocomplete="off"></td>
			</tr>
			<tr>
				<td align="center"><input class="joinInput" name="p_name" value="${sessionScope.loginMember.p_name }"
					placeholder="이름" maxlength="10" autocomplete="off"></td>
			</tr>
			<tr>
				<td align="center"><div>
					<span name="p_birth" readonly="readonly">생년월일 : ${sessionScope.loginMember.p_birth }</span>
					<span name="p_gender" readonly="readonly">성별 : ${gender }</span>
				</div></td>
			</tr>
			<tr>
				<td align="center"  class="joinTableTd"><input class="joinInput" name="p_adds1" id="p_adds1" readonly="readonly" value="${adds1 }"
					placeholder="우편번호" maxlength="10" autocomplete="off"><span class="sub" style="cursor: pointer;" id="joinAddrSearchBtn">검색<span></td>
			</tr>
			<tr>
				<td align="center"><input class="joinInput" name="p_adds2" id="p_adds2" readonly="readonly" value="${adds2 }"
					placeholder="주소" maxlength="10" autocomplete="off"></td>
			</tr>
			<tr>
				<td align="center"><input class="joinInput" name="p_adds3" id="p_adds3" value="${adds3 }"
					placeholder="상세주소" maxlength="10" autocomplete="off"></td>
			</tr>
			<tr>
				<td align="center">아이디/비밀번호 힌트</td>
			</tr>
			<tr>
				<td align="center"><input class="joinInput" placeholder="아이디 힌트" maxlength="10" value="${sessionScope.loginMember.p_id_hint }"
					name="p_id_hint"></td>
			</tr>
			<tr>
				<td align="center"><input class="joinInput" placeholder="비밀번호 힌트" maxlength="10" value="${sessionScope.loginMember.p_pw_hint }"
					name="p_pw_hint"></td>
			</tr>
			<tr>
				<td id="joinFileTd">
					<table>
						<tr>
							<td style="width: 55px;"><img
								src="resources/img/${sessionScope.loginMember.p_img }"
								style="max-width: 50px; border-radius: 10px;"></td>
							<td><input type="file" class="joinFileInput" name="p_img"
								autocomplete="off"></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td align="center"><button class="joinBtn" >수정</button></td>
	</form>
				<td align="center"><button class="joinBtn" onclick="memberBye();">탈퇴</button></td>
			</tr>
		</table>
</body>
</html>