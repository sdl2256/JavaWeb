package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by SDL on 2015/6/5.
 */
public class TestJava {
    public static void main(String[] args) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        Calendar cal = Calendar.getInstance();

        cal.add(Calendar.DATE, +4);

        System.out.println(df.format(cal.getTime()));
    }
}
