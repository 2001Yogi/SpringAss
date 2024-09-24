<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.model.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin - Manage Users</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>All Registered Users</h2>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Mobile</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<User> users = (List<User>)request.getAttribute("users"); // Getting the list of users from request
            if (users != null) {
                for (User user : users) {
        %>
            <tr>
                <td><%= user.getId() %></td>
                <td><%= user.getFirstname() %></td>
                <td><%= user.getLastname() %></td>
                <td><%= user.getEmail() %></td>
                <td><%= user.getMobile() %></td>
                <td>
                    <a href="deleteUser.jsp?id=<%= user.getId() %>" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        <%
                }
            } else {
        %>
            <tr>
                <td colspan="6">No users found!</td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
