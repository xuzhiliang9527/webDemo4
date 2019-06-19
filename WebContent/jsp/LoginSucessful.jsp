<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="<%=request.getContextPath()%>">
<style type="text/css">
#bg{
  background: linear-gradient(45deg, #12346a, #f4566c);
  height: 100%;
  display: block;
  }
</style>
<script src="/webDemo4/js/jquery-3.4.1.js"></script>
<title>登陆成功</title>
<script type="text/javascript">
	$(document).ready(function(){
		var time = 4;
		setTimeout(function() {
			window.location = "/webDemo4/jsp/userOnlinePage.jsp";
		}, 5000);
		setInterval(function() {
			$("#showTime").html(time+"s后自动跳转到用户界面");time--;
		}, 1000);
	});
</script>
</head>
<body id="bg">
<h1 style="margin-left:300px;margin-top:400px">登陆成功！<br/></h1>
<h1 style="margin-left:300px;" id="showTime">5s后自动跳转到用户界面</h1>
</body>
</html>