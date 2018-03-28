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

<title>Discussion board</title>
</head>
<body style="background-image:url('OJGKDNLAPLROREY.20070612151321.jpg');background-size:cover; font-size: 20px; color:white">
<jsp:include page="sidebar.jsp"></jsp:include>
<fieldset style="margin:100px 200px 300px 250px; background-color: #ebebe0; color:black; border-style: solid;">
<%
     PrintWriter output = response.getWriter();
	 response.setContentType("text/html"); 	%>	
	 <center>
	 <H1>Discussion Board</H1>
	 </center>
    <br><br>
    <% HashMap<String, ArrayList<String>> map = (HashMap<String, ArrayList<String>>)request.getAttribute("map");
     if(map != null){
     ArrayList<String> list = map.get("list");
     ArrayList<String> list1 = map.get("list1");
     ArrayList<String> id = map.get("pid");
     ArrayList<String> id1 = map.get("id");
     HttpSession hs = request.getSession();
     String user = (String) hs.getAttribute("User");
     
      	for(int i = 0; i < list.size(); i++){ 
      		
      		if(id.get(i).equals("0")) {%>
    		<br><b>	Topic :</b>   <%= list1.get(i) %>
    			<div class="container">
    		<br><b>	Post :</b>    <%= list.get(i) %>
    					
    				<% if(!user.equals("Student")) {%>
	    				<form action = "deletePost" align="right" style="margin-left:700px"> 
		    				<input type='hidden' value='<%= id1.get(i) %>' Name = 'postId'>
		    				<input type='submit' class="btn btn-lg btn-success" value='Delete'>
	    				</form>
    				<%}%>
    			</div><hr style="border: 3px outset white">
    				
      		<%} 	
			for(int j = 0; j < list.size(); j++){
				if(id1.get(i).equals(id.get(j))){ %>
				   <div><%=hs.getAttribute("net")%> : <%= list.get(j) %><hr></div>    		 
			<% }%>
			${errmsg} 
			<%}
			if(id.get(i).equals("0")){
    		%>
    		<div class="container">
    		<form action='DiscussionBoard' method='post' style="width:300px">
	    		<TEXTAREA  name='MainPost' class='form-control' id='comment' ROWS='2' cols='40' placeholder='reply here' style="color:black" required></TEXTAREA><br>
	    		<input type='hidden' value='<%= list1.get(i) %>' Name = 'Topic'>
	    		<input type='hidden' value='<%= id1.get(i) %>' Name = 'parentId'>
	    		<input type='submit' class="btn btn-lg btn-success" value='Submit'><br>
    		</form>
    		</div>
    		<hr style="border: 3px outset yellow">
    		<%}
		}
     }%>   
${errmsg}
</fieldset>
</body>
</html>