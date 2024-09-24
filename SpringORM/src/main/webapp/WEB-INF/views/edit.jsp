<%@page import="com.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User Profile</title>
<title>Home Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
	integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
	integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
	crossorigin="anonymous"></script>
</head>
<body>
<%
    User user = (User) session.getAttribute("loggedInUser");
%>
<%-- <%String firstname = (String)request.getAttribute("firstname"); %>
<%String lastname = (String)request.getAttribute("lastname"); %>
<%String email = (String)request.getAttribute("email"); %>
<%String mobile = (String)request.getAttribute("mobile"); %>
<%String password = (String)request.getAttribute("password"); %>
<%String gender = (String)request.getAttribute("gender"); %> --%>
	<div class="container">
        <h2 class="text-center">User Registration</h2>
        <form action="editprofile" method="post">
            <div class="mb-3">
                <label for="fname" class="form-label">First Name:</label>
                <input type="text" class="form-control" id="fname" name="firstname" value="<%=user.getFirstname() %>" required>
            </div>
            <div class="mb-3">
                <label for="lname" class="form-label">Last Name:</label>
                <input type="text" class="form-control" id="lname" name="lastname" value="<%=user.getLastname() %>" required>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email:</label>
                <input type="email" class="form-control" id="email" name="email" value="<%=user.getEmail()%>" required>
            </div>
            <div class="mb-3">
                <label for="mobile" class="form-label">Mobile:</label>
                <input type="text" class="form-control" id="mobile" name="mobile" value="<%=user.getMobile()%>" required>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password:</label>
                <input type="password" class="form-control" id="password" name="password" value="<%=user.getPassword()%>" required>
            </div>
            <div class="mb-3">
                <label for="gender" class="form-label">Gender:</label>
                <select class="form-control" id="gender" name="gender"  required>
                    <option value="">Select</option>
                    <option value="Male"<%= "Male".equals(user.getGender()) ? "selected" : "" %>>Male</option>
                    <option value="Female"<%= "Female".equals(user.getGender()) ? "selected" : "" %>>Female</option>
                </select>
            </div>
            
            <input type = "Submit" name ="action" value ="update" class="btn btn-primary text-center">
        </form>
    </div>
</body>
</html>