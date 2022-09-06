package com.snion.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.snion.entity.Student;
import com.snion.entity.Teacher;
public class Init {

	public static final Configuration cfg;
	public static final SessionFactory sf;//һ����Ŀֻ�ᴴ��һ��SessionFactory����

	static {
		cfg = new Configuration().configure();
		sf = cfg.buildSessionFactory();
	}
	

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


	public static void initStudent() {
		int sta_id = 1000;
		int k=1;
		String[] stu_name = {"�ν�","�ž�","�Ϻ�","����","����","����","���","���","����","���","����","��"};
		//int age = (int)(Math.random()*10%5+18);
		Session session = sf.openSession();
		Transaction ts = session.beginTransaction();
		//��������
		for (String name : stu_name) {
			Student st = new Student();
			st.setName(name);
			st.setAge((int)(Math.random()*10%5+18));
			st.setId(sta_id + k++);
			st.setSex("Ů");
			st.setTch_id((int)(Math.random()*10%2+2001));
			session.save(st);
			session.flush();
		}
		ts.commit();
		session.close();
	}
	
	

	public static void initTeacher() {
		int sta_id = 2000;
		int k=1;
		String[] tea_name = {"����ʦ","����ʦ"};
		
		Session session = sf.openSession();
		Transaction ts = session.beginTransaction();
		//��������
		for (String name : tea_name) {
			Teacher th =new Teacher();
			th.setName(name);
			th.setId(sta_id + k++);
			session.save(th);
		}
		ts.commit();
		session.close();
	}
	
	
	public static void main(String[] args) {
		initStudent();
		initTeacher();
	}

}	
	
