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

<title>My Profile</title>
</head>
<body style="background-image:url('OJGKDNLAPLROREY.20070612151321.jpg');background-size:cover; font-size: 25px; color:white">
<jsp:include page="sidebar.jsp"></jsp:include>
<br><br>
<%HttpSession hs = request.getSession();
HttpSession hs1 = request.getSession();%>
<center><H1 style="color:white"><%= hs.getAttribute("net") %></H1></center><br><br>
<%
	PrintWriter output = response.getWriter();
	response.setContentType("text/html");
	HashMap<String, ArrayList<String>> map = (HashMap<String, ArrayList<String>>)hs1.getAttribute("map");
	if(map != null){
	ArrayList<String> list = map.get("info");
	ArrayList<String> name = map.get("cName");
	if(list != null && name != null){ %>
	<center>
	<table style="width:700px">
	<%for(int i = 0; i < list.size(); i++) {
		if(!(name.get(i)).equals("Password") || !(list.get(i)).equals(null)){%>
	 	<div><tr>
	 	<th><b><%= name.get(i) %></b></th>  
	 			<td><center><%= list.get(i) %></center></td>
	 	</tr></div>
	 	<%}
	}}}%>
	 </table>
	 </center>
	<form action="EditUser.jsp" method="post">
			<center>
			<input type="submit" class="btn btn-lg btn-success" value="Edit">
			</center>
	</form>
<br>	
	
</body>
</html>