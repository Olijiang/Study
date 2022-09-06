package om.snion.test;

import java.util.Map;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.snion.entity.DemoClass;
import com.snion.entity.DemoClass2;
import com.snion.entity.DemoClass3;
import com.snion.entity.Student;
import com.snion.entity.User;

public class UserTest {
	@Test
	public void democlass1() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		DemoClass class1 = (DemoClass) applicationContext.getBean("class1");
		System.out.println(class1);
		
		applicationContext.close();
	}
	
	//@Test
	public void democlass2() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		DemoClass2 class2 = (DemoClass2) applicationContext.getBean("class2");
		System.out.println(class2);
		
		applicationContext.close();
	}
	//@Test
	public void democlass3() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		DemoClass3 class3 = (DemoClass3) applicationContext.getBean("class3");
		System.out.println(class3);
		Map<Integer, String> stu_member = class3.getStu_member();
		for (Integer sid : stu_member.keySet()) {
			System.out.println("sid:"+ sid +" name:"+ stu_member.get(sid));
		}
		applicationContext.close();
	}
	
	//@Test
	public void demouser() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = (User) applicationContext.getBean("User");
		System.out.println(user);
		Student stu = (Student) applicationContext.getBean("Stu");
		System.out.println(stu);
		applicationContext.close();
		//((ConfigurableApplicationContext) applicationContext).close();
		
		
	}
}