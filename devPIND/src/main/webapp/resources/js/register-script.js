/**
 * 
 */

$(document).ready(type_check);

var e_verify = 'n';
var p_verify = 'n';
var p2_verify = 'n';
var n_verify = 'n';

function type_check() {
	
	////아이디 중복&형식
	$('#join_email').keyup( function () {
		var email = $(this).val();
		/*var emailRegex = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;*/
		var emailRegex = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
		
		if ( !emailRegex.test(email) || email == '') {		
			$('.checkDivText').html('Invalid Email address');
			e_verify = 'n';
		} else {
				$.ajax({
					url : 'checkId'
					, type : 'POST'
					, data : { email : email }
					, dataType : 'text'
					, success : function (s) {
						if ( s.match('useable') ) {
							$('.checkDivText').css('color', 'green');
							$('.checkDivText').html('Verified');
							e_verify = 'y';
						} else {
							$('.checkDivText').css('color', 'red');
							$('.checkDivText').html('This Email address already exists');
							e_verify = 'n';
						}
					}
					, error : function (e) {
						alert(JSON.stringfy(e));
					}
				});//ajax
		}
	});//keyup
	
	
	//비밀번호 형식		
		$('#join_pw').keyup( function () {
			var pw = $(this).val();
			var pwRegex = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/;
			
			if( !pwRegex.test(pw) || pw == '') {
				$('.checkDivText2').css('color', 'red');
				$('.checkDivText2').html('At least One Alphabet, Number, Special character<br> without blank space(8~16)');
				p_verify = 'n';
			} else {
				$('.checkDivText2').css('color', 'green');
				$('.checkDivText2').html('Verified'); 
				p_verify = 'y';
			}
		});//keyup
		
		
	//비밀번호 확인
		$('#join_pw2').keyup ( function () {
			var pw1 = $('#join_pw').val();
			var pw2 = $(this).val();
			
			if ( pw1 != pw2 || pw2 == '') {
				$('.checkDivText3').css('color', 'red');
				$('.checkDivText3').html('Password does not match');
				p2_verify = 'n';
			} else {
				$('.checkDivText3').css('color', 'green');
				$('.checkDivText3').html('Verified');
				p2_verify = 'y';
			}
			
		});//keyup
		
		
	//닉네임 확인	
		$('#join_nickname').keyup ( function () {
			var nickname = $(this).val();
			var nicknameRegex =  /^[\w\Wㄱ-ㅎㅏ-ㅣ가-힣]{2,10}$/;
				
			if ( !nicknameRegex.test(nickname) || nickname == '' || /\s/g.test(nickname) ) {
				$('.checkDivText4').css('color', 'red');
				$('.checkDivText4').html('(length : 2~10) without blank space');
				n_verify = 'n';
			} else {
				$.ajax({
					url : 'checkNickname'
					, type : 'POST'
					, data : { nickname : nickname }
					, dataType : 'text'
					, success : function (s) {
						if ( s.match('useable') ) {
							$('.checkDivText4').css('color', 'green');
							$('.checkDivText4').html('Verified');
							n_verify = 'y';
						} else {
							$('.checkDivText4').css('color', 'red');
							$('.checkDivText4').html('This Nickname already exists');
							n_verify = 'n';
						}
					}
					, error : function (e) {
						alert(JSON.stringfy(e));
					}
				});//ajax
			}
		});		
}//::END
	

function join_submit() {
	
	if (e_verify.match('y') && p_verify.match('y') && p2_verify.match('y') && n_verify.match('y')) {
		return true;
	} else {
		return false;
	}
}//::END