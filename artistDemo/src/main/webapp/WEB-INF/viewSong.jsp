<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/mainStyles.css" media="all" type="text/css"/>
    <title>About this song</title>
</head>
<body>
	<nav>
		<h1>Songs and Artists Database</h1>
		<ul>
			<li><a href="/artists">All artists</a></li>
			<li><a href="/songs">All songs</a></li>
		</ul>
	</nav>
	<h3><c:out value="${ thisSong.title }"/> by <c:out value="${ thisSong.recordingArtist.name }"/></h3>
	<!-- Challenge: Try to display the date as, for example, "January 30, 2000"  -->
	<p>Release date: <c:out value="${ thisSong.releaseDate }"/></p>
	<p>Has explicit lyrics:
		<c:choose> 
			<c:when test="${ thisSong.isExplicit }">Yes</c:when>
			<c:otherwise>No</c:otherwise>
		</c:choose>
	</p>
	<p>Some sample lyrics: <c:out value="${ thisSong.lyrics }"/></p>
</body>
</html>