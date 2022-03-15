public class TestString {

    public static void main(String[] args) {
        String str1 = "12345";  // 栈内存中
        String str2 = "12345";  // 栈内存中已存在,直接引用
        String str3 = new String("12345");   // 堆内存中，每次都是new对象
        System.out.print("str1==str2?: ");
        System.out.println(str1==str2);
        System.out.print("str1==str3?: ");
        System.out.println(str1==str3);     //==比较的是内存地址
        System.out.print("str1.equals(str3)?: ");
        System.out.println(str1.equals(str3));  // equals() 比较的是值

        String str4 = str1 + "1";    // str4 为一个新地址
        System.out.println("str4:"+ str4);
        System.out.print("str1==str4?: ");
        System.out.println(str1==str4);

        String str5 = str1 + "1";    // str5 为一个新地址
        System.out.println("str5:"+ str5);
        System.out.print("str4==str5?: ");
        System.out.println(str4==str5);
    }

}
