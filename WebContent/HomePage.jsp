<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter"%>
<%@ page contentType="text/html" %>
<%@page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<title>Home page</title>
</head>
<body style="background-image:url('OJGKDNLAPLROREY.20070612151321.jpg');background-size:cover; font-size: 17px;color:white">
<jsp:include page="sidebar.jsp"></jsp:include>
<center>
<div class="container">
<br><br><br>
<H1 style="color:white">Welcome</H1><br>
<%HttpSession hs = request.getSession();%>	
<div style="font-size: 20px">
<%= hs.getAttribute("net") %>
<br><br><br>
<img src="logo.png" style="width:750px">
</div>
</div>
</center>
</body>
</html>