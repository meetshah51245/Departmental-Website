<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Side bar/Menu bar</title>
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: white;
}
.dropbtn {
    background-color: #e0e0d1;
    color: black;
    padding: 15px;
    font-size: 13px;
    border: none;
    cursor: pointer;
}
.dropdown {
    display: inline-block;
}
.dropdown:hover .dropbtn {
    background-color: none;
}
</style>


<script type="text/javascript">

function FunctionHome(){
	$('#div').show();
	$('p').hide();
	$('#HomeId').show();
}

function FunctionDiscussion(){
	$('#div').show();
	$('p').hide();
	$('#DiscId').show();
}

function FunctionEmail(){
	$('#div').show();
	$('p').hide();
	$('#manageEmail').show();
}

function FunctionUser(){
	$('#div').show();
	$('p').hide();
	$('#ProfileId').show();
}

function FunctionCourses(){
	$('#div').show();
	$('p').hide();
	$('#courseId').show();
}

function FunctionExams(){
	$('#div').show();
	$('p').hide();
	$('#examId').show();
}

function FunctionAnnouncement(){
	$('#div').show();
	$('p').hide();
	$('#AnnouncementId').show();
}

function FunctionResources(){
	$('#div').show();
	$('p').hide();
	$('#ResourceId').show();
}

function FunctionPhD(){
	$('#div').show();
	$('p').hide();
	$('#PhDId').show();
}

function FunctionAlumni(){
	$('#div').show();
	$('p').hide();
	$('#alumniId').show();
}

function FunctionLogOut(){
	$('#div').show();
	$('p').hide();
	$('#loginId').show();
}

</script>



</head>
<body style="background-image:url('OJGKDNLAPLROREY.20070612151321.jpg');background-size:cover">
  <ul>  
<%HttpSession hs = request.getSession();
  String user = (String) hs.getAttribute("User");%>
  <div class="dropdown">
  <button class="dropbtn" onclick="FunctionHome()">Home</button>
  </div>
  
  <div class="dropdown">
  <button class="dropbtn" onclick="FunctionEmail()">Send E-mail</button>
  </div>
  
  <div class="dropdown">
  <button class="dropbtn" onclick="FunctionUser()">User Profile</button>
  </div>

  <div class="dropdown">
  <button class="dropbtn" onclick="FunctionCourses()">Courses</button>
  </div>

  
  <div class="dropdown">
  <button class="dropbtn" onclick="FunctionExams()">Exams</button>
  </div>

  
  <div class="dropdown">
  <button class="dropbtn" onclick="FunctionAnnouncement()">Announcements BOARD</button>
  </div>
  
  <div class="dropdown">
  <button class="dropbtn" onclick="FunctionDiscussion()">Discussion BOARD</button>
  </div>
  
  <div class="dropdown">
  <button class="dropbtn" onclick="FunctionResources()">Resources</button>
  </div>
  
  <%if(!user.equals("Student")){%>
  <div class="dropdown">
       <button class="dropbtn" onclick="FunctionPhD()">PhD Students</button>
  </div>
<%}%>
  <div class="dropdown">
  <button class="dropbtn" onclick="FunctionAlumni()">Alumni</button>
  </div>

  <div class="dropdown">
  <button class="dropbtn" onclick="FunctionLogOut()">Log Out</button>
  </div>
  
</ul>

<div id="div" style="display:none;position:fixed;margin-right:1000px;  margin-top: 0.1cm; height: 1000px; width: 200px;background-color: #e0e0d1;">
<center>
<p id="manageEmail" style="display: none;">
		  
		  <a href="https://login.microsoftonline.com/login.srf?wa=wsignin1.0&rpsnv=4&ct=1462384176&rver=6.6.6556.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.office.com%2fowa%2f%3frealm%3dalbany.edu%26exch%3d1&id=260563&whr=albany.edu&CBCXT=out&msafed=0">Send E-mail</a>        
</p>

<p id="HomeId" style="display: none;">
		  
		  <a href="HomePage.jsp">Home</a>        
</p>

<p id="ProfileId" style="display: none;">
		  
		  <a href="UserProfile">View</a>
          <br><br><a href="EditUser.jsp">Edit</a>
          
</p>

<p id="courseId" style="display: none;">
	
	<%
	
	if(!user.equals("Student")){%>
	<a href="createCourse.jsp">Create new Course</a>
	<%}%>
	<br><br><a href="ViewCourseList">View Course</a>
	
</p>

<p id="AnnouncementId" style="display: none;">
	<%if(!user.equals("Student")){%>
		<a href="PostAnnouncement.jsp">Post Announcement</a>
	<%}%>
	<br><br><a href="ViewAnnouncement">View Events/News</a>
	<br><br><a href="ViewJobs">View Jobs</a>
	
</p>

<p id="DiscId" style="display: none;">
	<%if(!user.equals("Student")){%>
	<a href="DiscussionBoardPost.jsp">Post Discussion</a>
	<%}%>
	<br><br><a href="discussion">View Discussion Board</a>
	
</p>

<p id="examId" style="display: none;">
		  <%if(!user.equals("Student")){%>
			  <a href="postExam.jsp">Post Exams</a>
	          <br><br><a href="PostResult.jsp">Post Result</a>
          <%}%>
          <br><br><a href="ViewExams">View Exams</a>
          <%if(user.equals("Student")){%>
          	  <br><br><a href="ViewExams">Exam Registration</a>
          <%}%>
          <br><br><a href="ViewResult.jsp">View Result</a>
          
</p>

<p id="alumniId" style="display: none;">
	<%if(!user.equals("Student")){%>
	<a href="PostAllumni.jsp">Post Alumni</a>
	<%}%>
	<br><br><a href="PostAlumni">View Alumni</a>
	
</p>

<%if(!user.equals("Student")){%>
<p id="PhDId" style="display: none;">
	<a href="PhD">PhD Student</a>
</p>
<%}%>

<p id="ResourceId" style="display: none;">
	<%if(user.equals("Staff")){%>
	<a href="CreateResource.jsp">Create Resource</a>
	<%}%>
	<br><br><a href="CreateResource">Reserve Resource</a>
	<br><br><a href="ViewReservation">View Reserved Resource</a>
	
</p>

<p id="loginId" style="display: none;">
	<a href="LogOut">Logout</a>
</p>

</div>
</center>
</body>
</html>