public class student extends Person{
    private int id;

    public student(){
        super();    //执行父类的构造
    }
    public student(String name, int age, int id){
        super(name,age); //必须在第一句
        setId(id);
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    @Override
    public void show() {
        System.out.println("name:"+this.getName()+"  age:"+this.getAge() +"  id:"+this.getId());
    }
    @Override
    public String toString(){
        return "name:"+this.getName()+"  age:" + this.getAge()+"  ID:"+this.id ;
    }
}
