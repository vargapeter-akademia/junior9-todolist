<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Feladatok</title>
<%@ include file="WEB-INF/meta.jsp" %>
</head>
<body>
	<%@ include file="WEB-INF/navbar.jsp" %>
	
	<div class="container">
		<form action="task/create">
			<label>Feladat leírása</label><br>
			<input type="text" name="summary" required><br>
			<label>Feladat határideje</label><br>
			<input type="datetime-local" name="dueDate"><br>
			<input type="submit" value="Todo létrehozása">
		</form>
	</div>
	
	<div class="container">
		<table>
			<tr>
				<th>Azonosító</th>
				<th>Feladat leírása</th>
				<th>Határidő</th>
				<th>Állapot</th>
			</tr>
			<c:forEach var="task" items="${tasks}">
			<tr>
				<td><c:out value="${task.id}"/></td>
				<td><c:out value="${task.summary}"/></td>
				<td><c:out value="${task.dueDate}"/></td>
				<td><c:out value="${task.state.name}"/></td>
			</tr>
			</c:forEach>
		</table>
	</div>
	
</body>
</html>