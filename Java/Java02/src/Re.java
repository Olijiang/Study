import com.sun.scenario.effect.impl.sw.java.JSWPhongLighting_DISTANTPeer;

import java.util.regex.Pattern;

public class Re {
    //re表达式

    public static void main(String[] args) {

        //String s 可以理解为一个指针，对s的赋值会让 s 指向一个新的位置，并不会改变原位置的值，String类型是不可修改的final
        //StringBuilder s 可以在原位置修改字符值

        // 1.验证用户名，字母开头，数字字母下划线，4-6位
        String pattern = "^[a-zA-Z]\\w{4,6}";
        String s = "A2001";
        boolean isM = s.matches(pattern);
        System.out.println("1:"+isM);
        //System.out.println(s.hashCode());
        //2.验证网站地址
        s = "https://www.anc.com";
        pattern = "https://www\\.+[a-zA-Z0-9]*\\.com";
        isM = s.matches(pattern);
        System.out.println("2:"+isM);
        //System.out.println(s.hashCode());
        //3.验证手机号
        s = "17396914412";
        pattern = "\\d{11}";
        isM = s.matches(pattern);
        System.out.println("3:"+isM);
        //System.out.println(s.hashCode());

        //分割
        s = "a-b-c-d";
        pattern = "-";
        String[] split = s.split(pattern);
        for (String item: split){
                System.out.println(item);
        }

    }
}
