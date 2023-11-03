<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Viewing <c:out value="${thisArtist.name}"/></title>
</head>
<body>
	<a href="/artists">All Artists</a>
	<h1>About <c:out value="${ thisArtist.name }"/></h1>
	<p>Genre: <c:out value="${ thisArtist.genre }" /></p>
	<p>Description: <c:out value="${ thisArtist.description }" /></p>
	<p>
		<c:choose>
			<c:when test="${ thisArtist.isGroup }">
				<c:out value="${thisArtist.name}" /> is a band with <c:out value="${thisArtist.memberCount }" />
			</c:when>
			<c:otherwise>
				<c:out value="${thisArtist.name}" /> is a solo artist.
			</c:otherwise>
		</c:choose>
	</p>
	<p>
		<c:choose>
			<c:when test="${thisArtist.isActive}">
				<c:out value="${thisArtist.name}" /> is active.
			</c:when>
			<c:otherwise>
				<c:out value="${thisArtist.name}" /> is no longer active.
			</c:otherwise>
		</c:choose>
	</p>
</body>
</html>