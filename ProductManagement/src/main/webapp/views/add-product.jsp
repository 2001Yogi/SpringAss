<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
    <h1>Add Product</h1>
    <form action="${pageContext.request.contextPath}/products/add" method="post">
        <label for="p_name">Product Name:</label>
        <input type="text" id="p_name" name="p_name" required><br>

        <label for="p_description">Product Description:</label>
        <input type="text" id="p_description" name="p_description" required><br>

        <label for="price">Price:</label>
        <input type="number" id="price" name="price" required><br>

        <button type="submit">Add Product</button>
    </form>

    <a href="${pageContext.request.contextPath}/products">View Products</a>
</body>
</html>
