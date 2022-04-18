import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class TestCollection {
    public static void main(String[] args) {
        Student s1 = new Student("清漪", 18, 11);
        Student s2 = new Student("千欣", 17, 22);
        Student s3 = new Student("月婵", 19, 33);
        Student s4 = new Student("雪锦", 18, 44);
        Student s5 = new Student("琪儿", 18, 55);
        ArrayList<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        //Collections.sort(list);
        System.out.println(Collections.binarySearch(list, s5, new Comparator<Student>() {
            @Override   //不重写的话默认用的Student内的比较器，比较的ID
            public int compare(Student o1, Student o2) {
                if (o1 == o2) return 0;
                if (o1.getId()==o2.getId() && o1.getAge()==o2.getAge() && o1.getName()==o2.getName()) return 0;
                return -1;
            }
        }));

        for (Student st: list){
            System.out.println(st);
        }





    }
}
