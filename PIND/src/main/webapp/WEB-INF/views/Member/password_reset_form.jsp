<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 재설정</title>
<style type="text/css">

th{
	width:200px;
}
td{
	width:200px;
}



</style>
</head>
<body>

<div class = "container">

	<div class= "header">
	</div>	<!-- header -->
	
	
	<div class ="contents">
	
	<h1>비밀번호 재설정</h1>
	
	<form id="" action="/resetPW"  method="post" onsubmit="return formCheck();">
	<table>

		
		<tr>
		<th>새 비밀번호</th>
		<td><input type="password" name="reset_pw" id="reset_pw"></td>
		</tr>	
	
		<tr>
		<th>비밀번호 확인</th>
		<td><input type="password" id="reset_pw_check"></td>
		</tr>	
		
		<tr align="center">
		<td colspan="2"><input type="submit" name="bt_reset_pw" id="bt_reset_pw" value="확인"></td>
		</tr>
		
	</form>
	</table>

	</div><!-- contents -->
	
	<div class = "left-sidebar">
	
	</div><!--l-sidebar -->
	
	<div class = "right-sidebar">
	
	</div><!-- r-sidebar -->

	<div class = "footer">
	
	</div><!-- footer -->
	
</div><!-- container -->











</body>
</html>