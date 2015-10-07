<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Book Creator</title>
</head>
<body>
	<div align="center">
		<h1>Add New Book</h1>
		<form:form action="bookCreation" method="POST" modelAttribute="book">
			<table>
				<tr>
					<th colspan="3" align="center">Please fill book's details</th>
				</tr>
				<tr>
					<td><label for="title">Title:</label></td>
					<td><form:input type="text" path="title" /></td>
				</tr>
				<tr>
					<td><label for="authors">Authors:</label></td>
					<td><form:input type="text" path="authors" /></td>
				</tr>
				<tr>
					<td><label for="price">Price ($):</label></td>
					<td><form:input type="number" min="0" step="any" path="price" /></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><input type="submit"
						value="Add Book" /></td>
				</tr>
			</table>

		</form:form>
	</div>
</body>
</html>