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

<title>View Result</title>
<script language="javascript" type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript"></script>
</head>
<body style="background-image:url('OJGKDNLAPLROREY.20070612151321.jpg');background-size:cover; font-size: 17px; color:white">
	<jsp:include page="sidebar.jsp"></jsp:include><br><br>
	<center>
	<br><br>
	<div class="container">
	<H1 style="color:white">View Result</H1><br><br>
    			
    		<form action="ViewResult" method="get">
        	
        	<div><label class="radio-inline" style="font-size:20px">
			<input type="radio" name="examType" value="Mid-term" checked>Mid-term
			</label>
	
			<label class="radio-inline" style="font-size:20px">
			<input type="radio" name="examType" value="Final">Final 
			</label>
	
			<label class="radio-inline" style="font-size:20px">
			<input type="radio" name="examType" value="Quiz">Quiz
			</label>
			
			<label class="radio-inline" style="font-size:20px">
			<input type="radio" name="examType" value="Other">Other
			</label></div><br>
			
			<div><INPUT TYPE="SUBMIT" class="btn btn-lg btn-success" VALUE="Submit"></div><br>
        	</form>
     </div>   	
     <font size="8" color="black">${errmsg}</font>
     <div>
     <% response.setContentType("text/html");
     ArrayList<String> list = (ArrayList<String>)request.getAttribute("list"); 
     if(list != null){%>
	    <form action="ViewResult" method="post"  style="width:70%"> 
	        	
	        <div><select name="name" class="form-control">
	        	<%for(int i = 0; i < list.size(); i++){ %>
	        		<option value = <%= list.get(i) %>> <%= list.get(i) %> </option>
	        	<%}%>
	        </select></div><br>
	        <div><INPUT TYPE="SUBMIT" class="btn btn-lg btn-success" VALUE="View"></div><br>
	     	
	    </form> 
     <%}%>
     </div>
     <%ArrayList<String> resultArray = (ArrayList<String>) request.getAttribute("resultArray");
     if(resultArray != null){
     String result = resultArray.get(0);
     String owner = resultArray.get(1);
     HttpSession hs = request.getSession();
     String user = (String) hs.getAttribute("netId");
     int type = 1;
     if(owner != user){
    	 type = 0;
     }%>
     <%if(type == 0){ %>
     <form action = 'EditResult' method = 'post' style="width:70%">
     	<div><TEXTAREA NAME='post' class='form-control' id='comment' ROWS='5' cols='70' 
	      			 placeholder = 'Please enter result details here:' disabled><%= resultArray.get(0) %></TEXTAREA></div><br>
	      	<input type='hidden' value='<%= owner %>' Name = 'owner'>		    	       
	   		<div><INPUT TYPE="SUBMIT" class="btn btn-lg btn-success" VALUE="Post" disabled></div><br>
     </form>
     <%}else{%>
     <form action = 'EditResult' method = 'post' style="width:70%">
     	<div><TEXTAREA NAME='post' class='form-control' id='comment' ROWS='5' cols='70' 
	      			 placeholder = 'Please enter result details here:' ><%= resultArray.get(0) %></TEXTAREA></div><br>
	      	<input type='hidden' value='<%= owner %>' Name = 'owner'>		    	       
	   		<div><INPUT TYPE="SUBMIT" class="btn btn-lg btn-success" VALUE="Post" ></div><br>
     </form>
     <%}}%>
    </center>
</body>
</html>