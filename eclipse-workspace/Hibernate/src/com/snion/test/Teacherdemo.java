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
}
