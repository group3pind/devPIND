/**
 * 
 */

$(document).ready(function(){
	var video = document.getElementById('video');
	var playtime = $('#playtime').val();

		if ( playtime != "null" ) {
			var current = playtime;
			
			var currentmin = Math.floor(current / 60);
		    var currentsec = Math.floor(current - (currentmin * 60));
		    if (currentmin < 10) {
		        currentmin = "0" + currentmin;
		    }
		    if (currentsec < 10) {
		        currentsec = "0" + currentsec;
		    }
		    var currentTotal = currentmin + ":" + currentsec;
			
			if (confirm('Continue from '+currentTotal+'?')) {
				video.currentTime = playtime;
			}
		}
});

/*추가 : 히스토리*/
function history() {
	var video = document.getElementById('video');
    
	var current = video.currentTime;
	var total = video.duration;
	var logId = $('#logId').val();
	var videoNum = $('#video_num').val();
	
	$.ajax ( {
		url : 'insertHistory'
		, type : 'POST'
		, data : {pind_mem_Email:logId, pind_video_Num:videoNum, pind_history_Current:current, pind_history_Total:total} 
		, success : function () {
			alert('History saved');
		}
		, error : function () {
			alert('Failed to save history');
		}	
	} );
}


