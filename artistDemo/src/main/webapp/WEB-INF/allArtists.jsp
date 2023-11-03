<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Artists and Groups</title>
</head>
<body>
	<nav>
		<h1>Songs and Artists Database</h1>
		<ul>
			<li><a href="/artists/new">Add artist</a></li>
			<li><a href="/songs">All songs</a></li>
		</ul>
	</nav>
	<h3>All Artists and Groups</h3>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Genre</th>
				<th>Solo / Group</th>
				<th>User Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="thisArtist" items="${allArtists}">
				<tr>
					<td><c:out value="${thisArtist.id}" /></td>
					<td><c:out value="${thisArtist.name}" /></td>
					<td><c:out value="${thisArtist.genre}" /></td>
					<td>
						<c:choose>
							<c:when test="${thisArtist.isGroup == true}">
								Group
							</c:when>
							<c:otherwise>
								Solo
							</c:otherwise>
						</c:choose>
					</td>
					<td><a href="/artists/${ thisArtist.id }">View</a> <a href="/artists/${ thisArtist.id }/edit">Edit</a>
						<form action="/artists/${thisArtist.id}/delete" method="post">
							<input type="hidden" name="_method" value="delete" />
							<input type="submit" value="Delete" />
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>