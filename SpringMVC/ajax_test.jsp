<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" 
	value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>아이디</th>
		</tr>
		<tr>
			<td>
				<!-- 어드민검색 영역-->
				<table>
					<tr>
						<td><input type="text" name="keyword" id="keyword"></td>
					</tr>
					<tr>
						<td><input type="button" name="AjaxTest" id="AjaxTest"
							value="AjaxTest"></td>
					</tr>
					<tr>
						<td><input type="button" name="search" id="search"
							value="조건검색"></td>
					</tr>
					<tr>
						<td>
							<!-- 검색 결과 보이는곳 -->
							<div id="result"></div> <!-- 검색 결과 보이는곳 여기까지-->
						</td>
					</tr>

				</table> <!-- 어드민검색 영역 여기까지-->
			</td>
		</tr>
	</table>
	<!-- 조회정보표시영역 -->
	<table border="1">
		<tr>
			<th>닉네임</th>
			<th>전화번호</th>
		</tr>
		<!-- 검색 결과 보이는곳 -->
		<tr id="content"></tr>
		<!-- 검색 결과 보이는곳 여기까지-->

	</table>
	<!-- 조회정보표시영역 여기까지-->
</body>
</html>
