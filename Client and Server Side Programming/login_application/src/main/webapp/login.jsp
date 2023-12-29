<%@page import="org.apache.coyote.RequestGroupInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>

    <style>
        .container {
            padding-top: 50px;
            padding-bottom: 100px;
            width: 50%;
        }
    </style>

</head>
<body>

<% try { if(request.getParameter("record").equals("false")) { %>

	<div class="alert alert-warning alert-dismissible fade show" role="alert">
	  Incorrect Credentials!
	  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
	</div>

<% } } catch(NullPointerException e) {} %>

<% try { if(request.getParameter("logout").equals("no_login")) { %>

	<div class="alert alert-warning alert-dismissible fade show" role="alert">
	  Login before logging out!
	  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
	</div>

<% } } catch(NullPointerException e) {} %>


<% 
if(session.getAttribute("is_loggedin") != null) {
	session.setAttribute("visit_count", (Integer) session.getAttribute("visit_count") + 1);
}
%>

<% 
if(session.getAttribute("is_loggedin") != null) {
	session.setAttribute("visit_count", (Integer) session.getAttribute("visit_count") + 1);
	response.sendRedirect("index.jsp");
}
%>

<% if(Boolean.valueOf(request.getParameter("register"))) { %>

<div class="alert alert-primary" role="alert">
  Register Successful! Please Login.
</div>
	
<% } %>


    <div class="container">

        <div class="d-flex mb-3">
            <div class="p-0"><h1>Enter Login Details</h1></div>
            <div class="ms-auto p-2">
                <a href="index.jsp">
                    <button type="button" class="btn btn-primary">
                    Back
                    </button> 
                </a>
            </div>
          </div>

        <form action="login" method="post">

            <div class="mb-3">
                <h3>User Name: </h3>
                <input type="text" class="form-control" id="username" name="username" placeholder="Username" required>
            </div> <br/>

            <div class="mb-3">
                <h3>Password: </h3>
                <input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
            </div> <br/>

            <h3>Ratings</h3>
            <input type="range" class="form-range" min="1" max="5" step="1" id="ratings" name="ratings"> <br/> <br/>

            <button type="submit" class="btn btn-primary">Submit</button>

        </form>
    </div>
</body>
</html>