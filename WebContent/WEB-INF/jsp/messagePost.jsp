<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Message Post</title>
</head>
<body>
	<form:form method="POST" modelAttribute="message">
		<table>
			<tr>
				<td>Title</td>
				<td><form:input path="title"/></td>
			</tr>
			<tr>
				<td>Body</td>
				<td><form:textarea path="body"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Post"/></td>
			</tr>
		</table>
		<hr/>
	</form:form>
	<a href="<c:url value="/bookCreation" />">Add new book</a>
</body>

</html>