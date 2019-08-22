<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="header.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shop Homepage - Start Bootstrap Template</title>

  <!-- Bootstrap core CSS -->
  <link href="css/bootstrap.css" rel="stylesheet">
  <link href="css/minty.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/shop-homepage.css" rel="stylesheet">
  
  <script>
  
  var i = 1;
  
  function sidebar () {
	  if ( i == 1) {	  
		  $('.col-lg-2').attr('class', 'col-lg-1');
		  $('.col-lg-10').attr('class', 'col-lg-11');
	  }
	  if (i == -1) {
		  $('.col-lg-11').attr('class', 'col-lg-10');
		  $('.col-lg-1').attr('class', 'col-lg-2');
	  }
	  i = i * (-1);
  }
  
  </script>
  
</head>
<body>
 
  
	  	
	    
  <div class="container_wrap">
  <div class="container_left">
  
  		<div class="col-lg-2">
	
	        <h1 class="my-4">사이드!!</h1>
	        <div class="list-group">
	          <a href="#" class="list-group-item">인기 영상</a>
	          <a href="#" class="list-group-item">최근 본 영상</a>
	        </div>
	
	     </div>
  </div>
     
  <!-- Page Content -->
  <div class="container">
  <div class="row" align="center">
      <!-- /.col-lg-3 -->

      <div class="col-lg-10">
		<nav class="caralign">
        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
          <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
          </ol>
          <div class="carousel-inner" role="listbox">
            <div class="carousel-item active">
              <img class="d-block img-fluid" src="http://placehold.it/750x260" alt="First slide">
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid" src="http://placehold.it/750x260" alt="Second slide">
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid" src="http://placehold.it/750x260" alt="Third slide">
            </div>
          </div>
          <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
          
        </div>
        <img src="http://placehold.it/200x200" class="caralign-child">
        </nav>

        <div class="row">

 		<div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-55">
              <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
              <div class="card_body">
                <h4 class="card_title">
                  <a href="#">Item Two</a>
                </h4>
                <h5>$24.99</h5>
                <p class="card-text">Lorem ipsum dolor sit amet,</p>
              </div>
              <div class="card-footer">
                <small class="text-muted"></small>
              </div>
            </div>
          </div>

          <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-55">
              <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
              <div class="card_body">
                <h4 class="card_title">
                  <a href="#">Item Two</a>
                </h4>
                <h5>$24.99</h5>
                <p class="card-text">Lorem ipsum dolor sit amet,</p>
              </div>
              <div class="card-footer">
                <small class="text-muted"></small>
              </div>
            </div>
          </div>

         <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-55">
              <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
              <div class="card_body">
                <h4 class="card_title">
                  <a href="#">Item Two</a>
                </h4>
                <h5>$24.99</h5>
                <p class="card-text">Lorem ipsum dolor sit amet,</p>
              </div>
              <div class="card-footer">
                <small class="text-muted"></small>
              </div>
            </div>
          </div>
          
         <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-55">
              <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
              <div class="card_body">
                <h4 class="card_title">
                  <a href="#">Item Two</a>
                </h4>
                <h5>$24.99</h5>
                <p class="card-text">Lorem ipsum dolor sit amet,</p>
              </div>
              <div class="card-footer">
                <small class="text-muted"></small>
              </div>
            </div>
          </div>

          <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-55">
              <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
              <div class="card_body">
                <h4 class="card_title">
                  <a href="#">Item Two</a>
                </h4>
                <h5>$24.99</h5>
                <p class="card-text">Lorem ipsum dolor sit amet,</p>
              </div>
              <div class="card-footer">
                <small class="text-muted"></small>
              </div>
            </div>
          </div>

          <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-55">
              <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
              <div class="card_body">
                <h4 class="card_title">
                  <a href="#">Item Two</a>
                </h4>
                <h5>$24.99</h5>
                <p class="card-text">Lorem ipsum dolor sit amet,</p>
              </div>
              <div class="card-footer">
                <small class="text-muted"></small>
              </div>
            </div>
          </div>

         <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-55">
              <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
              <div class="card_body">
                <h4 class="card_title">
                  <a href="#">Item Two</a>
                </h4>
                <h5>$24.99</h5>
                <p class="card-text">Lorem ipsum dolor sit amet,</p>
              </div>
              <div class="card-footer">
                <small class="text-muted"></small>
              </div>
            </div>
          </div>
          
          <div class="col-lg-3 col-md-6 mb-4">
            <div class="card h-55">
              <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
              <div class="card_body">
                <h4 class="card_title">
                  <a href="#">Item Two</a>
                </h4>
                <h5>$24.99</h5>
                <p class="card-text">Lorem ipsum dolor sit amet,</p>
              </div>
              <div class="card-footer">
                <small class="text-muted"></small>
              </div>
            </div>
          </div>

        </div>
        <!-- /.row -->

      </div>
      <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->
  
  
  <div class="container_right"></div>
  </div>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  
  <%@ include file="footer.jsp" %>
</body>
</html>