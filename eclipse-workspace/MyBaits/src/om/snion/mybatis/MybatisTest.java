package om.snion.mybatis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.snion.entity.MyClass;
import com.snion.entity.MyClassMapper;
import com.snion.entity.Student;
import com.snion.entity.StudentMapper;
import com.snion.util.SqlSessionFactoryUtils;

public class MybatisTest {
	//@Test
	public void testdemo() throws IOException {
//		//����SqlSessionFactoryBuilder����
//		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
//		//1. ���غ��������ļ����������������ļ�������������
//		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//		//2. ����SqlSessionFactory����ͨ�����������ļ������������󴴽�SqlSessionFactory����
//		SqlSessionFactory sqlSessionFactory = ssfb.build(inputStream);
//		//3. ����SqlSession���󣬵�����API���õ�һ�������
//		//����SqlSession����
//		//SqlSession sqlSession = sqlSessionFactory.openSession();
//		�� SqlSessionFactoryUtils ִ�����ϲ��֣�ֱ�ӻ�� sqlSession
		
		SqlSession sqlSession = (SqlSession) SqlSessionFactoryUtils.getSqlSession();
		
		//��ȡ�ӿڵĴ���ʵ����
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//		Student student = mapper.getStudentById(1001);
//		System.out.println(student);
		//Student student = new Student(9993,"�ν�", "Ů", 21, 2001);
//		System.out.println(mapper.insertStudent(student));
//		List<Integer> list = new ArrayList<>();
//		list.add(9991);

//		System.out.println(mapper.deletetStudentsById(list));
		//List<Student> students  = sqlSession.selectList("getAllStudent");
		//Ч��ͬ��
//		List<Student> students  = mapper.getAllStudent();
//		//������
//		for (Student student1 : students) {
//			System.out.println(student1);
//		}

		//�ͷ���Դ
		sqlSession.close();
	}
	
	@Test
	public void testdemo2() throws IOException {
		SqlSession sqlSession = (SqlSession) SqlSessionFactoryUtils.getSqlSession();
		//��ȡ�ӿڵĴ���ʵ����
		MyClassMapper mapper = sqlSession.getMapper(MyClassMapper.class);
		List<MyClass> myClass  = mapper.getMyClass();
		for (MyClass myclass : myClass) {
			System.out.println("tch_id:"+ myclass.getTch_id() + "  tch_name:" + myclass.getTch_name());
			for (Student student : myclass.getClassmate()) {
				System.out.println("       "+student);
			}
		}
		
		//�ͷ���Դ
		sqlSession.close();
	}
}