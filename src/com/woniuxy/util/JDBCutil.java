package com.woniuxy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCutil {
	private static Connection con = null;
	private static Statement statement = null;
	private static ResultSet resultset = null;
	static {
		//加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//建立连接
	public static Connection getConnettionBack() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://192.168.41.205:3306/test","test","test");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//获取状态集
	public static Statement getStatementBcak(Connection con) {
		try {
			statement = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statement;
	}
	//获取结果集
	public static ResultSet getResultSetFromQueryBcak(Statement statement,String sql) {
		try {
			resultset = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultset;
	}
	//获取结果集
	public static boolean getResultSetFromUpdateBcak(Statement statement,String sql) {
		try {
			 statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	//关闭
	public static void closeResultSet(ResultSet resultset) {
		try {
			resultset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//关闭
	public static void closeStatement(Statement statement) {
		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//关闭
	public static void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
