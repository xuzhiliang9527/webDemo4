package com.woniuxy.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.woniuxy.DAO.PO.StudentsPO;
import com.woniuxy.service.StudentsService;

@WebServlet("/dropServlet")
public class dropServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String method = req.getParameter("oper");
	ArrayList<StudentsPO> al = null;
	resp.setCharacterEncoding("UTF-8");
	resp.setHeader("Content-type", "text/html;charset=UTF-8");
//	HttpSession session = req.getSession();
//	session.removeAttribute("students");
	switch(method) {
	
		case "drop":
			System.out.println("执行删除");
			drop(req);
			break;
			
		case "add":
			System.out.println("执行增加");
			add(req);
			break;
			
		case "modify":
			System.out.println("执行修改");
			modify(req);
			break;
			default:
		}
	al = query();
	refresh(al, resp);
	}



	//删除
	private boolean drop(HttpServletRequest req) {
		String name = null;
		try {
			name = URLDecoder.decode(req.getParameter("sname"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		StudentsService.delStudent(name);
		return true;
	}
	//增加
	private boolean add(HttpServletRequest req) {
		String name = null;
		String age = null;
		String sex = null;
		String address = null;
		try {
			name = URLDecoder.decode(req.getParameter("sname"),"utf-8");
			age = URLDecoder.decode(req.getParameter("sage"),"utf-8");
			sex = URLDecoder.decode(req.getParameter("ssex"),"utf-8");
			address = URLDecoder.decode(req.getParameter("saddress"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		StudentsService.addStudent(name, age, sex, address);
		return true;
	}
	//修改
	private boolean modify(HttpServletRequest req) {
		String name = null;
		String age = null;
		String sex = null;
		String address = null;
		try {
			name = URLDecoder.decode(req.getParameter("sname"),"utf-8");
			age = URLDecoder.decode(req.getParameter("sage"),"utf-8");
			sex = URLDecoder.decode(req.getParameter("ssex"),"utf-8");
			address = URLDecoder.decode(req.getParameter("saddress"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		StudentsService.modifyStudent(name, age, sex, address);
		return true;
	}
	//查询
	private ArrayList<StudentsPO> query() {
		System.out.println("执行查询");
		ArrayList<StudentsPO> alq = StudentsService.getStudentsInfoBack();
		return alq;
	}
	//ajax请求输出
	private void refresh(ArrayList<StudentsPO> al,HttpServletResponse response) {
		System.out.println("ajax输出");
		for(StudentsPO po:al) {
				 //URLDecoder.decode
				try {
					response.getWriter().append("<input type='checkbox' style=\"margin-top:10px;\" name='studentInfo' value='"+po.getName()+"'/>");
					response.getWriter().append(po.getName()+"--");
					response.getWriter().append(po.getAge()+"--");
					response.getWriter().append(po.getSex()+"--");
					response.getWriter().append(po.getAddress());
					response.getWriter().append("<br/>");
				} catch (IOException e) {
					e.printStackTrace();
				}
				
		}
	}
}
