<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=request.getContextPath() %>">
<meta charset="utf-8">
<style>
.in{
	margin:30px;
	font-size:30px;
}
</style>
<title>注册</title>
</head>
<body style="background-color:pink">
<div style="margin-top:200px;margin-left:100px;background-color:gray;width:350px;height:300px;border-radius:10px">
<form action="register" method="post">
   <div class="in">
   	账户：<input type="text" name="account" style="height:25px;background-color:#AAAAAA;margin-bottom:10px;border:none">
   </div>
   <div class="in">
   	密码：<input type="password" name="pass" style="height:25px;background-color:#AAAAAA;margin-bottom:10px;border:none">
   </div>
   <div class="in">
   	确认：<input type="password" name="repass" style="height:25px;background-color:#AAAAAA;margin-bottom:10px;border:none">
   </div>
   <div class="in">
   <input type="submit" value='注册'  style="float:left;margin-left:100px;font-size:22px;border-radius:10px;"/>
   </div>
   </form>
 </div>
 <script type="text/javascript">
 
 </script>
</body>
</html>