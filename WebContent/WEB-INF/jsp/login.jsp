<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Login Page</title>
</head>
<body>
	<div align="center">
		<table>
			<tr>
				<th>Usernames</th>
			</tr>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.username}</td>
					<td>${user.password}</td>
				</tr>
			</c:forEach>
		</table>
		<form action="<c:url value="/login"/>" method="POST">
			<table>
				<tr>
					<th align="left">Username</th>
					<th align="left">Password</th>
				</tr>
				<tr>
					<td><input type="text" name="username" /></td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td align="left">Remember me <input type="checkbox"
						name="_spring_security_remember_me" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Login" /> <input type="reset" value="Reset" /></td>
				</tr>
			</table>

		</form>
	</div>
</body>
</html>