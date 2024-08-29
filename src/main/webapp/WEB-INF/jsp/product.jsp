<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
    <title>Products List</title>
</head>
<body>
<h1>Product List</h1>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>

    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
