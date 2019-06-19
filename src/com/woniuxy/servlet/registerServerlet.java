package com.woniuxy.servlet;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.woniuxy.service.TeacherService;
public class registerServerlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		System.out.println("接收到ajax");
		//解决输出中文乱码
		resp.setHeader("Content-type", "text/html;charset=UTF-8");
		resp.setCharacterEncoding("utf-8");
		//获取到用户名和输入
		String userName=req.getParameter("username");
		String userPassword=req.getParameter("password");
		System.out.println("用户试图以用户名："+userName+"密码："+userPassword+"执行注册操作！");
		try {
			if(TeacherService.addToDatabase(userName,userPassword)) {
				System.out.println("注册成功！");
				resp.getOutputStream().write("<h1 style='margin:120px auto;'>注册成功！</h1>".getBytes());
				resp.getOutputStream().write("<h1 style='margin:120px auto;'>3s后返回</h1>".getBytes());
				resp.sendRedirect("/webDemo4/jsp/RegisterSuccessful.jsp");
			}
			else {
				System.out.println("注册失败");
				resp.getOutputStream().write("<h1>注册 失败</h1>".getBytes());
				resp.getOutputStream().write("<h1 style='margin:120px auto;'>3s后返回</h1>".getBytes());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		
	}
	
}
