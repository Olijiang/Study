import java.util.Scanner;

public class CalNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input x and y:");
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println("Sum=" + (x + y));
        System.out.println("Minus=" + (x - y));
        System.out.println("Multiply=" + (x * y));
        System.out.println("Divide=" + ((float)x / (float)y));
        System.out.println("Remainder=" + (x % y));
        sc.close();
    }
}
