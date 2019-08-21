<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Channel</title>
<link href="css/myChannel.css" rel="stylesheet" type="text/css">
<link href="css/myChannel2.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/minty.css" rel="stylesheet" type="text/css">

<style type="text/css">
.photo {
	width: 100px;
    height: 100px;
    object-fit: cover;
    object-position: top;
    border-radius: 50%;
    margin-bottom: 10px;
}
</style>


</head>
<body>
<%@ include file="../header.jsp" %>

  <!-- Page Content -->
  <div class="container" style="position: relative;">

    <!-- Header -->
    <nav class="header1 header2">
      <div style="display: inline-block; text-align: center;"><img class="photo" src="../resources/image/profileimg.jpg" /><br>
      <a href="edit_profile" class="btn btn-primary" style="font-size:12px;">Edit Profile</a></div>
    </nav>

	<div class="middle">
	<div class="my_upload middlectrl">
	<h5 style="margin: auto auto">My Upload</h5>
	</div>
	<div class="middelctrl"></div>
	<div class="upload middlectrl">
	<input type = "button" class="btn btn-primary" value= "Upload Video">
	</div>
	</div><!-- middle -->




    <!-- Page Features -->
    <div class="row text-center" style="position: relative;">

      <div class="col-lg-3 col-md-6 mb-4">
        <div class="card h-100">
          <img class="card-img-top" src="http://placehold.it/500x325" alt="">
          <div class="card-body">
            <h4 class="card-title">Card title</h4>
            <p class="card-text">영상내용</p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">Find Out More!</a>
          </div>
        </div>
      </div>

      <div class="col-lg-3 col-md-6 mb-4">
        <div class="card h-100">
          <img class="card-img-top" src="http://placehold.it/500x325" alt="">
          <div class="card-body">
            <h4 class="card-title">Card title</h4>
            <p class="card-text">영상내용</p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">Find Out More!</a>
          </div>
        </div>
      </div>

      <div class="col-lg-3 col-md-6 mb-4">
        <div class="card h-100">
          <img class="card-img-top" src="http://placehold.it/500x325" alt="">
          <div class="card-body">
            <h4 class="card-title">Card title</h4>
            <p class="card-text">영상내용</p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">Find Out More!</a>
          </div>
        </div>
      </div>

      <div class="col-lg-3 col-md-6 mb-4">
        <div class="card h-100">
          <img class="card-img-top" src="http://placehold.it/500x325" alt="">
          <div class="card-body">
            <h4 class="card-title">Card title</h4>
            <p class="card-text">영상내용</p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">Find Out More!</a>
          </div>
        </div>
      </div>

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->

 
<%@ include file="../footer.jsp" %>
</body>
</html>