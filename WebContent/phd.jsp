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

<title>PhD Students</title>
</head>
<body style="background-image:url('OJGKDNLAPLROREY.20070612151321.jpg');background-size:cover; font-size: 25px;color:white">
<jsp:include page="sidebar.jsp"></jsp:include>
<br><br>
<center>
<H1 style="color:white">PhD Students</H1><br><br>
<%

	PrintWriter output = response.getWriter();
	response.setContentType("text/html");
	HttpSession hs2 = request.getSession();
	HashMap<String, ArrayList<String>> map = (HashMap<String, ArrayList<String>>)hs2.getAttribute("map");
	if(map != null){
	ArrayList<String> list = map.get("list");
	ArrayList<String> id = map.get("id");
	if(id != null && list != null){%>
	
	 <form action="PhdStudents" Method="get" style="width:300px"> 
	 <div class="dropdown">
	 <div><select name="phdStudents" class="form-control">
         <option value="select" selected>Select name of the student</option>
            <% for(int i = 0; i < id.size(); i++){%>
            <option value=<%= id.get(i) %>><%= list.get(i) %></option> 
    		<%}%>      
		</select></div><br>
		<div><input type="submit" class="btn btn-lg btn-success" value="Submit"></div><br>
	</div>
	</form>
	<%}}%>
	
	 <%HashMap<String, ArrayList<String>> map1 = (HashMap<String, ArrayList<String>>)request.getAttribute("map1");
	 if(map1 != null){
	 ArrayList<String> cName = map1.get("cName");
//	 output.println(cName.get(1));
	 ArrayList<String> info = map1.get("info"); %>
	 <div>
	 <center>
	 <table style="width:50%">
<%	for(int i = 0; i < cName.size(); i++) {%>
	 	<div><tr>
	 	<th><b><%= cName.get(i) %></b></th>  
	 			<td><center><%= info.get(i) %></center></td>
	 	</tr></div><br>
	<%}%>
	 </table>
	 <form action="PhdStudents" Method="post" style="width:300px">
	 	</div><br><input type='text' name='status' placeholder='Status' style='color:black'></div><br>
	 	<%-- </div><br><input type='hidden' name='net' value=<%= net %>></div><br> --%>
	 	<div><input type="submit" class="btn btn-lg btn-success" value="Change Status"></div><br>
	 </form>
	 
	 </center>
	 </div>
	<%}%>  		
<br>
${errmsg}
</center>	
</body>
</html>