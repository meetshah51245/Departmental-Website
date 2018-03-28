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
<title>Reserve resources</title>
<script language="javascript" type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript"></script>
</head>
<body style="background-image:url('OJGKDNLAPLROREY.20070612151321.jpg');background-size:cover; font-size: 17px;color:white">
<jsp:include page="sidebar.jsp"></jsp:include>
<br><br><br>
<center><H1 style="color:white">Resources</H1></center>
<form action="ReserveResource" method="post" style="width:50; padding:2cm 4cm 3cm 8cm " >
<%
	ArrayList<String> list = (ArrayList<String>)request.getAttribute("list"); 
	if(list != null){%>	
		<%int i = 0;
		while(i < list.size()){%>
			
			<div><b>Name of the resource : </b> <%= list.get(i) %></div><br>
			<div><b>Type of the resource : </b> <%= list.get(i+1) %></div><br>
			<div><b>Information : </b> <%= list.get(i+2) %></div><br>
				
		<% i=i+3;	
		}
		i = 0;%>
		<input type='hidden' value='<%= list.get(i+1) %>' Name = 'resourceType'>
		<input type='hidden' value='<%= list.get(i) %>' Name = 'resourceName'>
		<input type='hidden' value='<%= list.get(i+2) %>' Name = 'resourceInfo'>
			<b>Select Date : </b><input type="date" class="form-control" name="date" style="width:200px"><br>
			<div><label class="radio-inline" style="font-size:20px">
			<input type="radio" name="TimeSlot" value="10.00 A.M - 11.00 A.M">10.00 A.M - 11.00 A.M
			</label><br>
			
			<label class="radio-inline" style="font-size:20px">
			<input type="radio" name="TimeSlot" value="11.00 A.M - 12.00 A.M">11.00 A.M - 12.00 A.M
		  	</label><br>
		  	
		  	<label class="radio-inline" style="font-size:20px">
			<input type="radio" name="TimeSlot" value="12.00 P.M - 1.00 P.M">12.00 P.M - 1.00 P.M
		  	</label><br>
		  	
		  	<label class="radio-inline" style="font-size:20px">
			<input type="radio" name="TimeSlot" value="1.00 A.M - 2.00 A.M">1.00 P.M - 2.00 P.M
		  	</label><br>
		  	
		  	<label class="radio-inline" style="font-size:20px">
			<input type="radio" name="TimeSlot" value="2.00 P.M - 3.00 P.M">2.00 P.M - 3.00 P.M
		  	</label><br>
		  	
		  	<label class="radio-inline" style="font-size:20px">
			<input type="radio" name="TimeSlot" value="3.00 P.M - 4.00 P.M">3.00 P.M - 4.00 P.M
		  	</label><br>
		  	
		  	<label class="radio-inline" style="font-size:20px">
			<input type="radio" name="TimeSlot" value="4.00 P.M - 5.00 P.M">4.00 P.M - 5.00 P.M
		  	</label><br>
		  	
		  	
		  	<label class="radio-inline" style="font-size:20px">
			<input type="radio" name="TimeSlot" value="5.00 P.M - 6.00 P.M">5.00 P.M - 6.00 P.M
		  	</label><br>
		  	
		  	
		  	<label class="radio-inline" style="font-size:20px">
			<input type="radio" name="TimeSlot" value="6.00 P.M - 7.00 P.M">6.00 P.M - 7.00 P.M
		  	</label><br>
		  	</div><br>
	  	
	  	<div><INPUT TYPE="SUBMIT" class="btn btn-lg btn-success" VALUE="Reserve"></div><br>
	  	</form>
   <%}%>
	${errmsg}

</body>
</html>