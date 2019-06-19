package com.woniuxy.service;

import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Statement;
import com.woniuxy.DAO.TeacherDAO;
import com.woniuxy.DAO.PO.TeacherPO;
import com.woniuxy.util.JDBCutil;

public class TeacherService {
	private static TeacherDAO teacherDAO = new TeacherDAO();
	private static Connection  con = null;
	private static Statement state = null;
	//search information about teacher
	public static TeacherPO isMatch(String teacherName,String teacherPassword) throws SQLException {
		//prep for sql
		con = JDBCutil.getConnettionBack();
		state = JDBCutil.getStatementBcak(con);
		String sql = "SELECT * FROM teacher WHERE name='"+teacherName+"' AND password='"+teacherPassword+"';";
		if(teacherDAO.query(sql,state)){
			return new TeacherPO(teacherName, teacherPassword);
		}
		return null;
	}
	//insert information about teacher
	public static boolean addToDatabase(String teacherName,String teacherPassword) throws SQLException {
		con = JDBCutil.getConnettionBack();
		state = JDBCutil.getStatementBcak(con);
		String sql = "INSERT INTO teacher values('"+teacherName+"','"+teacherPassword+"');";
		return teacherDAO.insert(sql,state);
	}
//	//something hava to be closed;
//	public static void closeStream() {
//		if(state!=null)
//			JDBCutil.closeStatement(state);
//		if(con!=null)
//			JDBCutil.closeConnection(con);
//	}
//	//del Students Info
//	public static boolean delStudentsInfo(String name) {
//		con = JDBCutil.getConnettionBack();
//		state = JDBCutil.getStatementBcak(con);
//		String sql = "DELETE FROM students where `name`='"+name+"';";
//		StudentsDAO.delectFromDB(sql, state);
//		return true;
//	}
	//something need to be close
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
