<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix =
"form" uri = "http://www.springframework.org/tags/form"
%>

<html>
	<head>
	    <!-- Must be included before style sheets -->
		<%@ include file = "parts/navbar.jsp" %>
		
		<style><%@include file="/css/localStyles/defaultStyle.css"%></style>
		
		<meta charset="ISO-8859-1">
		
	</head>
	<h1>Welcome to the Website</h1>
	<body>
	
	Welcome ${back} ${user}, you are now logged in!
	
	
		
		<c:if test="${adminStatus == true}">
         
    		<form method="POST" action="GridUsers">
				<input type="submit" value="Go to Users Grid">
			</form>
         
 		</c:if>
	
	
	</body>
</html>