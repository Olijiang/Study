package com.snion.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcTest {
	//1. ��������
	//2. ��������
	//3. ����SQL���
	//4. ����һ��Statement����
	//5. ���ò���
	//6. ִ�в�ѯ���õ�һ��ResultSet����
	//7. �����������������
	//8. �ͷ���Դ
	public static void main(String[] args) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			//1. ��������
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2. ��������
			connection = DriverManager.getConnection("jdbc:mysql:///school ?serverTimezone=UTC", "root", "666666");
			//3. ����SQL���
			String sql = "select * from students";
			//4. ����һ��Statement����, ��ȡԤ����statement
			preparedStatement = connection.prepareStatement(sql);
			//5. ���ò���,��һ������Ϊsql����в�������ţ���1��ʼ�����ڶ�������Ϊ���õĲ���ֵ
			//preparedStatement.setString(1, "����");
			// ִ�в�ѯ���õ�һ��ResultSet����
			resultSet = preparedStatement.executeQuery();
			//7. �����������������
			while (resultSet.next()) {
				System.out.println(resultSet.getString("id") + "  " + resultSet.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			// �ͷ���Դ
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}