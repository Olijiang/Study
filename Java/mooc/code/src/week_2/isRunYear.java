package week_2;

import java.util.InputMismatchException;
import java.util.Scanner;

// 判断闰年， 能被4整除但不能被100整除，或者能被400整除
public class isRunYear {
    public static void main(String[] args) {
        int year;
        while (true){
            System.out.print("Input a year:");
            Scanner sc = new Scanner(System.in);
            try{
                year = sc.nextInt();
                break;
            }
            catch (InputMismatchException e){
                System.out.println("Invalid Input!");
                sc.next();  //读掉非法输入
            }
        }
        if ((year%4==0 && year%100!=0) || year%400==0){
            System.out.println("yes");
        }
        else System.out.println("no");
    }
}
