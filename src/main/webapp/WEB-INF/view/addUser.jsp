<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add User</title>
</head>
<body>
<%@ page import="com.crud.conn.UserDao" %>
<jsp:useBean id="u" class="com.crud.beans.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
	int i = UserDao.save(u);
	if(i > 0)
		response.sendRedirect("adduser-success.jsp");
	else
		response.sendRedirect("adduser-error.jsp");
%>
</body>
</html>