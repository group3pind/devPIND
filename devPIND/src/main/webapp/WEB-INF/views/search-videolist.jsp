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
      <title>PIND</title>
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
      <link href="css/mychannel.css" rel="stylesheet">
      
      <script>
	function displayNone(num) {
		$('.show-video'+num).css('display', 'none');
	}
	
	function prosubmit(){
		   $('#profrm').submit();
		   setTimeout(function(){
			   alert('Profile Update!');
			   location.reload();
		   }, 1000);
	   }
	</script>
      
   </head>
   <body id="page-top">
   
      <nav class="navbar navbar-expand navbar-light bg-white static-top osahan-nav sticky-top">
         &nbsp;&nbsp; 
         <button class="btn btn-link btn-sm text-secondary order-1 order-sm-0" id="sidebarToggle">
         <i class="fas fa-bars"></i>
         </button> &nbsp;&nbsp;
         <a class="navbar-brand mr-1" href="index"><img class="img-fluid" alt="" src="img/logo.png"></a>
         
             <!-- Navbar Search -->
         <form id="main_searchform" action="main-search" method="GET" class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-5 my-2 my-md-0 osahan-navbar-search">
            <div class="input-group">
               <input type="text" class="form-control" name="main_search" placeholder="Search for...">
               <input type="hidden" name="sort" value="default">
               <div class="input-group-append">
                  <button class="btn btn-light" type="submit">
                  <i class="fas fa-search"></i> 
                  </button>
               </div>
            </div>
         </form>
           <!-- Navbar -->
         <ul class="navbar-nav ml-auto ml-md-0 osahan-right-navbar">
               
              <!-- 로그인 전 화면단 -->
               <c:if test="${sessionScope.logId == null }">
		             <li class="nav-item mx-1">
		               <a class="nav-link" href="upload">
		               <i class="fas fa-plus-circle fa-fw"></i>
		               Upload Video
		               </a>
		            </li>
		            <li class="nav-item mx-1">
		               <a class="nav-link" href="register">
		               <i class="fas fa-plus-circle fa-fw"></i>
		               join
		               </a>
		            </li>
		            <li class="nav-item mx-1">
		               <a class="nav-link" href="login">
		               <i class="fas fa-plus-circle fa-fw"></i>
		               login
		               </a>
		            </li>
               </c:if>
               
               <!-- 로그인 후 화면단 -->
               <c:if test="${sessionScope.logId != null }">
		            <li class="nav-item mx-1">
		               <a class="nav-link" href="upload">
		               <i class="fas fa-plus-circle fa-fw"></i>
		               Upload Video
		               </a>
		            </li>
		            <li class="nav-item dropdown no-arrow mx-1">
		               <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		               <i class="fas fa-bell fa-fw"></i>
		               <span class="badge badge-danger" id="alert"></span>
		               </a>
		               <div class="dropdown-menu dropdown-menu-right" aria-labelledby="alertsDropdown">
		                  <a class="dropdown-item" href="#"><i class="fas fa-fw fa-check-circle"></i>&nbsp; New Subscribe <br><strong style="color: #f5c518;">'Kyungmi's'</strong>channel</a>
		                  <div class="dropdown-divider"></div>
		                  <a class="dropdown-item" href="#" id = "close_alarm" onclick="javascript:close_alarm()" ><i class="fas fa-fw fa-times-circle"></i> &nbsp; Close</a>
		               </div>
		            </li>
		            <li class="nav-item dropdown no-arrow mx-1">
		               <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		               <i class="fas fa-envelope fa-fw"></i>
		               <span class="badge badge-success">3</span>
		               </a>
		               <div class="dropdown-menu dropdown-menu-right" aria-labelledby="messagesDropdown">
		                  <a class="dropdown-item" href="#"><i class="fas fa-fw fa-reply"></i> &nbsp;<strong>Akari</strong>&nbsp; Can you confirm...</a>
		                  <a class="dropdown-item" href="#"><i class="fas fa-fw fa-reply"></i> &nbsp;<strong>ToraZzang</strong>&nbsp; I noticed that...</a>
		                  <a class="dropdown-item" href="#"><i class="fas fa-fw fa-reply"></i> &nbsp;<strong>syPark</strong>&nbsp; Hi, do you mind...</a>
		                  <div class="dropdown-divider"></div>
		                  <a class="dropdown-item" href="#"><i class="fas fa-fw fa-times-circle"></i> &nbsp; Close</a>
		               </div>
		            </li>
		            <li class="nav-item dropdown no-arrow osahan-right-navbar-user">
		               <a class="nav-link dropdown-toggle user-dropdown-link" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		               <img src="profileImage/${sessionScope.logId}.png" onerror="this.src='profileImage/default.png'">
		               ${sessionScope.logNickname}
		               </a>
		               <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
		                  <a class="dropdown-item" href="account"><i class="fas fa-fw fa-user-circle"></i> &nbsp; My Account</a>
		                  <a class="dropdown-item" href="subscriptions"><i class="fas fa-fw fa-video"></i> &nbsp; Subscriptions</a>
		                  <form action="profile" method="POST"
								enctype="multipart/form-data" id="profrm">
								
								<input type="file" accept="image/*" style="display: none;" id="selectpro" name="upload" onchange="prosubmit()" value="">
								<input type="hidden" name="logId" value="${ sessionScope.logId }">
							</form>
		                  
		                  <a class="dropdown-item"><label for="selectpro" id="lb-selFile" style="cursor: pointer;"><i class="fas fa-fw fa-cog"></i>&nbsp; Update Profile</label></a>
		                  <div class="dropdown-divider"></div>
		                  <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal"><i class="fas fa-fw fa-sign-out-alt"></i> &nbsp; Logout</a>
		               </div>
		            </li>
             	</c:if>
         </ul>
         
      </nav>
      <div id="wrapper">
         <!-- Sidebar -->
         <ul class="sidebar navbar-nav">
            <li class="nav-item active">
               <a class="nav-link" href="index">
               <i class="fas fa-fw fa-home"></i>
               <span>Home</span>
               </a>
            </li>
            <!-- <li class="nav-item">
               <a class="nav-link" href="channels">
               <i class="fas fa-fw fa-users"></i>
               <span>Channels</span>
               </a>
            </li> --> <!-- 메뉴 channels 버튼 -->
            <li class="nav-item">
               <a class="nav-link" href="mychannel">
               <i class="fas fa-fw fa-user-alt"></i>
               <span>My Channel</span>
               </a>
            </li>
            <!-- <li class="nav-item">
               <a class="nav-link" href="video-page">
               <i class="fas fa-fw fa-video"></i>
               <span>Video Page</span>
               </a>
            </li> --> <!-- 사이드메뉴 video page -->
            <li class="nav-item">
               <a class="nav-link" href="upload-video">
               <i class="fas fa-fw fa-cloud-upload-alt"></i>
               <span>Upload Video</span>
               </a>
            </li>

            <li class="nav-item">
               <a class="nav-link" href="history-page">
               <i class="fas fa-fw fa-history"></i>
               <span>History Page</span>
               </a>
            </li>
            <li class="nav-item">
               <a class="nav-link" href="mostViewed">
               <i class="fas fa-fw fa-fire"></i>
               <span>Most Viewed</span>
               </a>
            </li>
            <li class="nav-item">
               <a class="nav-link" href="myFavorite">
               <i class="fas fa-fw fa-star"></i>
               <span>My Favorite</span>
               </a>
            </li>
            <li class="nav-item channel-sidebar-list">
               <h6>CATEGORIES</h6>  
               <ul> 
					<li><a href="#"><i class="fas fa-fw fa-music"></i> MUSIC</a></li>
					<li><a href="#"><i class="fas fa-fw fa-football-ball"></i> SPORTS</a></li>
					<li><a href="#"><i class="fas fa-fw fa-film"></i> MOVIE</a></li>
					<li><a href="#"><i class="fas fa-fw fa-theater-masks"></i> DRAMA</a></li>
					<li><a href="#"><i class="fas fa-fw fa-newspaper"></i> NEWS</a></li></ul>
			</li>
         </ul>
         <!-- 이 밑으로는 contents -->
         
         <!--비디오 검색 결과-->        
         <div id="content-wrapper">
            <div class="container-fluid pb-0">
            <!-- sort by 버튼 영역 -->
            <div>
            	 <div class="main-title">
                           <div class="btn-group float-right right-action">
                              <a href="#" class="right-action-link text-gray" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                              Sort by <i class="fa fa-caret-down" aria-hidden="true"></i>
                              </a>
							<div class="dropdown-menu dropdown-menu-right">
								<a class="dropdown-item" href="main-search?sort=like&main_search=${main_search}"><i class="fas fa-fw fa-star"></i> &nbsp; Top Rated</a>
								<a class="dropdown-item" href="main-search?sort=hits&main_search=${main_search}"><i class="fas fa-fw fa-signal"></i> &nbsp; Viewed</a>
								<a class="dropdown-item" href="#"><i class="fas fa-fw fa-times-circle"></i> &nbsp; Close</a>
							</div>
						</div>
                        </div>
            </div>
               <div class="video-block section-padding">
              
							 <c:forEach var="i" items="${vlist}">  
                                 <div class="video-card video-card-list">
                                    <div class="video-card-image" style = "width:230px; height: 140px;">
                                       <a class="play-icon" href="hits-up?num=${i.pind_video_Num}"><i class="fas fa-play-circle"></i></a>
                                       <a href="hits-up?num=${i.pind_video_Num}"><img class="img-fluid" src="http://img.youtube.com/vi/-46_SJnVd5g/hqdefault.jpg" alt=""></a>
                                    </div>
                                    <div class="video-card-body">
                                       <div class="btn-group float-right right-action">
                                          <a href="#" class="right-action-link text-gray" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                          <i class="fa fa-ellipsis-v" aria-hidden="true"></i>
                                          </a>
                                          <div class="dropdown-menu dropdown-menu-right">
                                             <a class="dropdown-item" href="#"><i class="fas fa-fw fa-star"></i> &nbsp; Top Rated</a>
                                             <a class="dropdown-item" href="#"><i class="fas fa-fw fa-signal"></i> &nbsp; Viewed</a>
                                             <a class="dropdown-item" href="#"><i class="fas fa-fw fa-times-circle"></i> &nbsp; Close</a>
                                          </div>
                                       </div>
                                       <div class="video-title">
                                          <a href="hits-up?num=${i.pind_video_Num}" style = "font-size:2rem;"><h3>${i.pind_video_Title}</h3></a>
                                       </div>
                                       <div class="video-page text-success" style = "font-size:14px; ">
                                       </div>
                                       <div class="video-view" style = "font-size:14px; ">
                                          <h5 style="font-weight: normal;">${i.pind_video_Hits} views &nbsp;<i class="fas fa-calendar-alt"></i> ${i.pind_video_Date}</h5>
                                       </div>
                                       <div class="video-view">
                                          <h5 style="font-weight: normal;"><pre>${i.pind_video_About}</pre></h5>
                                       </div>
                                    </div>
                                 </div><hr>
                              </c:forEach>  
							 
                           </div>
                        </div>
                     </div>
                  </div>
   
            <!-- /.container-fluid -->
            
         </div>
         <!-- /.content-wrapper -->
      </div>
      <!-- /#wrapper -->
      <!-- Scroll to Top Button-->
      <a class="scroll-to-top rounded" href="#page-top">
      <i class="fas fa-angle-up"></i>
      </a>
      <!-- Logout Modal-->
      <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
         <div class="modal-dialog modal-sm modal-dialog-centered" role="document">
            <div class="modal-content">
               <div class="modal-header">
                  <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                  <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">×</span>
                  </button>
               </div>
               <div class="modal-body">Select "Logout" below if you are ready to leave.</div>
               <div class="modal-footer">
                  <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                  <a class="btn btn-primary" href="logout">Logout</a>
               </div>
            </div>
         </div>
      </div>
      <!-- Bootstrap core JavaScript-->
      <script src="vendor/jquery/jquery.min.js"></script>
      <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
      <!-- Core plugin JavaScript-->
      <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
      <!-- Owl Carousel -->
      <script src="vendor/owl-carousel/owl.carousel.js"></script>
      <!-- Custom scripts for all pages-->
      <script src="js/custom.js"></script>
      <script src="js/sns-script.js"></script>
      
   </body>
</html>