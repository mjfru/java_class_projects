<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Song Page</title>
<link rel="stylesheet" href="/css/formStyles.css" media="all" type="text/css"/>
</head>
<body>
	<nav>
		<h1>Songs and Artists Database</h1>
		<ul>
			<li><a href="/artists">All artists</a></li>
			<li><a href="/songs">All songs</a></li>
		</ul>
	</nav>
	<h3>New song</h3>
	<form:form action="/songs/new" method="POST" modelAttribute="newSong">
		<div>
			<form:label path="title">Title:</form:label>
			<form:input type="text" path="title"/>
			<form:errors path="title"/>
		</div>
		<div>
			<form:label path="releaseDate">Release Date</form:label>
			<form:input type="date" path="releaseDate"/>
			<form:errors path="releaseDate"/>
		</div>
		<div>
			<form:label path="isExplicit">Has explicit lyrics?</form:label>
			<div>
				<form:radiobutton path="isExplicit" value="true" label="Yes"/>
				<form:radiobutton path="isExplicit" value="false" label="No"/>
			</div>
			<form:errors path="isExplicit"/>
		</div>
		<div>
			<form:label path="lyrics"></form:label>
			<form:textarea path="lyrics"></form:textarea>
		</div>
		<div>
			<form:label path="recordingArtist">Artist/Group</form:label>
			<form:errors path="recordingArtist"/>
			<form:select path="recordingArtist">
				<form:options items="${ allArtists }" itemValue="id" itemLabel="name"/> 
			</form:select>
		</div>
		<input type="submit" class="btn" value="Add song" />
	</form:form>
</body>
</html>