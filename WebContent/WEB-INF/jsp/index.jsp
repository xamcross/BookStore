<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*"  %>

<html>
<head>
    <title>Welcome to Black Books!</title>
</head>
<body>
<h2><font size="24">Black Books</font></h2>
<form:form method="GET" action="/HelloWeb/staticPage">
<table>
	<%
		HashMap<String, String> bookTitles = (HashMap<String, String>) request.getAttribute("bookTitles");
		for (int i=0; i<bookTitles.size(); i++){
	%>
	<tr>
	   <td>
	   <%= bookTitles.get(i+"") %>
	   </td>
    	<td>
	    	<input type="submit" value="Add to cart"/>
	    </td>
    </tr>
	<% 	
		}
	%>
</table>  
</form:form>
</body>
</html>