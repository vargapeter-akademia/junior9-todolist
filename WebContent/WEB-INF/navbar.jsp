<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="navbar">
	<a href="index.jsp"><i class="fas fa-home"></i> Kezdőlap</a>
	<c:choose>
		<c:when test="${sessionScope.loggedInUser == null}">
			<a href="registration.jsp"><i class="fas fa-user-plus"></i> Regisztáció</a>
			<a href="login.jsp"><i class="fas fa-sign-in-alt"></i> Bejelentkezés</a>
		</c:when>
		<c:otherwise>
			<a href="tasks"><i class="fas fa-tasks"></i> Feladatok</a>
			<a href="logout" style="float: right;"><i class="fas fa-sign-out-alt"></i> Kijeletkezés</a>
			<a href="profile" style="float: right;"><i class="far fa-user"></i> <c:out value="${sessionScope.loggedInUser.email}" /></a>
		</c:otherwise>
	</c:choose>
</div>