<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.woniuxy.DAO.PO.TeacherPO,com.woniuxy.DAO.PO.StudentsPO,java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<base href="<%=request.getContextPath()%>">
<head>
<style type="text/css">
#bg{
  background: linear-gradient(45deg, #211136, #bf5853);
  height: 100%;
  display: block;
  }
 #h1_showInfo{
  background-color:yellow;
  margin-bottom: 0px;
  width:80%;
  margin-left:auto;
  margin-right:auto;
 
 }
 #showStudentsInfo{
 font-family:微软雅黑;
 width:80%; 
 margin-left: auto;
 margin-right: auto;
 font-size:24px;
 	<c:if test="${empty requestScope.flag }">
 	display:none;
 	</c:if>
 background-color:yellow;
 margin-top:0px;
 }
 #show{
 font-family:微软雅黑;
 width:80%; 
 margin-left: auto;
 margin-right: auto;
 font-size:24px;
 background-color:yellow;
 margin-top:20px;
 }
 .del{
 background: #3390FF;
 color:white;
 width:100px;
 border-radius:10px;
 font-size:16px;
 margin-left:30px;
 }
 #end{
 width:80%;
 text-align:center;
 margin-top:30px;
 margin:auto;
 }
 .crud{
 float:left;
 }
 .btn{
 width:50x;
 height:100%;
 background-color:blue;
 color:white;
 }
</style>
<script src="/webDemo4/js/jquery-3.4.1.js"></script>
<script src="/webDemo4/js/userOnlinePage.js"></script>
<meta charset="UTF-8">
<%--获取用户对象 --%>
<title>欢迎用户<c:out value="${sessionScope.teacher.name}" default="-----请重新登陆！"></c:out></title>
</head>
<body id="bg">
<script>
	//jQuery入口
	$(document).ready(function() {
		//点击缓慢开关学生信息动画
            $("#h1_showInfo").click(function() {
                $("#showStudentsInfo").slideToggle("slow", function() {
                });
            });
		//底部显示在线时间
        showCurrentTime();
        var currentTime = 1;
        function showCurrentTime() {
        	setInterval(function() {
        		$("#showCurrentTime").html("在线时间：" + currentTime + "s");
        		currentTime++;
                }, 1000)
        }
	});
	//删除学生信息
	function dropValues(){
		//获取多选框的值
	    obj = document.getElementsByName("studentInfo");
	    for(k in obj){
	        if(obj[k].checked){
	        	//尝试以异步的get方式访问dropServlet
	        	var stuName = obj[k].value;
	    		alert("确认删除："+ stuName +"?");
	    		//path
	    		var url = "webDemo4/drop?oper=drop&sname="+stuName;
	    		//向服务器发送请求
	    		$.get(url,function(data){
	    			$("#show").html(data);
	    		});
	        }
	    }
	}
	//增加学生信息
	function addValues(){
	    var name = $("#stuName").val();
	    var sex = $("#stuSex").val();
	    var age = $("#stuAge").val();
	    var addr = $("#stuAddr").val();
	    //尝试以异步的get方式访问dropServlet
	    var url = "webDemo4/drop?oper=add&sname="+name+"&"+"ssex="+sex+"&"+"sage="
	    		+age+"&"+"saddress="+addr;
	    $.get(url,function(data){
			$("#show").html(data);
		});
	}
	//修改学生信息
	function modifyValues(){
		   var name = $("#stuName").val();
		    var sex = $("#stuSex").val();
		    var age = $("#stuAge").val();
		    var addr = $("#stuAddr").val();
		    createXmlHttpRequest();
		    alert("修改学生信息:"+name);
		    //尝试以异步的get方式访问dropServlet
		    var url = "webDemo4/drop?oper=modify&sname="+name+"&"+"ssex="+sex+"&"+"sage="
		    		+age+"&"+"saddress="+addr;
		    //向服务器发送请求
		    $.get(url,function(data){
				$("#show").html(data);
			});
	}
	refresh();
	function refresh(){
		var url = "webDemo4/drop?oper=query";
		//向服务器发送请求
		$.get(url,function(data){
		$("#show").html(data);
		});
	}
	<!-- //ajax
	//创建一个XmlHttpRequest对象
	var xmlHttpReq;
	function createXmlHttpRequest()
	{
	    if(window.XMLHttpRequest)
	    {//非IE
	       xmlHttpReq = new XMLHttpRequest();
	    }else
	    {	//IE
	       xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
	    }
	}
	//删除学生信息
	function dropValues(){
		//获取多选框的值
	    obj = document.getElementsByName("studentInfo");
	    createXmlHttpRequest();
	    for(k in obj){
	        if(obj[k].checked){
	        	//尝试以异步的get方式访问dropServlet
	        	var stuName = obj[k].value;
	    		alert("确认删除："+ stuName +"?");
	    		//path
	    		var url = "webDemo4/drop?oper=drop&sname="+stuName;
	    		//向服务器发送请求
	    		xmlHttpReq.open("get",url,true);
	    		//回调函数
	    		xmlHttpReq.onreadystatechange = processResponse;
	    	    xmlHttpReq.send(null);
	        }
	    }
	}
	
	//增加学生信息
	function addValues(){
	    var name = $("#stuName").val();
	    var sex = $("#stuSex").val();
	    var age = $("#stuAge").val();
	    var addr = $("#stuAddr").val();
	    createXmlHttpRequest();
	    alert("增加学生信息:"+name);
	    //尝试以异步的get方式访问dropServlet
	    var url = "webDemo4/drop?oper=add&sname="+name+"&"+"ssex="+sex+"&"+"sage="
	    		+age+"&"+"saddress="+addr;
	    //向服务器发送请求
	    xmlHttpReq.open("get",url,true);
	  	//指定响应函数 
	    xmlHttpReq.onreadystatechange = processResponse;
	  
	    xmlHttpReq.send(null);
	}
	//响应函数
	 function processResponse() {  
		 if (xmlHttpReq.readyState == 4) { // 判断对象状态  
             if (xmlHttpReq.status == 200) { // 信息已经成功返回，开始处理信息  
                 alert("刷新成功！");
                 $("#show").html(xmlHttpReq.responseText);
             } else { //页面不正常  
                 window.alert("您所请求的页面有异常。");  
             }  
         }  
       }  
	
	
	//修改学生信息
	function modifyValues(){
		   var name = $("#stuName").val();
		    var sex = $("#stuSex").val();
		    var age = $("#stuAge").val();
		    var addr = $("#stuAddr").val();
		    createXmlHttpRequest();
		    alert("修改学生信息:"+name);
		    //尝试以异步的get方式访问dropServlet
		    var url = "webDemo4/drop?oper=modify&sname="+name+"&"+"ssex="+sex+"&"+"sage="
		    		+age+"&"+"saddress="+addr;
		    //向服务器发送请求
		    xmlHttpReq.open("get",url,true);
		  	//指定响应函数 
		    xmlHttpReq.onreadystatechange = processResponse;
		    xmlHttpReq.send(null);
	}
	//第一次刷新
	function fresh(){
		createXmlHttpRequest();
		var url = "webDemo4/drop?oper=query";
		//向服务器发送请求
		xmlHttpReq.open("get",url,true);
		//指定响应函数 
	    xmlHttpReq.onreadystatechange = processResponse;
	    xmlHttpReq.send(null);
	}
	fresh(); 
	-->
    </script> 
<h1 id="h1_showInfo" align="center" >点击查询学生信息</h1>
<div id="showStudentsInfo" >
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学生信息如下：
		<hr/>
		<div id="show">
			
		</div>
	  <!--<c:forEach items="${sessionScope.students}" var="unknow" varStatus="state">
			<input type="checkbox" name="studentInfo" value="${state.current.name}"/>
			<span>
			${state.current.name}--${state.current.age}--${state.current.sex}--${state.current.address}--
			</span>
			<hr width="80%"/>
		</c:forEach>-->
		
	<div> 
	<input type='button' value='删除' class="btn" onclick="dropValues()"/>
	
	</div>
	<div>
	<input type='text' placeholder='姓名'   id="stuName"/>
	<input type='text' placeholder='年龄'   id="stuAge"/>
	<input type='text' placeholder='性别'   id="stuSex"/>
	<input type='text' placeholder='地址'   id="stuAddr"/>
	<input type='button' value='增加' class="btn" onclick="addValues()"/>
	<input type='button' value='修改' class="btn" onclick="modifyValues()"/>
	</div>
 	</div>
	<div id="end">
	当前登陆用户：${sessionScope.teacher.name}<hr width=150px/>
	<div id="showCurrentTime">
	</div>
</div>
</body>
</html>