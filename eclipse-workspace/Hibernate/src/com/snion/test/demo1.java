package com.snion.test;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;


import com.snion.entity.Student;

public class demo1 {
	
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
//		String hql = "from Student where name like ?";	//类映射，而不是表名
//		List<Student> list = session.createQuery(hql).setParameter("tch_id", "%瑾%").list();
		
//		String hql = "from Student order by id";	//类映射，而不是表名
//		Query<Student> query = session.createQuery(hql);
//		query.setFirstResult(5);
//		query.setMaxResults(5);
//		List<Student> list = query.list();
//		for (Student student : list) {
//			System.out.println(student);
//		}
		
		String hql = "from Student st left join Teacher th on st.tch_id=th.id";	//类映射，而不是表名
		
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		//返回一个存放object数组类型的列表，object数组存放对应的对象
		System.out.println(list.size());
		
		for (Object[] object : list) {
			System.out.print(object[0]);
			System.out.println(object[1]);
		}
		

		//session.flush();
//		Student student = session.get(Student.class, 1004);
//		System.out.println(student);
		
		//6. 事务提交
		transaction.commit();
		
		//7. 释放资源
		session.close();
		sessionFactory.close();
	}
}
