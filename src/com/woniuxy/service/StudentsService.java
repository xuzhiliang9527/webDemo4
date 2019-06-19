package com.woniuxy.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.woniuxy.DAO.StudentsDAO;
import com.woniuxy.DAO.PO.StudentsPO;
import com.woniuxy.util.JDBCutil;

//返回学生信息
public class StudentsService {
	//get students information from database
	public static ArrayList<StudentsPO> al = new ArrayList<StudentsPO>();
	private static Connection  con = JDBCutil.getConnettionBack();
	private static Statement state = JDBCutil.getStatementBcak(con);
	public static ArrayList<StudentsPO> getStudentsInfoBack() {
		String sql = "SELECT * FROM students;";
			try {
				if(StudentsDAO.queryAllStudents(sql,state)) {
					//返回学生信息
					al = StudentsDAO.getAl();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return al;
	}
	//学生删除
	public static ArrayList<StudentsPO> delStudent(String name) {
		String sql = "DELETE FROM students WHERE `name`='"+name+"';";
		StudentsDAO.delectFromDB(sql, state);
		al = StudentsDAO.getAl();
		return al;
	}
	
	//学生增加
	public static ArrayList<StudentsPO> addStudent(String name,String age,String sex,String addr) {
		String sql = "INSERT INTO students VALUES('"+name+"','"+age+"','"+sex+"','"+addr+"');";
		System.out.println(sql);
		StudentsDAO.addToDB(sql, state);
		al = StudentsDAO.getAl();
		return al;
	}
	
	//学生修改
	public static ArrayList<StudentsPO> modifyStudent(String name,String age,String sex,String addr) {
		String sql = "UPDATE students SET "+"age='"+age+"',sex='"+sex+"',address='"+addr+"' WHERE `name`='"+name+"';";
		System.out.println(sql);
		StudentsDAO.modifyToDB(sql, state);
		al = StudentsDAO.getAl();
		return al;
	}
	public  static void closeAll() {
		if(state!=null) {
			try {
				state.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if(con!=null) {
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
