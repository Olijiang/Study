
import java.util.Scanner;

public class Input {
    public static void main(String[] args) {

        System.out.print("请输入姓名：");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        System.out.print("请输入年龄：");
        int age = sc.nextInt();
        System.out.print("你的姓名："+name+"; 你的年龄："+age);

    }
}
