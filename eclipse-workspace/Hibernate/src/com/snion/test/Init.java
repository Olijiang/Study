package com.snion.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.snion.entity.Student;
import com.snion.entity.Teacher;
public class Init {

	public static final Configuration cfg;
	public static final SessionFactory sf;//一个项目只会创建一个SessionFactory对象

	static {
		cfg = new Configuration().configure();
		sf = cfg.buildSessionFactory();
	}
	

	public void HibernameDemo1() {
		// TODO Auto-generated method stub
		//1. 加载Hibernate的核心配置文件
		Configuration configuration = new Configuration().configure();
		//如果在Hibernate的核心配置文件没有设置加载哪个映射文件，则可手动加载映射文件
		//configuration.addResource("com/meimeixia/hibernate/demo01/Customer.hbm.xml");
		
		//2. 创建SessionFactory对象，类似于JDBC中的连接池
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		//3. 通过SessionFactory获取到Session对象，类似于JDBC中的Connection
		Session session =  sessionFactory.openSession();
		
		//4. 手动开启事务，（最好是手动开启事务）
		Transaction transaction = session.beginTransaction();
		
		//5. 编写代码
		Teacher teacher = new Teacher(6001,"何老师");
		
		session.save(teacher);//保存一个用户
		//session.flush();
		//student = session.get(Student.class, 1004);
		System.out.println(teacher);
		
		//6. 事务提交
		transaction.commit();
		
		//7. 释放资源
		session.close();
		sessionFactory.close();
	}


	public static void initStudent() {
		int sta_id = 1000;
		int k=1;
		String[] stu_name = {"梦洁","雅静","韵寒","莉姿","沛玲","欣妍","歆瑶","凌菲","靖瑶","瑾萱","月琪","瑾瑜"};
		//int age = (int)(Math.random()*10%5+18);
		Session session = sf.openSession();
		Transaction ts = session.beginTransaction();
		//代码区域
		for (String name : stu_name) {
			Student st = new Student();
			st.setName(name);
			st.setAge((int)(Math.random()*10%5+18));
			st.setId(sta_id + k++);
			st.setSex("女");
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
		String[] tea_name = {"徐老师","王老师"};
		
		Session session = sf.openSession();
		Transaction ts = session.beginTransaction();
		//代码区域
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
	
