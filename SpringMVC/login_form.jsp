<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Log In</h2>
	<form action="<c:url value='/admin/loginConfirm'></c:url>"
		method="post" name="login_form">
		<input type="text" name="a_id" placeholder="Input Admin ID"/><br>
		<input type="password" name="a_pw" placeholder="Input Admin PW"/><br>
		<input type="submit" value="login"/>
		<input type="reset" value="reset"/>
	</form>
</body>
</html>







