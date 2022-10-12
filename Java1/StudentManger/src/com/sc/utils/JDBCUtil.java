package com.sc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

/* 工具类
 * 	加载驱动
 * 	获取连接
 * 	关闭连接
 * 
 * 	增、删、查、改
*/

public class JDBCUtil {
	
	private static Connection conn;
	private static java.sql.PreparedStatement st;
	private static ResultSet rs;
	
	static {
		//加载驱动
		try {
			Class.forName("com.mysql.cj.jdbc.Driver ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getConn(String database) {
		//获取连接
		try {
			 conn = DriverManager.getConnection("jdbc:mysql:///"+database+"?serverTimezone=UTC","root","");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close() { 
		// 关闭连接
		try {
			if (conn!=null) {
				conn.close();
			}
			if (rs!=null) {
				rs.close();
			}
			if (st!=null) {
				st.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//-------------------------------sql 操作
	// 查询，返回list集合
	/*public static<T> List<T> query(Class<T> cls, String sql, Object...obj) {
		try {
			getConn("school");
			st = conn.prepareStatement(sql);
			 //循环参数
			for (int i=1; i<obj.length; i++) {
				st.setObject(i, obj[i-1]);
			}
			rs = st.executeQuery();
			while(rs.next()) {
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
		
	}*/
	//返回 rs 结果集
	public ResultSet query(String sql, Object...obj) {
		try {
			getConn("school");
			st = conn.prepareStatement(sql);
			 //循环参数
			for (int i=1; i<obj.length; i++) {
				st.setObject(i, obj[i-1]);
			}
			rs = st.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}
	
	// 增删改,返回受影响的行数
	public static int update() {
		
		return 0;
	}
}
