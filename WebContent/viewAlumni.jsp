<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter"%>
<%@ page contentType="text/html" %>
<%@page import="java.util.*"%>

<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  --%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<title>View Alumni</title>
<script language="javascript" type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript"></script>
</head>
<body style="background-image:url('OJGKDNLAPLROREY.20070612151321.jpg');background-size:cover; font-size: 17px;color:white">
<jsp:include page="sidebar.jsp"></jsp:include>
<br><br>
<center>
<H1 style="color:white">Alumni</H1><br><br>

<%
	ArrayList<String> list = (ArrayList<String>)request.getAttribute("list"); 
	HttpSession hs = request.getSession();
	String user = (String) hs.getAttribute("User"); 
	if(list != null){%>
	<table style="width:70%;font-size:25">
	<tr>
		<th><center>NO.</center></th>
		<th><center>Alumni Name</center></th>
		<th><center>Founded In</center></th>
		<th><center>Home Page</center></th>
		<th><center>Information</center></th>
		<% if(!user.equals("Student")){%>
			<th><center>Edit/Delete</center></th>
		<%}%>
	</tr>	
	<%int i = 0;
	while(i < list.size()){%>
		<tr>
			<td><center><%=(i+1)%></center></td>
			<td><center><%=list.get(i+1)%></center></td>
			<td><center><%=list.get(i+2)%></center></td>
			<td><center><a href = <%=list.get(i+3)%>> Click here</a></center></td>
			<td><center><%=list.get(i+4)%></center></td>
			<td><center>
				<%if(!user.equals("Student")){ 
				hs.setAttribute("AlumniID", list.get(i));%>
				<a href="editAlumni">Edit</a> / <a href="DeleteAlumni">Delete</a>
				<%}%>
			</center></td>
	<% i=i+5;	
	}%>
	</table>
	<%}%>
	${errmsg}
</center>	
</body>
</html>