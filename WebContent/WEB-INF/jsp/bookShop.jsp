<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Black Books</title>
</head>
<body>
	<div align="center">
		<h1>Welcome to Black Books</h1>
		<h3>${newUser.username}</h3>
		<c:forEach items="${newUser.getAuthorities()}" var="authority">
			<h4>${authority}</h4>
		</c:forEach>
		<table>
			<tr>
				<th>Book Title</th>
				<th>Author(s)</th>
				<th>Price, $</th>
				<th></th>
			</tr>
			<c:forEach items="${books}" var="book">
				<tr>
					<td>${book.title}</td>
					<td>${book.authors}</td>
					<td>${book.price}</td>
					<td><a href="#">Add to Cart</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="bookCreation">Add New Book</a> <a
			href="<c:url value="/logout"/>">Logout</a> <a
			href="<c:url value="/register"/>">Register</a>
	</div>

</body>

</html>