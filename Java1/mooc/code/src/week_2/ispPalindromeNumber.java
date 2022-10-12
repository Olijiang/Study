package week_2;
import java.util.InputMismatchException;
import java.util.Scanner;

//回文数 12321
public class ispPalindromeNumber {
    public static void main(String[] args) {
        int num = 0;
        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.print("Input a number:");
            try {
                num = sc.nextInt();
                break;
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input!");
                sc.next();
            }
        }
        String s = String.valueOf(num);
        int n = s.length();
        for (int i=0; i<n/2;i++){
            if (s.charAt(i)!=s.charAt(n-i-1)){
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println("yes");
    }


}
