<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
    <title>Document</title>
    <style>
        #outer {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            height: 100%;
        }
        body, html {
            height: 100%;
        }
    </style>
</head>
<body>

<% 
System.out.println(session.getAttribute("username") + " accessed the website");
session = request.getSession(false);
try { if(request.getParameter("logout").equals("true")) { %>

<div class="alert alert-warning alert-dismissible fade show" role="alert">
  Logout Successful!  
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>

<% } } catch(NullPointerException e) {} try { if(request.getParameter("login").equals("true")) {  %>

<div class="alert alert-warning alert-dismissible fade show" role="alert">
  Login Successful!  
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>

<% } } catch(NullPointerException e) {}
%>

    <div id="outer">
        <a href="register.jsp" style="font-style: none;">
            <button type="button" class="btn btn-primary">
                Register
            </button>
        </a> <br/> <br/>
        
        <% if(session.getAttribute("is_loggedin") == null) { %>
        <a href="login.jsp" style="font-style: none;">
            <button type="button" class="btn btn-primary">
                Login
            </button>
        </a> <br/> <br/>
        <% } else { %>
        <a href="logout.jsp" style="font-style: none;">
            <button type="button" class="btn btn-primary">
                Logout
            </button>
        </a> <br/> <br/>
    	<% } %>
    
    </div>

</body>
</html>