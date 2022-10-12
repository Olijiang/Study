import java.text.SimpleDateFormat;
import java.util.Date;

public class testData {
    public static void main(String[] args) {
        Date d1 = new Date();
        System.out.println(d1);
        //指定格式化
        SimpleDateFormat mytime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(mytime.format(d1));

        long time  = d1.getTime();
        System.out.println(time);




    }
}
