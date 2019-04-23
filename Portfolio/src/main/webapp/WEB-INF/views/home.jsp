<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="snsPagingTable">
		<tr>
			<td align="center" class="snsLR">
				<c:if test="${curPage != 1 && curPage != null}">
					<a class="paging" href="sns.page.change?p=${curPage-1 }">&lt;</a>
				</c:if></td>
			<td align="center">
			<c:choose>
					<c:when test="${curPage < 3}">
						<c:forEach var="i" begin="1" end="${pageCount<5 ? pageCount : 5 }">
							<c:choose>
								<c:when test="${curPage == i}">
									<a class="paging" href="sns.page.change?p=${i }" style="font-weight: bold;">${i }</a>
								</c:when>
								<c:otherwise>
									<a class="paging" href="sns.page.change?p=${i }">${i }</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:when>
					
					<c:when test="${curPage+2 >= pageCount}">
						<c:forEach var="i" begin="${pageCount-4<1 ? 1 : pageCount-4 }" end="${pageCount }">
							<c:choose>
								<c:when test="${curPage == i}">
									<a class="paging" href="sns.page.change?p=${i }" style="font-weight: bold;">${i }</a>
								</c:when>
								<c:otherwise>
									<a class="paging" href="sns.page.change?p=${i }">${i }</a>
								</c:otherwise>
							</c:choose>

						</c:forEach>
					</c:when>
					
					<c:when test="${curPage >= 3}">
						<c:forEach var="i" begin="${curPage-2 }" end="${curPage+2 }">
							<c:choose>
								<c:when test="${curPage == i}">
									<a class="paging" href="sns.page.change?p=${i }" style="font-weight: bold;">${i }</a>
								</c:when>
								<c:otherwise>
									<a class="paging" href="sns.page.change?p=${i }">${i }</a>
								</c:otherwise>
							</c:choose>

						</c:forEach>
					</c:when>
				</c:choose> 
			</td>
			<td align="center" class="snsLR">
				<c:if test="${curPage != pageCount }">
					<a class="paging" href="sns.page.change?p=${curPage+1 }">&gt;</a>
				</c:if></td>
		</tr>
	</table>
	

	<c:forEach var="sm" items="${msgs }">
		<table class="sm" style="border:${sm.ps_color} solid 3px;">
			<tr>
				<td class="smTitle" style="color:${sm.ps_color};">
					<table>
						<tr>
							<td style="width: 15%;"><img src="resources/img/${sm.p_img }"
								style="max-width:95%; box-shadow: 1.5px 1.5px 1.5px ${sm.ps_color}; border-radius:10px;"></td>
							<td>${sm.ps_owner }(<span style="color: black;">${sm.p_name }</span>)
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td align="right" class="smDate"><fmt:formatDate value="${sm.ps_date }" pattern="yyyy/MM/dd(E) a hh:mm" /></td>
			</tr>
			<tr>
				<td class="smTxt">
					<div
						style="box-shadow:0px 0px 10px ${sm.ps_color}; margin:3px; padding:7px; border-radius:5px; word-break:break-all;">
						<c:if test="${sm.ps_img != 'x' }">
							<img src="resources/img/${sm.ps_img }" style="max-width: 95%;">
							<br>
							<br>
						</c:if>
						<c:if test="${sm.ps_txt != 'x'}">${sm.ps_txt }</c:if>
					</div>
				</td>
			</tr>
			
			<tr>
				<td style="padding-left: 15px; padding-bottom: 7px;">
					<c:forEach	var="sr" items="${sm.ps_repls }">
						<span class="rOwner" style="color:${sm.ps_color};">${sr.psr_owner }</span>
						<span class="rTxt">${sr.psr_txt }</span>
						<span class="rDate">
							- <fmt:formatDate	value="${sr.psr_date }" type="both" dateStyle="short" timeStyle="short" />
						</span>
						<c:if test="${sr.psr_owner == sessionScope.loginMember.p_id }">
							<button onclick="snsReplDelete(${sr.psr_no});" class="rDelBtn"	style="color:${sm.ps_color};">삭제</button>
						</c:if>
						<br>
					</c:forEach>
					<c:if test="${sessionScope.loginMember != null }">
						<form action="sns.reply.write"	onsubmit="return snsReplWriteCheck(this);">
							<input value="${sm.ps_no }" name="psr_ps_no" type="hidden">
							<span style="color:${sm.ps_color};" class="psr_owner">${sessionScope.loginMember.p_id }</span>
							<input name="psr_txt" class="psr_txt" style="border:none; border-bottom:${sm.ps_color} solid 2px;"	autocomplete="off" maxlength="100">
							<button class="psr_btn" style="color:${sm.ps_color};">쓰기</button>
						</form>
					</c:if>
				</td>
			</tr>
			
			
			<c:if test="${sm.ps_owner == sessionScope.loginMember.p_id }">
				<tr>
					<td colspan="2" align="right"
						style="padding-right: 5px; padding-bottom: 5px;">
						<button onclick="snsMsgUpdate(${sm.ps_no}, '${sm.ps_txt }');"
							style="border:none; color:${sm.ps_color}; font-weight:800; background-color:transparent">수정</button>
						<button onclick="snsMsgDelete(${sm.ps_no});"
							style="border:none; color:${sm.ps_color}; font-weight:800; background-color:transparent">삭제</button>
					</td>
				</tr>
			</c:if>
		</table>
	</c:forEach>
	
	
	<c:if test="${sessionScope.loginMember != null }">
		<form action="sns.write" name="snsWriteForm"
			onsubmit="return snsWriteCheck();" method="post"
			enctype="multipart/form-data">
			<table id="snsWriteTable">
				<tr>
					<td colspan="2" id="snsWriteSummonImgTd" align="center"
						valign="bottom"><img src="resources/img/talk_summon.png"
						id="snsWriteSummonImg"></td>
				</tr>
				<tr>
					<td style="width: 85%;" valign="top"><textarea style="resize: none;" placeholder="뭐"
							id="snsTxtArea" name="ps_txt" maxlength="300"></textarea></td>
					<td rowspan="2">
						<button id="snsBtn">쓰기</button>
					</td>
				</tr>
				<tr>
					<td><input type="file" name="ps_img" id="snsImg"></td>
				</tr>
			</table>
		</form>
	</c:if>
</body>
</html>