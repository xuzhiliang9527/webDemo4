<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="<%=request.getContextPath()%>">
<style type="text/css">
#bg{
  background: linear-gradient(45deg, #45613a, #4accc1);
  height: 100%;
  display: block;
  }
</style>
<script src="/webDemo4/js/jquery-3.4.1.js"></script>
<title>登陆失败</title>
<script type="text/javascript">
$(document).ready(function(){
	var time = 4;
	setTimeout(function() {
		window.location = "/webDemo4/html/index.html";
	}, 5000);
	setInterval(function() {
		$("#showTime").html(time+"s后自动返回登陆界面");time--;
	}, 1000);
});
</script>
</head>
<body id="bg">
<h1 style="margin-left:300px;margin-top:400px">登陆失败！<br/></h1>
<h1 style="margin-left:300px;" id="showTime">5s后自动返回登陆界面</h1>
</body>
</html>