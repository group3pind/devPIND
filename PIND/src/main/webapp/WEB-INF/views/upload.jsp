<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="header.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Upload Page</title>

  <!-- Bootstrap core CSS -->
  <link href="css/bootstrap.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/shop-homepage.css" rel="stylesheet">
  <script src="vendor/jquery/jquery.min.js"></script>
</head>
<body>

  <!-- Page Content -->
  <div class="container">

    <div class="row">

      <div class="col-lg-3">
 
        <h1 class="my-4">Shop Name</h1>
        <div class="list-group">
          <a href="#" class="list-group-item">Category 1</a>
          <a href="#" class="list-group-item">Category 2</a>
          <a href="#" class="list-group-item">Category 3</a>
        </div>

      </div>
      <!-- /.col-lg-3 -->
		<div>
		<script type="text/javascript">
		$(document).ready(function(){
			$('#selvideo').on('change', function(){
				var videourl = document.getElementById('selvideo').value;
				var video = document.getElementById('upload_video');
				
				video.src = videourl;
			});
			
		})
		</script>
		<form method="POST" action="Insert.asp" name="myform" enctype="multipart/form-data">
			<video id="upload_video" controls="controls"></video>
			<input type="file" accept="video/*" id="selvideo" class="list-group-item">
		</form>
		</div>
		<!-- /.maincontent -->
    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
<%@ include file="header.jsp" %>
</html>