
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<title>registration</title>

<script>
function disabl() {
	document.getElementById("disbl").style.visibility='hidden';
	document.getElementById("disbl1").style.visibility='hidden';
}
function enabl() {
	document.getElementById("disbl").style.visibility='visible';
	document.getElementById("disbl1").style.visibility='visible';
}
</script>

</head>
<body style="background-image:url('OJGKDNLAPLROREY.20070612151321.jpg');background-size:cover; font-size: 20px; color:white">
<%-- <jsp:include page="sidebar.jsp"></jsp:include> --%>
<center>
<div class="container">
<br>
<H1 style="color:white">Registration</H1><br><br>
<form action="registration" method="post" enctype="multipart/form-data" style="width:300px"> 	
	<div><label class="radio-inline" style="font-size:20px">
	<input type="radio" name="User" value="Student" onclick="enabl()">Student
	</label>
	
	<label class="radio-inline" style="font-size:20px">
	<input type="radio" name="User" value="Faculty" onclick="disabl()">Faculty
  	</label>
  	
  	<label class="radio-inline" style="font-size:20px">
	<input type="radio" name="User" value="Staff" onclick="disabl()">Staff
  	</label></div>
    <br>  
  	<div><input type="text" class="form-control" name="first name" placeholder = "First Name" ></div>
  	<br>
  	<div><input type="text" class="form-control" name="last name" placeholder = "Last Name" ></div>
  	<br>
  	<div><input type="text" class="form-control" name="NET ID" placeholder = "NET ID" ></div>
  	<br>
  	<div><input type="password" class="form-control" name="Password" placeholder = "Password" ></div>
  	<br>
  	<div><input type="text" class="form-control" name="Program" placeholder = "Program:BS/BA/ MS/PhD" id="disbl"></div>
  	<br>
  	<div><input type="text" class="form-control" name="major" placeholder = "Major" id="disbl1" ></div>
  	<br>
  	<div><input type="submit" class="btn btn-lg btn-success" value="Submit"></div>
  	<br>
  	${errmsg}
</form>
</div>
</center>
</body>
</html>