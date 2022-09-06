package com.snion.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * SqlSessionFactory������
 * @author liayun
 *
 */
public class SqlSessionFactoryUtils {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			//����SqlSessionFactoryBuilder����
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			//�������������ļ���������
			InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
			//ͨ�����������ļ�������������SqlSessionFactory����
			sqlSessionFactory = ssfb.build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * ��ȡSqlSession����
	 * @return
	 */
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
}