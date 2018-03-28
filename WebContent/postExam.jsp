<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<title>Post Exam</title>
</head>
<body style="background-image:url('OJGKDNLAPLROREY.20070612151321.jpg');background-size:cover; font-size: 17px; color:white">
	<jsp:include page="sidebar.jsp"></jsp:include>
	<center>
	<br><br><br>
	<div class="container">
	<H1 style="color:white">Post Exams</H1><br><br>
    			
    		<form action="postExam" method="post" style="width:400px">
        	
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
        	
        	<div><input type="text" class="form-control" name="ExamName" placeholder = "ExamName"></div><br>
        	
        	<div><input type="date" class="form-control" name="dateOfExam" placeholder = "Date of Exam mm/dd/yyyy"></div><br>
        	
        	<div><TEXTAREA NAME='post' class='form-control'  id='comment' ROWS='5' cols='70' 
        			placeholder = 'Please enter Exam details here:'></TEXTAREA></div><br>
        	
        	<div><INPUT TYPE="SUBMIT" class="btn btn-lg btn-success" VALUE="Post"></div><br>
        	</form>
        	
        	<font size="8" color="black">${errmsg}</font>
 	
    </div>
    </center>
</body>
</html>