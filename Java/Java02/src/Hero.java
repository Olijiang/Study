public class Hero {
    private String name;
    private int HP;
    private int speed;
    private int armor;

    public Hero(String name, int hp, int speed, int armor){
        setName(name);
        setHP(hp);
        setSpeed(speed);
        setArmor(armor);
    }

    public Hero(){
        setName("name");
        setHP(0);
        setSpeed(0);
        setArmor(0);
    }

    public void setName(String name){
        this.name = name;
    }

    public void setHP(int hp){
        this.HP = hp;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }

    public void setArmor(int armor){
        this.armor = armor;
    }

    public void show(){
        System.out.println("name:"+name+" HP:"+HP+" speed:"+speed+" armor:"+armor);
    }

    public static void main(String[] args) {
        Hero garen = new Hero("garen", 100, 50, 60);
        garen.show();
        Hero teemo = new Hero("teemo", 100, 40, 80);
        teemo.show();
    }

}


