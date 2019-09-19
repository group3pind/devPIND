/**
 * 
 */

	$(document).ready(btClick);
	$(document).ready(commentList);
	
	function btClick() {
		$('#comment_form_submit').on('click', insert);
	}
	
	function insert() {		
		var email = $('#comment_Email').val();
		var content = $('#comment_content').val();
		var num = $('#video_num').val();
		
		if ( content == '' ) {
			return;
		}
		
		content = content.replace(/(?:\r\n|\r|\n)/g, '<br/>');
		
		$.ajax ( {
			url : 'insertComment'
			, type : 'POST'
			, data : {pind_comment_Email:email, pind_comment_Content:content, pind_video_Num:num} /*$('#comment_form').serialize()*/
			, success : function () {
				$('#comment_content').val('');
				commentList();
			}
			, error : function () {
				alert('Failed to save comment');
			}	
		} );
	}
	
	//코멘트 리스트 보여주기 
	function commentList() {
		var num = $('#video_num').val();
		var nickname = $('#logNickname').val();
		
		$.ajax ( {
			url : 'showList?num='+num
			, type : 'GET'
			, dataType : 'JSON'
			, success : function(c) {
				
				var list = '<table width="100%" id="table1">'
						/*	+ '<tr>'
								+'<td width="15%">프로필 들어갈 자리</td>'
								+'<td>닉네임+내용</td>'
								+'<td>수정삭제</td>'
							+'</tr>'*/
				for (var i=0; i<c.length; i++) {
					list +=  
						'<tr class="alert alert-light">'
							+'<td align="center" width="10%">' + '<img width="50rem" height="50rem" src="profileImage/'+c[i].pind_image_savedfile+'">'+'</td>'
							+'<td width="70%"><strong>' +c[i].pind_comment_Email+ '</strong><br>'
							+'<div id="content'+c[i].pind_comment_Num+'">' +c[i].pind_comment_Content+ '</div></td>'
							/*+'<td> <div id="content'+c[i].pind_comment_Num+'">' +c[i].pind_comment_Content+ '</div></td>'*/
							
						if ( nickname.match(c[i].pind_comment_Email) ) {							
							list += '<td><span id="update_bt'+c[i].pind_comment_Num+'"><input type="button" value="update" class="btn btn-outline-secondary updateBt" num="'+c[i].pind_comment_Num+'" content="' +c[i].pind_comment_Content+ '"></span>'
							+'&nbsp;&nbsp;<input type="button" value="delete" class="btn btn-outline-secondary delBt" num="'+c[i].pind_comment_Num+'"></td>'
						}
						+'</tr>'
				}		
				list += '</table>'
				
				$('#comment_list').html(list);
				
				//생성된 버튼들의 클릭 이벤트처리
				$('.delBt').on('click', commentDel);
				$('.updateBt').on('click', updateForm);
			}
			, error : function(e) {
				alert(e.status);
			}
		} );
	}
	
	function commentDel () {
		var c = confirm('Do you want to delete your comment?');
		if ( c ) {
			//this가 가리키는 것은 지금 그 객체. 이 함수를 호출한 버튼!
			var num = $(this).attr('num');
			$.ajax ({
				url : 'deleteComment'
				, type : 'POST'
				, data : { num: num }
				, success : function () {
					alert('Comment deleted');
				    commentList();
				}
			});	
		} else {
			return false;
		}
	}
	
	function updateForm () {
		var num = $(this).attr('num');
		var content = $(this).attr('content');
		
		content = content.split('<br/>').join("\r\n");
		
		var tag = '<textarea id="content2" num="'+num+'" rows="3" cols="91%" >'+content+'</textarea><br><br>'
		var tag2 = '<input type="button" class="btn btn-secondary border-none updateFormBt" value="update">'
		
		$('#content'+num).html(tag);
		$('#update_bt'+num).html(tag2);
		$('#content2').focus();
				 
		$('.updateFormBt').on('click', update);
	}
	
	function update() {
		var num = $('#content2').attr('num');
		var content = $('#content2').val();
			
		content = content.replace(/(?:\r\n|\r|\n)/g, '<br/>');
		
		$.ajax({
			url : 'updateComment'
			, type : 'POST'
			, data : { pind_comment_Num:num, pind_comment_Content:content }
			, success : function() {
				commentList();
			}
			, error : function(e) {
				alert('Failed to update your comment')
			}
		});
	}
	