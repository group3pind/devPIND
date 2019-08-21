<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="./resources/vendor/jquery/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('ul.tab li').click(function() {
			var activeTab = $(this).attr('data-tab');
			$('ul.tab li').removeClass('current');
			$('.tabcontent').removeClass('current');
			$(this).addClass('current');
			$('#' + activeTab).addClass('current');
		});
	})

</script>

<style type="text/css">
#container {
	width: 960px;
	margin: 0 auto;
	text-align: center;
}

.tab {
	list-style: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
}
/* Float the list items side by side */
.tab li {
	float: left;
}
/* Style the links inside the list items */
.tab li a {
	display: inline-block;
	color: #000;
	text-align: center;
	text-decoration: none;
	padding: 14px 16px;
	font-size: 17px;
	transition: 0.3s;
}
/* Style the tab content */
.tabcontent {
	display: none;
	background-color: rgb(0, 154, 200);
	padding: 6px 12px;
	color: #fff;
}

ul.tab li.current {
	background-color: rgb(0, 154, 200);
	color: #222;
	border-radius: 15px 15px 0px 0px;
}

.tabcontent.current{
	display: block;
	border-radius: 0px 15px 15px 15px;
}
</style>

</head>
<body>
	<div id="container">
		<ul class="tab">
			<li class="current" data-tab="tab1"><a href="#">ID 찾기</a></li>
			<li data-tab="tab2"><a href="#">PW 찾기</a></li>
		</ul>

		<div id="tab1" class="tabcontent current">
			<table>
				<tr>
					<td><label for="findid_name"><span>Name</span></label></td>
					<td><input id="findid_name"></td>
				</tr>
				<tr>
					<td><label for="findid_email"><span>E-Mail</span></label></td>
					<td><input id="findid_email"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" id="findid_bt_submit"
						value="확인"></td>
				</tr>
			</table>
		</div>

		<div id="tab2" class="tabcontent" style="border-radius: 15px">
			<table>
				<tr>
					<td><label for="findid_id"><span>ID</span></label></td>
					<td><input id="findid_id"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" id="findid_bt_submit"
						value="확인"></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>