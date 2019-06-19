package com.woniuxy.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.woniuxy.DAO.PO.StudentsPO;
import com.woniuxy.util.JDBCutil;

public class StudentsDAO {
	private static ArrayList<StudentsPO> al = null;
	private StudentsDAO(){};
	//查询学生信息
	public static boolean queryAllStudents(String sql,Statement state) throws SQLException {
		ResultSet result = JDBCutil.getResultSetFromQueryBcak(state, sql);
		al = new ArrayList<StudentsPO>();
		while(result.next()) {
			StudentsPO student = new StudentsPO(
					result.getString("name"),
					result.getString("age"),
					result.getString("sex"),
					result.getString("address"));
			al.add(student);
		}
		return true;
	}
	
	
	//获取al并返回
	public static ArrayList<StudentsPO> getAl() {
		return al;
	}
	
	
	//删除特定学生
	public static boolean delectFromDB(String sql,Statement state) {
		JDBCutil.getResultSetFromUpdateBcak(state, sql);
		return true;
	}
	
	//增加特定学生
	public static boolean addToDB(String sql,Statement state) {
		JDBCutil.getResultSetFromUpdateBcak(state, sql);
		return true;
	}
	
	//增加学生学生信息
	public static boolean modifyToDB(String sql,Statement state) {
		JDBCutil.getResultSetFromUpdateBcak(state, sql);
		return true;
	}
}
