<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Artist Page</title>
</head>
<body>
	<h1>New Artist</h1>
	<!-- Model Attribute must match controller -->
	<form:form action="/artists/new" method="POST" modelAttribute="newArtist">
		<!-- Paths must match Model naming conventions -->
		<p>
			<form:label path="name">Artist Name:</form:label>
			<form:errors path="name"/>
			<form:input path="name" type="text"/>
		</p>
		<p>
			<form:label path="isActive">Still active?</form:label>
			<form:errors path="isActive"/>
			<form:radiobutton path="isActive" value="true" label="Yes"/>
			<form:radiobutton path="isActive" value="false" label="No"/>
		</p>
		<p>
			<form:label path="isGroup">Is this a group?</form:label>
			<form:errors path="isGroup"/>
			<form:radiobutton path="isGroup" value="true" label="Yes"/>
			<form:radiobutton path="isGroup" value="false" label="No"/>
		</p>
		<p>
			<form:label path="description">Artist Description:</form:label>
			<form:errors path="description"/>
			<form:textarea path="description"/>
		</p>
		<p>
			<form:label path="memberCount">Number of Members:</form:label>
			<form:errors path="memberCount"/>
			<form:input path="memberCount" type="text"/>
		</p>
		<p>
			<form:label path="genre">Genre:</form:label>
			<form:errors path="genre"/>
			<form:select path="genre" items="${allGenres}">
			</form:select>
		</p>
		<input type="submit" value="Add Artist"/>
	</form:form>
</body>
</html>