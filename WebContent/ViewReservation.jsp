<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter"%>
<%@ page contentType="text/html" %>
<%@page import="java.util.*"%>

 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<title>View Reservations</title>
</head>
<body style="background-image:url('OJGKDNLAPLROREY.20070612151321.jpg');background-size:cover; font-size: 25px;color:white">
<jsp:include page="sidebar.jsp"></jsp:include><br><br>
<center>
<H1 style="color:white">Your Reservations</H1><br>
<%

	PrintWriter output = response.getWriter();
	response.setContentType("text/html");
	ArrayList<String> list = (ArrayList<String>)request.getAttribute("list");
	HttpSession hs = request.getSession();
	if(list != null){%> 
	
	<table style="width:700px">
	<tr>
		<th>NO.</th> 
		<th>Type</th> 
		<th>Name</th>
		<th>Content</th>
		<th>Date</th>
		<th>Time</th>
		<th>Cancel</th>

	</tr>	
	<%int i = 0;
	int j = 1;
	while(i < list.size()){%>
		<tr>
			<td><%= j %></td>
			<td><%=list.get(i)%></td>
			<td><%=list.get(i+1)%></td>
			<td><%=list.get(i+2)%></td>
			<td><%=list.get(i+3)%></td>
			<td><%=list.get(i+4)%></td>
			<td>
			<form action="ViewReservation" method="post">		
			<input type='hidden' value='<%= list.get(i+5) %>' Name = 'ID'>
				<input type="submit" id="register" class="btn btn-lg btn-success" value="Cancel"> 
			</form>
			</td>
		</tr>
		<% i=i+6;	
		j++;
	}}%>
	</table><br>
	</form>
	${errmsg}
<br>
</center>	
</body>
</html>