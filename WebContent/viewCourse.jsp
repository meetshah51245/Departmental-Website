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
<title>View Courses</title>
<script language="javascript" type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript"></script>
</head>
<body style="background-image:url('OJGKDNLAPLROREY.20070612151321.jpg');background-size:cover; font-size: 17px;color:white">
<jsp:include page="sidebar.jsp"></jsp:include><br><br>
<center>
<H1 style="color:white">Exams</H1><br><br>
<form action="ViewCourseList" Style="width:70">
<div class="dropdown">
	 <div><select name="concentration" class="form-control">
         <option value=-1 selected>Select Semester</option>
           
            <option value=2>Spring</option> 
         
            <option value=3>Fall</option>
            
            <option value=1>All</option> 
           
      </select></div><br>
</div> 	
		
	<div><input type="submit" class="btn btn-lg btn-success" value="Submit"></div><br>
  	${errmsg}
  	</form>

<%
	PrintWriter output = response.getWriter();
	response.setContentType("text/html");
	ArrayList<String> list = (ArrayList<String>)request.getAttribute("list");%> 
	<table style="width:700px;font-size:25">
	<%HttpSession hs = request.getSession();
	String user = (String) hs.getAttribute("User");%>
	<tr>
		<th><center>Course Id</center></th>
		<th><center>Course Name</center></th>
		<th><center>Instructor</center></th>
		<%if(!user.equals("Student")){%>
		<th><center>Add to teach</center></th>
		<%}%>
		<th><center>Add course Info</center></th>
		
	</tr>	
	<%int i = 0;
	while(i < list.size()){%>
		<tr>
			<td><center><%=list.get(i)%></center></td>
			<td><center><%=list.get(i+1)%></center></td>
			<td><center><%=list.get(i+2)%></center></td>
			<%if(!user.equals("Student")){%>
			<td>
				
				<form action="EditCourseList" method="post" Style="width:70">
				<center>
				<input type="submit" class="btn btn-lg btn-success" value="Add">
				<input type='hidden' value='<%= hs.getAttribute("c") %>' Name = 'concentration'>
				<input type='hidden' value='<%= hs.getAttribute("net") %>' Name = 'instructor'>
				<input type='hidden' value='<%= list.get(i) %>' Name = 'courseId'>
				</center>
				</form>
				
			</td>
			<%}%>
			<td>
				<%
				if(user.equals("Student")){%>
					<center>
					<%= list.get(i+3) %>
					</center>
				<%}else{%>
					<center>
					<form action="EditCourseList" method="get" Style="width:70; color:black">
					<TEXTAREA name="syllabus" placeholder = "Enter information here.."><%= list.get(i+3) %></TEXTAREA>
					<input type='hidden' value='<%= hs.getAttribute("c") %>' Name = 'concentration'>
					<input type='hidden' value='<%= list.get(i) %>' Name = 'courseId'>
					<input type="submit" class="btn btn-default" aria-label="Left Align" value="Post" style="background-color: #4CAF50">
					</form>
					</center>
				<%}
				%>
			</td>
		<% i=i+4;	
	}%>
	</table>
	<%if(!user.equals("Student")){%>
	<br><div><a href="createCourse.jsp" style="font-size: 20px">Create new course</a></div><br><br>
	<%}%>
</center>	
</body>
</html>