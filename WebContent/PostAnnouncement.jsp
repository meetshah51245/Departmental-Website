<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<title>Post Announcement</title>
<script type="text/javascript">
$(document).ready(function(){
    $("select").change(function() {
        $("select option:selected").each(function(){
            if($(this).attr("value")=="Job Opportunity"){
                $('textarea[name=link]').show();
            }else{
                $('textarea[name=link]').hide();
            }
        });
    }).change();
}); 
</script>
</head>
<body style="background-image:url('OJGKDNLAPLROREY.20070612151321.jpg');background-size:cover; font-size: 17px; color:white">
	<jsp:include page="sidebar.jsp"></jsp:include>
	<br><br><br>
	<center>
	<H1 style="color:white">Post Announcement</H1><br><br>
	<form action="PostAnnouncement" method="post" style="width:670px">
	<div class="dropdown">
	 <div><select name="type" class="form-control" id="type">
         <option value='select' selected>Select type</option>
           
            <option value='Job Opportunity'>Job Opportunity</option> 
         
            <option value='Event'>Event</option>
            
            <option value='News'>News</option> 
           
      </select></div><br>
      
      <div><TEXTAREA NAME='MainPost' class='form-control'  ROWS='5' 
      			cols='70' placeholder = 'Please enter your announcement here:'></TEXTAREA></div><br>
      
      <div><TEXTAREA NAME='link' class='form-control'  
      				placeholder = 'Please provide link here:' id="link"></TEXTAREA></div><br>
      				
      	<div><input type="submit" class="btn btn-lg btn-success" value="Post"></div><br>						
      </div>
      </form>
      ${errmsg}
</center>
</body>
</html>