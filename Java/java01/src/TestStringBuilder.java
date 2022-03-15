public class TestStringBuilder {

    public static void main(String[] args) {

        StringBuilder s1 = new StringBuilder("Hello");
        System.out.println("s1:" + s1);
        System.out.println("capacity:" + s1.capacity());
        System.out.println("length:" + s1.length());

        System.out.println("-----------------------");

        StringBuilder s2 = s1.append("java");
        System.out.println("s1:" + s2);
        System.out.println("capacity:" + s2.capacity());
        System.out.println("length:" + s2.length());
        //System.out.println(s1==s2);
    }
}
