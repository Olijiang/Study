import java.util.InputMismatchException;
import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        int sum=0, n;
        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.print("Input a number:");
            try{
                n = sc.nextInt();
                break;
            }
            catch (InputMismatchException e){
                System.out.println("Invalid Input!");
                sc.next();
            }
            sc.close();
        }
        while (n!=0){
            sum += n%10;
            n /= 10;
        }
        System.out.println("Sum is "+sum);
        
    }
}
