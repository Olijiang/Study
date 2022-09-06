package om.snion.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.snion.entity.User;
import com.snion.entity.Student;

//ע�����
public class Userdemo2 {
	//@Test
	public void demo1() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext2.xml");
		User user = (User) applicationContext.getBean("User"); 
		System.out.println(user);
		applicationContext.close();
	}
	
	@Test
	public void demo2() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext2.xml");
		Student student = (Student) applicationContext.getBean("Student"); 
		System.out.println(student);
		applicationContext.close();
	}
}