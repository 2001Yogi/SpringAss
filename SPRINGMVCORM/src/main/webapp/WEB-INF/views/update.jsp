<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
        <h2 class="text-center">User Edit Form</h2>
        <form action="${pageContext.request.contextPath}/insert" method="post">
       
        <div class="mb-3">
                <input type="hidden" class="form-control" id="id" name="id"  value="${u.id }">
            </div>
            <div class="mb-3">
                <label for="name" class="form-label">First Name:</label>
                <input type="text" class="form-control" id="name" name="name"  value="${u.name }" >
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email:</label>
                <input type="email" class="form-control" id="email" name="email"  value="${u.email }" >
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password:</label>
                <input type="password" class="form-control" id="password" name="password"  value="${u.password }">
            </div> 
            <input type = "Submit" name ="action" value ="update" class="btn btn-primary text-center">
        </form>
    </div>
</body>
</html>