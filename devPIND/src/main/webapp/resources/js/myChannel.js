/**
 * myChannel.jsp의 자바스크립트
 * My Videos, My Favorites, Subscriptions, Settings 링크를 눌렀을때 페이지 하단 출력 항목 변경 
 * id --> tab-1,tab-2,tab-3,tab-4
 */

	$(document).ready(function() {


            
            $(document).ready(function(){
            	   
            	  $('ul.tabs li').click(function(){
            	    var tab_id = $(this).attr('data-tab');
            	 
            	    $('ul.tabs li').removeClass('active');
            	    $('.tab-content').removeClass('current');
            	 
            	    $(this).addClass('active');
            	    $("#"+tab_id).addClass('current');
            	  })
            	 
            	})
           
        });