<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Login Page</title>
</head>
<body>

<form action="<c:url value="/login"/>" method="POST">
	<table>
		<tr>
		<td align="right">Username</td>
		<td><input type="text" name="username"/></td>
		</tr>
		<tr>
		<td align="right">Password</td>
		<td><input type="password" name="password"/></td>
		</tr>
		<tr>
		<td align="right">Remember me</td>
		<td><input type="checkbox" name="_spring_security_remember_me"/></td>
		</tr>
		<tr>
		<td colspan="2" align="right"><input type="submit" value="Login"/><input type="reset" value="Reset"/>
		</td>
		</tr>
	</table>

</form>
</body>
</html>