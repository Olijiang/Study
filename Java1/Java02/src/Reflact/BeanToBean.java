package Reflact;
//通过反射实现JavaBean转JavaBean

import java.io.File;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BeanToBean {
    public static void main(String[] args) throws Exception {
        Teacher teacher = new Teacher(1,"Aice", 20);
        Student student = new Student();
        Class<? extends Student> cls2 = student.getClass();
        Field[] fields2 = cls2.getDeclaredFields();
        //利用反射将teacher对象转为Student对象
        Class<? extends Teacher> cls = teacher.getClass();
        //获取全部方法
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            String str = Modifier.toString(method.getModifiers());  //方法修饰符
            String name = method.getName(); //方法名称
            String returnType = method.getReturnType().getSimpleName(); //返回值类型
            Class<?>[] parms = method.getParameterTypes();
            System.out.println(str+" "+returnType+" "+name);
            System.out.print("parms：");
            for (Class<?> parm : parms) {   //参数列表
                System.out.print(parm.getSimpleName()+" "); //参数类型
            }
            System.out.println();

        }


        //获取全部属性
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String str = Modifier.toString(field.getModifiers());   //属性修饰符

            String name = field.getName();  //属性name
            Object value = field.get(teacher);  //属性值
            String type =  field.getType().getSimpleName();   //属性类型

            System.out.println(str+ " " + type + " " + name + " " +value);
            /*for (Field field2 : fields2) {
                field2.setAccessible(true);
                String name2 = field2.getName();
                String simpleName2 = field2.getType().getSimpleName();
                if (name.equals(name2) && simpleName.equals(simpleName2)){
                    field2.set(student,value);
                }
            }*/
        }
        //System.out.println(teacher);
        //System.out.println(student);
    }
}
