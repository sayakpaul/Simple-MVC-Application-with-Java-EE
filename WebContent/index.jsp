<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<%@ include file="header.jsp" %>
<form action = "MasterController" method = "post">

Status : <select name = "n1">
<option value = "Invalid">Select Status</option>
<option value = "Active">Active</option>
<option value = "Inactive">Inactive</option>
<option value = "New">New</option>
</select>
<input type = "hidden" name = "action" value = "firstPage">
<input type = "submit" value = "Submit">
<br />
</form>
<br />
<%@ include file="footer.jsp" %>
</body>
</html>