<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Registration Page</title>
</head>
<body>
	<div align="center">
		<h1>Registration Form</h1>
		<form:form action="registration" method="POST" >
			<table>
				<tr>
					<th colspan="2" align="center">Please fill in your details</th>
				</tr>
				<tr>
					<td><label for="email">Email:</label></td>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<td><label for="password">Password:</label></td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Register" /></td>
				</tr>
			</table>

		</form:form>
	</div>
</body>
</html>