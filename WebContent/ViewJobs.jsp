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
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<title>View Jobs</title>

</head>
<body style="background-image:url('OJGKDNLAPLROREY.20070612151321.jpg');background-size:cover; font-size: 20px; color:white">
<jsp:include page="sidebar.jsp"></jsp:include>
<center>		
<H1>JOBS</H1>
</center>
<fieldset style="margin:100px 200px 300px 250px; background-color: #ebebe0; color:black; border-style: solid;">
<%
     PrintWriter output = response.getWriter();
	 response.setContentType("text/html");
	 ArrayList<String> list = (ArrayList<String>)request.getAttribute("list");
	 HttpSession hs = request.getSession();
	 String user = (String) hs.getAttribute("User");
	 if(list != null){
	 for(int i = 0; i < list.size(); i=i+4){%>
		    
			<div class="container">
			     
			    <div><b>Post :</b> <%= list.get(i+1) %></div><br>
		       
			    <div><a href = <%= list.get(i+2) %>> Apply here </a></div><br>
				<%if(!user.equals("Student")){%>
					<form action = "ViewJobs" method="Post" style="margin-left:700px"> 
						<input type='hidden' value='<%= list.get(i) %>' Name = 'postId'>
						<input type='submit' class="btn btn-lg btn-success" value='Delete'>
					</form>
				<%}%>
				<b style="margin-left:500px">Posted By :</b> <%= list.get(i+3) %>
				<center>${errmsg}</center>  
			</div><hr style="border: 3px outset white">
			
	 <%}
	 }%>
</fieldset>	  
</body>
</html>