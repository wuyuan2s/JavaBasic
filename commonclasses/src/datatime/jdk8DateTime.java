package datatime;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;


/**
 * @author wuyuan
 * @create 2020-04-18 21:47
 *
 * 1、LocalDateTime相比于LocalDate、LocalTime使用频率更高
 * 2、类似于Calendar
 */
public class jdk8DateTime {
    @Test
    public void test(){
        LocalDate localDate = LocalDate.now();//获取当前日期
        LocalTime localTime = LocalTime.now();//获取当前时间
        LocalDateTime localDateTime = LocalDateTime.now();//获取当前日期+时间

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

//        of()设置指定的年月日，时分秒，没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2021,1,1,1,1,1);
        System.out.println(localDateTime1);

        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDate.getDayOfWeek());
        System.out.println(localDateTime.getDayOfYear());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());

        //体现不可变性
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate);
        System.out.println(localDate1);

        LocalTime localTime1 = localTime.withHour(1);
        System.out.println(localTime);
        System.out.println(localTime1);
    }

    /*
    instan： 瞬时
     */
    @Test
    public void test2(){
        //本初子母线的时间
        Instant instant = Instant.now();
        System.out.println(instant);//2020-04-18T14:13:48.063Z

        //东八区，加8小时的时间差
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);//2020-04-18T22:16:08.813+08:00

        //获取自1970年01月01日开始到现在的毫秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        //通过给的毫秒数，转换为Instant实力 类似：Date（Long long）
        Instant instant1 = Instant.ofEpochMilli(1587219584856L);
        OffsetDateTime offsetDateTime1 = instant1.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime1);

    }

    @Test
    public void test3(){
//        方式一：预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化:日期-->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);//2019-02-18T15:42:18.797

        //解析：字符串 -->日期
        TemporalAccessor parse = formatter.parse("2019-02-18T15:42:18.797");
        System.out.println(parse);

//        方式二：
//        本地化相关的格式。如：ofLocalizedDateTime()
//        FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT :适用于LocalDateTime
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        //格式化
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);//2019年2月18日 下午03时47分16秒


//      本地化相关的格式。如：ofLocalizedDate()
//      FormatStyle.FULL / FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT : 适用于LocalDate
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        //格式化
        String str3 = formatter2.format(LocalDate.now());
        System.out.println(str3);//2019-2-18


//       重点： 方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String str4 = formatter3.format(LocalDateTime.now());
        System.out.println(str4);//2019-02-18 03:52:09

        //解析
        TemporalAccessor accessor = formatter3.parse("2019-02-18 03:52:09");
        System.out.println(accessor);

    }

    @Test
    public void test4 (){
//        重点： 方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String str4 = formatter3.format(LocalDateTime.now());
        System.out.println(str4);//2019-02-18 03:52:09

        //解析
        TemporalAccessor accessor = formatter3.parse("2019-02-18 03:52:09");
        System.out.println(accessor);
    }
}
