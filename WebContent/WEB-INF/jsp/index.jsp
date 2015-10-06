<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tag" uri="http://www.springframework.org/tags"%>
<%@page import="java.util.*"%>

<html>
<head>
<title>Welcome to Black Books!</title>
</head>
<body>
	<h2>
		<font size="24">Black Books</font>
	</h2>
	<form:form method="GET" action="/HelloWeb/staticPage">
		<table>
			<c:forEach items="${titles }" var="title">
				<tr>
					<td>${title}</td>
					<td><input type="submit" value="Add to cart" /></td>
				</tr>
			</c:forEach>

		</table>
	</form:form>
</body>
</html>