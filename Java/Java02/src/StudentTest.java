import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class StudentTest {
    public static void main(String[] args){
        Student st = new Student("清漪", 18, 1111);
        System.out.println(st);

        //创建Map集合

        //匿名重写Comparator
        Map<Student,String> map = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return 0;
            }
        });

        map.put(new Student("清漪", 18, 1111), "96");
        map.put(new Student("千欣", 17, 2222), "97");
        map.put(new Student("月婵", 19, 3333), "98");

        //遍历
        for (Map.Entry<Student, String> entry : map.entrySet()) {
            Student key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + value);

        }
    }
}