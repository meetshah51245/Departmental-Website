<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<title>Create Course</title>
</head>
<body style="background-image:url('OJGKDNLAPLROREY.20070612151321.jpg');background-size:cover; font-size: 17px; color:white ">
<jsp:include page="sidebar.jsp"></jsp:include>
<center>
<br><br>
<H1 style="color:white">Create Course</H1><br><br>
<div class="container">
<form action="CourseList" method="post" style="width:300px">
	 <div class="dropdown">
	 <div><select name="concentration" class="form-control">
         <option value=-1 selected>Select Semester</option>
           
            <option value=2>Spring</option> 
         
            <option value=3>Fall</option>
            
      </select></div><br>
      </div> 	
  	<div><input type="text" class="form-control" name="id" placeholder = "COURSE ID"></div><br>
  	<div><input type="text" class="form-control" name="name" placeholder = "COURSE NAME"></div><br>
  	<div><input type="submit" class="btn btn-lg btn-success" value="Submit"></div><br>
  	${errmsg}
</form>

</div>
</center>
</body>
</html>