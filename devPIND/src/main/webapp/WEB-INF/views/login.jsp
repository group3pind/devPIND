<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <meta name="description" content="Askbootstrap">
      <meta name="author" content="Askbootstrap">
      <title>VIDOE - Video Streaming Website HTML Template</title>
      <!-- Favicon Icon -->
      <link rel="icon" type="image/png" href="img/favicon.png">
      <!-- Bootstrap core CSS-->
      <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
      <!-- Custom fonts for this template-->
      <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
      <!-- Custom styles for this template-->
      <link href="css/osahan.css" rel="stylesheet">
      <!-- Owl Carousel -->
      <link rel="stylesheet" href="vendor/owl-carousel/owl.carousel.css">
      <link rel="stylesheet" href="vendor/owl-carousel/owl.theme.css">
   </head>
   <body class="login-main-body">
      <section class="login-main-wrapper">
         <div class="container-fluid pl-0 pr-0">
            <div class="row no-gutters">
               <div class="col-md-5 p-5 bg-white full-height">
                  <div class="login-main-left">
                     <div class="text-center mb-5 login-main-left-header pt-4">
                        <img src="img/favicon.png" class="img-fluid" alt="LOGO">
                        <h5 class="mt-3 mb-3">Welcome to PIND</h5>
                        <p></p>
                     </div>
                     
                    <!-- 로그인 폼 -->
                     <form action="login2" method="POST" onsubmit="return login_submit();">
                        <div class="form-group">
                           <label>Email</label>
                           <input type="text" class="form-control" placeholder="Enter Email" name="email" id="login_email">
                        </div>
                        <div class="form-group">
                           <label>Password</label>
                           <input type="password" class="form-control" placeholder="Password" name="pass" id="login_pw">
                        </div>
                        <div class="mt-4">
                           <div class="row">
                              <div class="col-12">
                                 <button type="submit" class="btn btn-outline-primary btn-block btn-lg">Sign In</button>
                              </div>
                           </div>                           
                        </div>
                     </form>
                     <div class="text-center mt-5">
                       <p>${logMessage}</p>
                        <p class="light-gray">Don’t have an account? <a href="register">Sign Up</a></p>
                     </div>
                  </div>
               </div>
               
               <div class="col-md-7">
                  <div class="login-main-right bg-white p-5 mt-5 mb-5">
                     <div class="owl-carousel owl-carousel-login">
                        <div class="item">
                           <div class="carousel-login-card text-center">
                           <br><br>
                              <img src="img/login.png" class="img-fluid" alt="LOGO">
                              <br><br><br>
                              <h5 class="mt-5 mb-3">​Welcome Back</h5>
                              <p class="mb-4">Share your videos with friends, family, and the world </p>
                           </div>
                        </div>
                        <div class="item">
                           <div class="carousel-login-card text-center">
                              <img src="img/login2.png" class="img-fluid" alt="LOGO">
                              <h5 class="mt-5 mb-3">Express Yourself</h5>
                              <p class="mb-4"></p>
                           </div>
                        </div>
                        <div class="item">
                           <div class="carousel-login-card text-center">
                              <img src="img/login3.png" class="img-fluid" alt="LOGO">
                              <h5 class="mt-5 mb-3">Collaborate and Share</h5>
                              <p class="mb-4"></p>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               
            </div>
         </div>
      </section>
      <!-- Bootstrap core JavaScript-->
      <script src="vendor/jquery/jquery.min.js"></script>
      <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
      <!-- Core plugin JavaScript-->
      <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
      <!-- Owl Carousel -->
      <script src="vendor/owl-carousel/owl.carousel.js"></script>
      <!-- Custom scripts for all pages-->
      <script src="js/custom.js"></script>
      <script src="js/login-script.js"></script>
   </body>
</html>