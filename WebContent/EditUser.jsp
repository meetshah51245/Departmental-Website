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
<title>Edit Profile</title>
</head>
<body style="background-image:url('OJGKDNLAPLROREY.20070612151321.jpg');background-size:cover; font-size:25px; color:white">
<jsp:include page="sidebar.jsp"></jsp:include>
<center>
<br><br>
<H1 style="color:white">Edit your profile</H1><br>
<div class="container">
<form action="EditUserInfo" method="post" style="width:300px"> 	
	<% 
	response.setContentType("text/html");
	HttpSession hs1 = request.getSession(); 
	HashMap<String, ArrayList<String>> map = (HashMap<String, ArrayList<String>>)hs1.getAttribute("map");
	if(map != null){
	ArrayList<String> list = map.get("info");
	ArrayList<String> name = map.get("cName");
	
	for(int i = 0; i < list.size(); i++){
		if(name.get(i).equals("User") || name.get(i).equals("Net ID") || name.get(i).equals("Status") || name.get(i).equals("Join Date")){%>
			<div><input type="text" class="form-control" name= '<%= name.get(i) %>' value = '<%= list.get(i) %>' placeholder=<%= name.get(i) %> disabled></div><br>
			<div><input type="hidden" class="form-control" name= '<%= name.get(i) %>' value = '<%= list.get(i) %>' placeholder=<%= name.get(i) %>></div>
		<%}else{%>
			<div><input type="text" class="form-control" name= '<%= name.get(i) %>' value = '<%= list.get(i) %>' placeholder=<%= name.get(i) %>></div><br>
			<div><input type="hidden" class="form-control" name= '<%= name.get(i) %>' value = '<%= list.get(i) %>' placeholder=<%= name.get(i) %>></div>

	 <%}}
	if((list.get(0).equals("Faculty") || list.get(0).equals("Staff")) && list.size() == 5){%>		
		 <div><input type="text" class="form-control" name = "Contact Number" placeholder= "Contact Number"></div><br>
		 <div><input type="text" class="form-control" name = "E-mail" placeholder= "E-mail"></div><br>
	<% }else if(list.get(0).equals("Student") && list.size() == 8){%>
		<div><input type="text" class="form-control" name = "Contact Number" placeholder= "Contact Number"></div><br>
		<div><input type="text" class="form-control" name = "E-mail" placeholder= "E-mail"></div><br>
		<div><input type="text" class="form-control" name = "Advisor" placeholder= "Advisor"></div><br>
		<div><input type="text" class="form-control" name = "Status" placeholder= "Status" disabled></div><br>
	<%}}%>
  	<div><input type="submit" class="btn btn-lg btn-success" value="Submit"></div><br>
  	${errmsg}
</form>

</div>
</center>
</body>
</html>