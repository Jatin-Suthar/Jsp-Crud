<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@page import="com.crud.conn.UserDao"%>  
	<jsp:useBean id="u" class="com.crud.beans.User"></jsp:useBean>  
	<jsp:setProperty property="*" name="u"/>  
	<%  
		UserDao.deleteUser(u);  
		response.sendRedirect("viewUsers.jsp");  
	%>  
</body>
</html>