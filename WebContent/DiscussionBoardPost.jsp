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
<title>View Discussion</title>
</head>
<body style="background-image:url('OJGKDNLAPLROREY.20070612151321.jpg');background-size:cover; font-size: 17px">
<jsp:include page="sidebar.jsp"></jsp:include>
<br><br>
			<center>	
			<div class='container'>	
			<H1 style='color:white'>Discussion Board</H1> 
			<form action='DiscussionBoard' method='post' style="width:300px">
			<div>
			<input type='text' class='form-control' name='Topic' placeholder = 'Topic'>
			</div><br>
        	<div>
        	<TEXTAREA NAME='MainPost' class='form-control'  id='comment' ROWS='5' cols='70' placeholder = 'Please enter your Discussion post here:'></TEXTAREA>
        	</div><br>
        	<input type='hidden' value='0' Name = 'parentId'>
        	${errmsg}
        	
        	<INPUT TYPE='SUBMIT' class='btn btn-lg btn-success' VALUE='Submit'>
        	</FORM>
        	
        	</div>
        	${errmsg}
 			</center>
</body>
</html>