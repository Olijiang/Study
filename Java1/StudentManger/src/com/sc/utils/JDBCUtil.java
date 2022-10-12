package com.sc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

/* ������
 * 	��������
 * 	��ȡ����
 * 	�ر�����
 * 
 * 	����ɾ���顢��
*/

public class JDBCUtil {
	
	private static Connection conn;
	private static java.sql.PreparedStatement st;
	private static ResultSet rs;
	
	static {
		//��������
		try {
			Class.forName("com.mysql.cj.jdbc.Driver ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getConn(String database) {
		//��ȡ����
		try {
			 conn = DriverManager.getConnection("jdbc:mysql:///"+database+"?serverTimezone=UTC","root","");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close() { 
		// �ر�����
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
	
	//-------------------------------sql ����
	// ��ѯ������list����
	/*public static<T> List<T> query(Class<T> cls, String sql, Object...obj) {
		try {
			getConn("school");
			st = conn.prepareStatement(sql);
			 //ѭ������
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
	//���� rs �����
	public ResultSet query(String sql, Object...obj) {
		try {
			getConn("school");
			st = conn.prepareStatement(sql);
			 //ѭ������
			for (int i=1; i<obj.length; i++) {
				st.setObject(i, obj[i-1]);
			}
			rs = st.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}
	
	// ��ɾ��,������Ӱ�������
	public static int update() {
		
		return 0;
	}
}
