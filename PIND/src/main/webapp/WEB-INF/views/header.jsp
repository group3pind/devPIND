<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PIND page header</title>

  <!-- Bootstrap core CSS -->
  <link href="css/bootstrap.css" rel="stylesheet">
  <link href="css/minty.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/shop-homepage.css" rel="stylesheet">
  
  <style type="text/css">
  header {
   position:fixed;
   left:0px;
   top:0px;
   width:100%;
   background:#35acff;
   color: white;
   z-index: 1000;
}
  </style>
</head>
<body>
 <!-- Navigation -->
 <header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" >
    <div class="container">
      <a class="navbar-brand" href="javascript:sidebar()">SIDEBAR</a>
      <a class="navbar-brand" href="#">PIND</a>
     <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="text" placeholder="Search">
      <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
    </form>
      
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#">HOME
              <span class="sr-only">(current)</span>
            </a>
          </li>          
          <li class="nav-item">
            <a class="nav-link" href="#">ABOUT</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">JOIN</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="login">LOGIN</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
 </header>
</body>
</html>