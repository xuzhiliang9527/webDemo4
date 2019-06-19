package com.woniuxy.DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.woniuxy.util.JDBCutil;
public class TeacherDAO {
	//查询是否存在该teacher用户，如果有则返回
	public boolean query(String sql,Statement state) throws SQLException {
		ResultSet result = JDBCutil.getResultSetFromQueryBcak(state, sql);
		if(result.next()) {
			//关闭
			JDBCutil.closeResultSet(result);
			return true;
		}
		return false;
	}
	//用户注册
	public boolean insert(String sql,Statement state) {
		if(JDBCutil.getResultSetFromUpdateBcak(state, sql)) {
			return true;
		}
		return false;
		}
}
