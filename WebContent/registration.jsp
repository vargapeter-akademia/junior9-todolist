<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Regisztráció</title>
<%@ include file="WEB-INF/meta.jsp" %>
</head>
<body>
	<%@ include file="WEB-INF/navbar.jsp" %>
	<div class="container">
		<h1>Regisztráció</h1>
		<form action="registration">
			<label>Email cím</label>
			<input type="text" name="email" required>
			
			<label>Név</label>
			<input type="text" name="name">
			
			<label>Jelszó</label>
			<input type="password" name="password" required>
			
			<input type="submit" value="Regisztráció">
		</form>
	</div>
</body>
</html>