package com.woniuxy.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.woniuxy.DAO.PO.StudentsPO;
import com.woniuxy.DAO.PO.TeacherPO;
import com.woniuxy.service.StudentsService;
import com.woniuxy.service.TeacherService;

/**
 *登陆
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//解决输出中文乱码
			resp.setHeader("Content-type", "text/html;charset=UTF-8");
			resp.setCharacterEncoding("utf-8");
			TeacherPO teacher = null;
			//获取用户输入
			String userName=req.getParameter("username");
			String userPassword=req.getParameter("password");
			System.out.println("用户："+userName+"试图通过密码:"+userPassword+"登陆！");
			try {
				//验证该用户信息是否存在与数据库，若存在则返回teacher对象
				teacher = TeacherService.isMatch(userName,userPassword);
//				teacher=new TeacherPO(userName,userPassword);
				if(teacher!=null) {
					System.out.println("用户："+userName+" 登陆成功！");
					//StudentsService studentServiceInfo = new StudentsService();
//					获取students信息
//					ArrayList<StudentsPO> al = StudentsService.getStudentsInfoBack();
					//将用户对象信息和students信息保存到Seesion中
					HttpSession session = req.getSession();
//					session.setAttribute("students", al);
					session.setAttribute("teacher",teacher);
					//ArrayList<String> studentIndex = new ArrayList<String>();
					//session.setAttribute("studentIndex", studentIndex);
					//如果成功弹出登陆成功并跳到下一个页面
					//PrintWriter out = resp.getWriter();
//					out.print("<script>alert('用户："+userName+"登录成功!');</script>");
//					out.print("/r/n");
					//out.flush();
					//请求派发---------转到用户界面
					System.out.println("跳转中...");
					req.getRequestDispatcher("jsp/LoginSucessful.jsp").forward(req, resp);				
				}
				else {
					//nothing to do
					System.out.println("用户名或密码错误！");
					req.getRequestDispatcher("jsp/LoginFailed.jsp").forward(req, resp);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
			 

}
