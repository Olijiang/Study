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
//		String hql = "from Student where name like ?";	//��ӳ�䣬�����Ǳ���
//		List<Student> list = session.createQuery(hql).setParameter("tch_id", "%�%").list();
		
//		String hql = "from Student order by id";	//��ӳ�䣬�����Ǳ���
//		Query<Student> query = session.createQuery(hql);
//		query.setFirstResult(5);
//		query.setMaxResults(5);
//		List<Student> list = query.list();
//		for (Student student : list) {
//			System.out.println(student);
//		}
		
		String hql = "from Student st left join Teacher th on st.tch_id=th.id";	//��ӳ�䣬�����Ǳ���
		
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		//����һ�����object�������͵��б�object�����Ŷ�Ӧ�Ķ���
		System.out.println(list.size());
		
		for (Object[] object : list) {
			System.out.print(object[0]);
			System.out.println(object[1]);
		}
		

		//session.flush();
//		Student student = session.get(Student.class, 1004);
//		System.out.println(student);
		
		//6. �����ύ
		transaction.commit();
		
		//7. �ͷ���Դ
		session.close();
		sessionFactory.close();
	}
}
