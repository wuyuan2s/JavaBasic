package datatime;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author wuyuan
 * @create 2020-04-18 21:10
 * jdk8.0之前
 */
public class CalendarTime {
    @Test
    public void test(){
        //方式一：创建子类对象（GregorianCalendar）d的对象
        //方式二：调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar.getClass());
        //常用方法：get(),set(),add(),
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));//get()

        calendar.set(Calendar.DAY_OF_MONTH,30);//set()
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        calendar.add(Calendar.DAY_OF_MONTH, -1);//add()
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        Date time = calendar.getTime();//getTime():日历类-->Date
        System.out.println(time);

        Date date = new Date();//setTime(): Date--> 日历类
        calendar.setTime(date);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.MONTH));//0表示一月；星期：1表示周日
    }

}
