package com.sc.test;


/*
 * 通过JDBC实现数据交互
 * 步骤：
 * 		1.加载驱动Class.forName("全限定名")
 * 		2.获取数据库的连接对象 Class.forName("驱动类全称:包名+类名")
 *		3.
*/


//
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JDBCdemo {
	private static Connection conn;
	private static java.sql.Statement st;
	private static ResultSet rs;
	
	public JDBCdemo(String database) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:///"+database+"?serverTimezone=UTC","root","");
			conn.setAutoCommit(true);//自动提交
			st = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public boolean Update(String sql) {
		int flag=0;
		try {
			flag = st.executeUpdate(sql);
		}catch (Exception e) {
			;
		}
		return (flag==0)?false:true;
	}
	
	public ResultSet Query(String sql) {
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("查询失败");
		} //返回查询结果集
		return rs;
	}
	
	public void close() {
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
	
	public static void main(String[] args) {
		try {
			//1.加载驱动Class.forName("全限定名")
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.获取链接
			conn = DriverManager.getConnection("jdbc:mysql:///School?serverTimezone=UTC","root","");
			conn.setAutoCommit(true);//自动提交
			st = conn.createStatement();
			
			String sql = "describe myclass";//表结构
			rs = st.executeQuery(sql); //返回查询结果集
			
			
//			String sql = "insert into myclass values(2012,'神曦',22,'2000-01-01',91,98,85)";
			
			st.executeUpdate(sql);			
			
			while (rs.next()) {
				//打印字段名和类型
				String name = rs.getString("Field");
				String type = rs.getString("Type");
				System.out.println(name + " " + type);
//				//获取数据方法1
////				Object sid =  rs.getObject(1);
////				Object name =  rs.getObject(2);
////				Object age =  rs.getObject(3);
////				Object sex =  rs.getObject(4);
////				System.out.println(sid+" "+name+" "+age+" "+sex);
//				
//				//获取数据方法1
//				int sid = rs.getInt("sid");
//				String name = rs.getString("name");
//				int age = rs.getInt("age");
//				String sex =rs.getString("sex");
//				System.out.println(sid+" "+name+" "+age+" "+sex);
			}
			//2.获取数据库的连接对象 Class.forName("驱动类全称:包名+类名")
			
			//System.out.println(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
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
		
		
	}
	
	
}
