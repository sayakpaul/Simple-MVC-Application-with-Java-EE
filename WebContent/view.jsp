<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import = "java.util.*,com.model.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View <%=request.getAttribute("booga") %> Items</title>
</head>
<body>
<%@ include file = "header.jsp" %>
<% ArrayList<ProductBean> pb = (ArrayList<ProductBean>)request.getAttribute("AcList"); %>
<table border = 2>
<tr>
<th>Product ID</th><th>Product Name</th><th>Status</th><th>Action</th>
</tr>
<% for(ProductBean a : pb) { %>
<tr>
<td><%= a.getId() %></td><td><%= a.getName() %></td><td><%= a.getStatus() %></td><td><a href = "MasterController?action=viewing&id=<%=a.getId()%>">View</a></td>
</tr>
<%} %>

</table>
<br>
<br>
<%@ include file = "footer.jsp" %>

</body>
</html>