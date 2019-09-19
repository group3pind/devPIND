/**
 * 
 */


//twitter
function sharetwitter(url, text) {
	window.open("http://twitter.com/intent/tweet?text=" + text + "&url=" + url);
}

//facebook
function sharefacebook (url) {
	window.open("http://www.facebook.com/sharer/sharer.php?u=" + url);
}

/*
function (d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v3.0";
  fjs.parentNode.insertBefore(js, fjs);
} (document, 'script', 'facebook-jssdk'));*/

var url = $('#page_url').val();

//<![CDATA[
// // 사용할 앱의 JavaScript 키를 설정해 주세요.
Kakao.init('61ca70b54dd0af0ed5fe177df1c0c760');
// // 카카오링크 버튼을 생성합니다. 처음 한번만 호출하면 됩니다.
Kakao.Link.createDefaultButton({
  container: '#kakao-link-btn',
  objectType: 'feed',
  content: {
    title: '',
    description: '',
    imageUrl: '',
    link: {
/*      mobileWebUrl: 'https://developers.kakao.com',*/
      webUrl: url
    }
  },
/*  social: {
    likeCount: 286,
    commentCount: 45,
    sharedCount: 845
  },*/
  buttons: [
   /* {
      title: '웹으로 보기',
      link: {
        mobileWebUrl: 'https://developers.kakao.com',
        webUrl: 'https://developers.kakao.com'
      }
    },*/
    {
      title: '앱으로 보기',
      link: {
        mobileWebUrl: url
        /*webUrl: 'https://developers.kakao.com'*/
      }
    }
  ]
});
//]]>