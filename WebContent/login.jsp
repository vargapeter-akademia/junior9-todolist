<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bejelentkezés</title>
<%@ include file="WEB-INF/meta.jsp" %>
</head>
<body>
	<%@ include file="WEB-INF/navbar.jsp" %>
	
	<div class="container">
		<h1>Bejelentkezés</h1>
		<form action="login">
			<label>Email cím</label><br>
			<input type="text" name="email" required><br>
			
			<label>Jelszó</label><br>
			<input type="password" name="password" required><br>
			
			<input type="submit" value="Bejelentkezés">
		</form>
	</div>
	
</body>
</html>