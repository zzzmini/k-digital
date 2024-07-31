<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Sign Up</h2>
	<form action="<c:url value='/admin/createAccountConfirm' />" method="post"><br>
		<input type="text" name="a_id" placeholder="Input Admin ID"/><br>
		<input type="text" name="a_pw" placeholder="Input Admin PW"/><br>
		<input type="text" name="a_pw_again" placeholder="Input Admin Again"/><br>
		<input type="text" name="a_name" placeholder="Input Admin Name"/><br>
		<input type="text" name="a_phone" placeholder="Input Phone"/><br>
		<input type="submit" value="create account">
		<input type="reset" value="reset">
	</form>
</body>
</body>
</html>
