<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav>
		<h1>Songs and Artists Database</h1>
		<ul>
			<li><a href="/artists">All artists</a></li>
			<li><a href="/songs/new">Add a song</a></li>
		</ul>
	</nav>
	
	<h3>All Songs</h3>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Artist/Group</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allSongs}" var="currentSong">
				<tr>
					<td><c:out value="${ currentSong.id }" /> </td>
					<td><c:out value="${currentSong.title}" /> </td>
					<td><c:out value="${currentSong.recordingArtist.name }"/></td>
					<td><a href="/songs/${ currentSong.id }" class="btn">View</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>