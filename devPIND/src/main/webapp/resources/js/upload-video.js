$(document).ready(function(){
	$('.osahan-progress').hide();
	$('.osahan-desc').hide();
});
$(document).ajaxStart(function() {
	$('.osahan-progress').show();
	$('.osahan-desc').hide();
}).ajaxStop(function() {
	$('.osahan-progress').hide();
	$('.progress-bar').attr('aria-valuenow', '0').css('width','0%').text('0%');
	$('#selectFile').val('');
	$('.osahan-desc').show();
});

$("#selectFile").on('change',function (event) {
			event.preventDefault();

			var form = $('#videofrm')[0];
			// 콘솔에서 파일 정보 확인
			console.log(form);

			// ajax로 전달할 폼 객체
			var data = new FormData(form);

			$.ajax({
				type : "post",
				url : "uploadchk",
				data : data,
				dataType : "text",
				// processData: true => get방식, false => post방식
				processData : false,
				// contentType: true => application/x-www-form-urlencoded,
				// false => multipart/form-data
				contentType : false,
				timeout:30000,
				xhr : function() {
					var xhr = new window.XMLHttpRequest();
					xhr.upload.addEventListener('progress', function(e) {
						if (e.lengthComputable) {
							console.log('Bytes Loaded: ' + e.loaded);
							console.log('Total Size: ' + e.total);
							console.log('Percentage Uploaded: '	+ (e.loaded / e.total));
							var percent = Math.round((e.loaded / e.total) * 100);

							$('.progress-bar').attr('aria-valuenow', percent).css('width', percent + '%').text(percent + '%');
						}
					});
					$('.osahan-close').on('click', function(){
						if(xhr && xhr.readyState != 4){
				            xhr.abort()
				            $('.osahan-desc').text('업로드가 취소되었습니다.');
				            return false;
				        }
					});
					return xhr;
				},
				success : function(data) {
					$('.osahan-desc').text('Successfully Uploaded');
					var savedsplit = data.split('/');
					$('.fileinfo').html('<input type="hidden" id= "msg" name="pind_video_savedfile" value="'+savedsplit[1]+'">');
				},
				error : function(){
				}
			});
		});





function uploadImage(input) {
	  if (input.files && input.files[0]) {
	    var reader = new FileReader();
	    
	    reader.onload = function(e) {
	      $('.videoImg').html('<img src="'+e.target.result+'" width="200px" height="120px">');      
	    }
	    
	    reader.readAsDataURL(input.files[0]);
	  }
	}
