<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "com.model.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item</title>
</head>
<body>
<% ProductBean a = (ProductBean)request.getAttribute("id"); %>
<table border = 2>
<tr><th>Product ID</th><th>Product Name</th><th>Quantity</th><th>Price/Unit (Rs.)</th>
</tr>
<tr><td><%= a.getId() %></td><td><%= a.getName() %></td><td><%= a.getQuantity() %></td><td><%= a.getPrice() %></td>
</tr>
</table>
</body>
</html>