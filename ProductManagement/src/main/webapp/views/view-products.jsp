<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>View Products</title>
</head>
<body>
    <h1>Products List</h1>

    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Product Name</th>
                <th>Description</th>
                <th>Price</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.p_name}</td>
                    <td>${product.p_description}</td>
                    <td>${product.price}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div>
        <c:if test="${currentPage > 0}">
            <a href="?page=${currentPage - 1}">Previous</a>
        </c:if>
        <c:if test="${currentPage < totalPages - 1}">
            <a href="?page=${currentPage + 1}">Next</a>
        </c:if>
    </div>

    <a href="${pageContext.request.contextPath}/products/add">Add Product</a>
</body>
</html>
