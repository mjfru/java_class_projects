<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editing <c:out value="${artistToEdit.name}" /></title>
</head>
<body>
	<a href="/artists">All Artists</a>
	<h1>Edit Artist</h1>
	<form:form action="/artists/${ artistToEdit.id }/edit" modelAttribute="artistToEdit" method="POST">
		<input type="hidden" name="_method" value="put"/>
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
			<form:label path="genre">Genre:</form:label>
			<form:errors path="genre" />
			<form:select path="genre" items="${allGenres}" />
		</p>
		<p>
			<form:label path="description">Artist Description:</form:label>
			<form:errors path="description"/>
			<form:textarea path="description"/>
		</p>
		<p>
			<form:label path="isGroup">Is this a group?</form:label>
			<form:errors path="isGroup"/>
			<form:radiobutton path="isGroup" value="true" label="Yes"/>
			<form:radiobutton path="isGroup" value="false" label="No"/>
		</p>

		<p>
			<form:label path="memberCount">Number of Members:</form:label>
			<form:errors path="memberCount"/>
			<form:input path="memberCount" type="number"/>
		</p>
		<input type="submit" value="Edit Artist"/>
	</form:form>
</body>
</html>