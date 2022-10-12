
// Person 类
public class Person {

    private String name;
    private int age;

    //无参构造
    public Person(){}
    //有参构造
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }

    public void show(){
        System.out.println("name:"+name+"  age:"+age);
    }
}
