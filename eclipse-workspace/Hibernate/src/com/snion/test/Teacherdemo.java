package com.snion.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.snion.entity.Teacher;

public class Teacherdemo {

	@Test
	public void HibernameDemo1() {
		// TODO Auto-generated method stub
		//1. ����Hibernate�ĺ��������ļ�
		Configuration configuration = new Configuration().configure();
		//�����Hibernate�ĺ��������ļ�û�����ü����ĸ�ӳ���ļ�������ֶ�����ӳ���ļ�
		//configuration.addResource("com/meimeixia/hibernate/demo01/Customer.hbm.xml");
		
		//2. ����SessionFactory����������JDBC�е����ӳ�
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		//3. ͨ��SessionFactory��ȡ��Session����������JDBC�е�Connection
		Session session =  sessionFactory.openSession();
		
		//4. �ֶ��������񣬣�������ֶ���������
		Transaction transaction = session.beginTransaction();
		
		//5. ��д����
		Teacher teacher = new Teacher(6001,"����ʦ");
		
		session.save(teacher);//����һ���û�
		//session.flush();
		//student = session.get(Student.class, 1004);
		System.out.println(teacher);
		
		//6. �����ύ
		transaction.commit();
		
		//7. �ͷ���Դ
		session.close();
		sessionFactory.close();
	}
}
