import java.util.Locale;
import java.util.Scanner;

public class ToUpCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input:");
        String str = sc.next();
        System.out.println(str.toUpperCase(Locale.ROOT));
        sc.close();
    }
}
