<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout</title>
</head>
<body>
<% 
if(session.getAttribute("is_logged_in") != null) { 
	session.invalidate();
	response.sendRedirect("index.jsp?logout=true");
} 
else {
	response.sendRedirect("login.jsp?logout=no_login");
}
%>
</body>
</html>