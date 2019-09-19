/**
 * 
 */

	$(document).ready(bt_click);
	$(document).ready(like_cnt);
	
	
	function bt_click () {
		$('#like').on('click', like);
		$('#dislike').on('click', dislike);
	/*	$('#subscribe_bt').on('click', subscribe);*/
	}
	
	var num = $('#video_num').val();
	var id = $('#logId').val();
	
	
	function like_cnt() {
		$.ajax ( {
			url : 'like-cnt'
		    , data : { num : num } 
			, type : 'POST'
			, dataType : 'JSON'
			, success : function (s) {
				$('#like_cnt').html(s.pind_mediaeval_like)
				$('#dislike_cnt').html(s.pind_mediaeval_dislike)
			}
		});
	}
	
	function like() {
	
		var chk = $('#like').attr('chk');
		var chk2 = $('#dislike').attr('chk');
		

		if ( chk == 'n' && chk2 == 'n') {
			
			$.ajax ( {
				url : 'like-up'
					, type : 'POST'
					, data : { num : num, id : id } 
					, success : function () {
						like_cnt();
						$('#like').attr('chk', 'y');
						$('#like').addClass('like');
					}
					, error : function () {
						alert('좋아요 실패하였습니다.');
					}	
				} );
		} if ( chk == 'y' ) {
			
			$.ajax ( {
				url : 'like-down'
					, type : 'POST'
					, data : { num : num, id : id } 
					, success : function () {
						like_cnt();
						$('#like').attr('chk', 'n');
						$('#like').removeClass('like');
					}
					, error : function () {
						alert('좋아요 실패하였습니다.');
					}	
				} );
		}

	}
	
	
	function dislike() {
		var chk = $('#like').attr('chk');
		var chk2 = $('#dislike').attr('chk');
		
		if ( chk == 'n' && chk2 == 'n' ) {
			
			$.ajax ( {
				url : 'dislike-up'
					, type : 'POST'
					, data : { num : num, id : id } 
					, success : function () {
						like_cnt();
						$('#dislike').attr('chk', 'y');
						$('#dislike').addClass('like');
					}
					, error : function () {
						alert('싫어요 실패하였습니다.');
					}	
				} );
		}
		
		if ( chk2 == 'y' ) {
			
			$.ajax ( {
				url : 'dislike-down'
					, type : 'POST'
					, data : { num : num, id : id } 
					, success : function () {
						like_cnt();
						$('#dislike').attr('chk', 'n');
						$('#dislike').removeClass('like');
					}
					, error : function () {
						alert('싫어요 실패하였습니다.');
					}	
				} );
		}
	}
	
	

	

	
	