<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Askbootstrap">
<meta name="author" content="Askbootstrap">
<meta property="og:url"
	content="https://www.your-domain.com/your-page.html" />

<!-- facebook -->
<meta property="og:type" content="website" />
<meta property="og:title" content="PIND" />
<meta property="og:description" content="Your description" />
<meta property="og:image" content="icon/sns-line.png" />

<!-- kakao -->
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>

<!-- line -->
<script
	src="https://d.line-scdn.net/r/web/social-plugin/js/thirdparty/loader.min.js"
	async="async" defer="defer"></script>

<title>VIDOE - Video Streaming Website HTML Template</title>
<!-- Favicon Icon -->
<link rel="icon" type="image/png" href="img/favicon.png">
<!-- Bootstrap core CSS-->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<!-- Custom styles for this template-->
<link href="css/osahan.css" rel="stylesheet">
<!-- Owl Carousel -->
<link rel="stylesheet" href="vendor/owl-carousel/owl.carousel.css">
<link rel="stylesheet" href="vendor/owl-carousel/owl.theme.css">


<!-- Load Facebook SDK for JavaScript -->
<div id="fb-root"></div>
<script>(function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v3.0";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));</script>

<!-- 좋아요 관련 -->
<style>
.like {
	width: 4rem;
	height: 4rem;
}
</style>

<script>
var tag = ""; 

/*북마크 관련 */
function bookmark() {
	var video = document.getElementById('video');
    
	var current = video.currentTime;
	
	var currentmin = Math.floor(current / 60);
    var currentsec = Math.floor(current - (currentmin * 60));
    if (currentmin < 10) {
        currentmin = "0" + currentmin;
    }
    if (currentsec < 10) {
        currentsec = "0" + currentsec;
    }
    var currentTotal = currentmin + ":" + currentsec;
	
    tag += '<input type="button" value="'+currentTotal+'" class="bookmark btn btn-light border-none" onclick="javascript:time_click('+current+')">'
    
	$('#bookmark_time').html(tag);
    
}

function time_click(current) {
		video.currentTime = current;
}

/* 구독관련 */
function subscribe() {
	$('#subscribe_bt').attr('class', 'btn btn-danger');
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
            
            <li class="nav-item">
               <a class="nav-link" href="mychannel">
               <i class="fas fa-fw fa-user-alt"></i>
               <span>My Channel</span>
               </a>
            </li>
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
         

		<!-- 영상  -->
		<div id="content-wrapper">
			<div class="container-fluid pb-0">
				<div class="video-block section-padding">
					<div class="row">
						<div class="col-md-8">
							<div class="single-video-left">
								<div class="single-video">
									<!-- <iframe width="100%" height="315" src="./resources/video/video2.mp4" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe> -->
									  <input type="button" class="btn btn-outline-dark" value="History" onclick="javascript:history()">
									  <input type="hidden" id="playtime" value="${playtime}">
									
									<input type="button" class="btn btn-outline-dark"
										value="Bookmark" onclick="javascript:bookmark()"> <span
										id="bookmark_time"></span>
									<div id="bookmark_time"></div>

									<video id="video"
										src="videofile/${video.pind_video_savedfile}.mp4"
										autoplay controls width="100%" height="315" allowfullscreen
										style="background-color: black;"></video>


								</div>
								<div class="single-video-info-content box mb-3" style="height: 100px;">

									<div
										style="float: left;">
										<h4>
											${video.pind_video_Title}
										</h4>
										<!--  <div id="currentTime" class="current_time">00:00</div>
								  <div id="totalTime" class="total_time">00:00</div>
								  <div id="progress" class="progress" style="width:300px"><div class="bar" id="progressBar" style="width:0%;"></div></div> -->


										<p class="mb-0">
											<i class="fas fa-eye"></i> ${video.pind_video_Hits} views
										</p>
									</div>

									<!-- 영상 아래 (좋아요.싫어요.캡쳐 버튼)-->
								
										<div class="float-right">

											<table>
												<tr>
													<td><button id="snap" button class="btn btn-outline-dark"
													onclick="snap()">Take
															screenshot</button></td>
															
															
															
													<td><img src="icon/like.png" id="like" width="50rem"
														height="50rem" style="cursor: pointer" chk="n"> <span
														id="like_cnt"></span></td>

													<td id="dislikeCNT"></td>
													<td><img src="icon/dislike.png" id="dislike"
														width="50rem" height="50rem" style="cursor: pointer"
														chk="n"> <span id="dislike_cnt"></span></td>

												</tr>
											</table>

										<!--/.좋아요 싫어요 -->
									</div>
								</div><!--/. 비디오 제목 -->

								<div class="single-video-author box mb-3">
									<div class="float-right">
										<button class="btn btn-outline-danger btn-sm"
											id="subscribe_bt"
											style="width: 12rem; height: 2.4rem; font-size: 1rem"
											type="button" onclick="javascript:subscribe()">
											Subscribe <strong>1.4M</strong>
										</button>
										<button class="btn btn btn-outline-danger" type="button">
											<i class="fas fa-bell"></i>
										</button>
									</div>
									<img class="img-fluid" src="img/s4.png" alt="">
									<p>
										<a href="#"><strong>${video.pind_video_Nickname}
												Channel</strong></a> <span title="" data-placement="top"
											data-toggle="tooltip" data-original-title="Verified"><i
											class="fas fa-check-circle text-success"></i></span>
									</p>
									<small>Published on ${video.pind_video_Date}</small>
								</div>
								
								
								
								<div class="single-video-info-content box mb-3">
								<!-- SNS공유 -->
									<div>
										<div style="display: inline-block; top: 0px; float: right;">
										<img src="icon/sns-tw.png"
											onclick="javascript:sharetwitter('http://localhost:8888/pind/video-page?num=${video.pind_video_Num}', '트위터 공유하기!')"
											width="30px" height="30px" style="cursor: pointer">
										</div>
										<div style="display: inline-block; top: 0px; float: right;">
										<img src="icon/sns-fb.png" onclick="javascript:sharefacebook('http://localhost:8888/pind/video-page?num${video.pind_video_Num}')" width="30px" height="30px" style="cursor: pointer">
										</div>
										<div style="display: inline-block; top: 0px; float: right;">
										<a id="kakao-link-btn" href="javascript:;">
										<img src="//developers.kakao.com/assets/img/about/logos/kakaolink/kakaolink_btn_medium.png"
											width="30px" height="30px" />
										<input type="hidden" id="page_url" value="http://localhost:8888/pind/video-page?num=${video.pind_video_Num}"></a>
										</div>
										<div  style="display: inline-block; top: 0px; float: right;">
										<div class="line-it-button" data-lang="ko" data-type="share-b"
											data-ver="3"
											data-url="http://localhost:8888/pind/video-page?num=${video.pind_video_Num}"
											data-color="default" data-size="small" data-count="false"
											style="display: none;"></div>
										</div>
									</div>
								
									<h6>About :</h6>
									<pre>${video.pind_video_About}</pre>
									<h6>Category :</h6>
									<p class="tags mb-0">
										<span><a href="#">Uncharted 4</a></span>
									</p>

									
								</div>

								<!-- 코멘트폼 -->
                     <c:if test = "${ sessionScope.logId == null }">
						<table width="100%">
							<tr>
								<td width="15%">
									기본 프로필사진입니당
								</td>
								<td width="55%">
								   <textarea rows="3" cols="100%" readonly>댓글 작성은 로그인해야 가능합니다. </textarea>
							    </td>
							    <td>
									<input type="button" value="LOGIN" class="btn btn-outline-dark" style="width:100%; height:4rem" onclick="location.href ='login'">
								</td>
							</tr>
						</table>
					</c:if>	
                     
                           
					<c:if test = "${sessionScope.logId != null}" >	
						
						<form id="comment_form">
							<table>
								<tr>
									<td width="15%" align="center">
									 	<img width="50rem" height="50rem" src="profileImage/${sessionScope.logId}.png" onerror="this.src='profileImage/default2.png'">
									</td>
									<td width="50%">
									   <textarea name="pind_comment_Content" id="comment_content" rows="3" cols="100%"></textarea>
									   <input type="hidden" name= "pind_comment_Email" id="comment_Email" value="${sessionScope.logId}">
									</td>
									<td>
							  			<input type="button" id="comment_form_submit" class="btn btn-outline-dark" style="width:100%; height:4rem" value="SAVE">
									</td>
								</tr>
							</table>
						</form>
					</c:if>
				
								<!-- 글쓰기 출력 -->
						<div id="comment_list"></div>
						<input type="hidden" id="logNickname" value="${ sessionScope.logNickname }">
						<input type="hidden" id="logId" value="${ sessionScope.logId }">
						<input type="hidden" id="video_num" value="${ video.pind_video_Num }">
                           
                        </div>
                     </div>
                     
						<div class="col-md-4">
							<div class="single-video-right">
								<div class="row">
									<div class="col-md-12">
										<div class="adblock" id = "canvas_div" style="display: none;">
											<div class="img">
												<canvas id="canvassave"></canvas>
											</div>
										</div>
												<div id="result"></div>
										<div class="main-title">
											<div class="btn-group float-right right-action">
												<a href="#" class="right-action-link text-gray"
													data-toggle="dropdown" aria-haspopup="true"
													aria-expanded="false"> Sort by <i
													class="fa fa-caret-down" aria-hidden="true"></i>
												</a>
												<div class="dropdown-menu dropdown-menu-right">
													<a class="dropdown-item" href="#"><i
														class="fas fa-fw fa-star"></i> &nbsp; Top Rated</a> <a
														class="dropdown-item" href="#"><i
														class="fas fa-fw fa-signal"></i> &nbsp; Viewed</a> <a
														class="dropdown-item" href="#"><i
														class="fas fa-fw fa-times-circle"></i> &nbsp; Close</a>
												</div>
											</div>
											<h6>Up Next</h6>
										</div>
									</div>

									<div class="col-md-12">

									<!-- 다음 동영상들 -->
										<!-- 영상 배열 -->
										 <c:forEach var="i" items="${olist}"> 
											<div class="video-card video-card-list">
												<div class="video-card-image">
													<a class="play-icon" href="hits-up?num=${i.pind_video_Num}"><i
														class="fas fa-play-circle"></i></a> <a href="hits-up?num=${i.pind_video_Num}"><img
														class="img-fluid" style="width: 100%; height: 100%;"
														src="videoImage/${i.pind_video_Num}.png"
														alt=""></a>
												</div>
												<div class="video-card-body">
													<div class="btn-group float-right right-action">
														<a href="#" class="right-action-link text-gray"
															data-toggle="dropdown" aria-haspopup="true"
															aria-expanded="false"> <i class="fa fa-ellipsis-v"
															aria-hidden="true"></i>
														</a>
														<div class="dropdown-menu dropdown-menu-right">
															<a class="dropdown-item" href="#"><i
																class="fas fa-fw fa-star"></i> &nbsp; Top Rated</a> <a
																class="dropdown-item" href="#"><i
																class="fas fa-fw fa-signal"></i> &nbsp; Viewed</a> <a
																class="dropdown-item" href="#"><i
																class="fas fa-fw fa-times-circle"></i> &nbsp; Close</a>
														</div>
													</div>
													<div class="video-title">
														<a href="hits-up?num=${i.pind_video_Num}">${i.pind_video_Title}</a>
													</div>
													<div class="video-page text-success">
														Education <a title="" data-placement="top"
															data-toggle="tooltip" href="#"
															data-original-title="Verified"><i
															class="fas fa-check-circle text-success"></i></a>
													</div>
													<div class="video-view">
														${i.pind_video_Hits} views &nbsp;<i class="fas fa-calendar-alt"></i> ${i.pind_video_Date}
													</div>
												</div>
											</div>
										</c:forEach>

								
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /.container-fluid -->
			<!-- Sticky Footer -->
			<footer class="sticky-footer">
				<div class="container">
					<div class="row no-gutters">
						<div class="col-lg-6 col-sm-6">
							<p class="mt-1 mb-0">
								&copy; Copyright 2019 <strong class="text-dark">PIND</strong>.
								All Rights Reserved<br> </small>
							</p>
						</div>
						<div class="col-lg-6 col-sm-6 text-right">
							<div class="app">
								<a href="#"><img alt="" src="img/google.png"></a> <a
									href="#"><img alt="" src="img/apple.png"></a>
							</div>
						</div>
					</div>
				</div>
			</footer>
		</div>
		<!-- /.content-wrapper -->
	</div>
	<!-- /#wrapper -->
	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>
	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm modal-dialog-centered"
			role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
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
	<script src="js/comment-script.js"></script>
	<script src="js/like-dislike-script.js"></script>
	<script src="js/html2canvas.js"></script>
	<script src="js/history-script.js"></script>
	
<script type="text/javascript">

	//Get handles on the video and canvas elements
	var video = document.querySelector('video');
	var canvas = document.querySelector('canvas');
	// Get a handle on the 2d context of the canvas element
	var context = canvas.getContext('2d');
	// Define some vars required later
	var w, h, ratio;
	
	// Add a listener to wait for the 'loadedmetadata' state so the video's dimensions can be read
	video.addEventListener('loadedmetadata', function() {
		// Calculate the ratio of the video's width to height
		ratio = video.videoWidth / video.videoHeight;
		// Define the required width as 100 pixels smaller than the actual video's width
		w = video.videoWidth/6;
		// Calculate the height based on the video's width and the ratio
		h = parseInt(w / ratio, 10);
		// Set the canvas width and height to the values just calculated
		canvas.width = w;
		canvas.height = h;
	}, false);
	
	// Takes a snapshot of the video
	function snap() {
		
		var x = document.getElementById("canvas_div");
		  if (x.style.display === "none") {
		    x.style.display = "block";
		  } 
		  
			// Define the size of the rectangle that will be filled (basically the entire element)
			context.fillRect(0, 0, w, h);
			// Grab the image from the video
			context.drawImage(video, 0, 0, w, h);
			var binaryData = canvas.toDataURL("image/png");
			$.ajax({
				type : "post",
				data : {binaryData : binaryData},
				url : "${pageContext.request.contextPath}/imageCreate",
				dataType : 'json',
				error : function(request, status, error) {
					alert('검색실패');
					/* alert("code:" + request.status + "\n" + "message:"
							+ request.responseText + "\n" + "error:" + error); */
				},
				success : function(data) {
					if(data.length == 0){
						$('#result').html('<div style="text-align:center; width:100%; font-size:1rem;">Search Failed<br>Please Try Again</div>');
						return false;
					}
					var str = '<table style="margin:0px auto; text-align:left;"><tr><td colspan="2" style="font-size:1rem; padding-bottom:1rem;"><strong>Product List</strong></td></tr><tr>';

					for (var i = 0; i < data.length; i++) {
						str += '<td><button class="product btn btn-outline-dark" style="width:165px;" value="'+ data[i] +'">' + data[i] + '</button></td>';
						if(i>0 && ((i+1)%2)==0){
							str += '</tr><tr>'
						}else if(i == (data.length-1)){
							str += '</tr>'
						}
					}
					str += '</table><div id="searchResult"></div>';
					$('#result').html(str);
				}
			});
		}
		
		$(document).on('click','.product',function(){
			var searchText = $(this).attr('value');
			
			$.ajax({
				type : "post",
				data : {searchText : searchText},
				url : "${pageContext.request.contextPath}/searchProduct",
				dataType : 'json',
				success : function(data){
					var str = '<hr><h5>Search Result For <b>"' + searchText +'"<b></h5><br>';
					str += '<table style="background-color:white;">'
					
					for(var i =0; i < data.length; i++){
						
						str += '<tr style="border-bottom: 1px solid; border-color: rgba(0,0,0,0.3);"><td><a target="_blank" href='+data[i].productURL+'><img width="122px" height="90px" src='+ data[i].productImage+'></a></td>'
						str += '<td><a style="color:black;" target="_blank" href='+data[i].productURL+'>'+data[i].productTitle
						str += '<br><strong><span>▶▶최저가 : '+ data[i].productLPrice +'</span></a></strong></td></tr>';
					}
					str += '</table><hr>'
						$('#searchResult').html(str);
				}
			});
		});
</script>
</body>
</html>