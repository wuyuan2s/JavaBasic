package stringtest;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author wuyuan
 * @create 2020-04-17 17:53
 */
public class StringTest2 {
    /*
        String --> 基本数据类型、包装类：调用包装类的静态方法：parseXxx(str)
        基本数据类型、包装类 --> String:调用String重载的valueOf(xxx)
     */
    @Test
    public void test1(){
        String str1 = "123";//str21在常量池里
//        int num = (int)str1;//错误的
        int num = Integer.parseInt(str1);

        String str2 = String.valueOf(num);//"123"
        String str3 = num + "";//str3在堆内存中

        System.out.println(str1 == str3);
    }

    /*


    与字符数组之间的转换
    String --> char[]:调用String的toCharArray()
    char[] --> String:调用String的构造器
    */
    @Test
    public void test2(){
        String str1 = "abc123";  //题目： a21cb3

        char[] charArray = str1.toCharArray();//String转换为char型数组
        char[] newChar;
        newChar = charArray.clone();
        int j = 1;
        for (int i = charArray.length-2; i > 0; i--) {
            newChar[j++] = charArray[i];
        }
//        for (int i = 0; i < charArray.length; i++) {
//            System.out.println(newChar[i]);
//        }
        String s2 = new String(newChar);
        System.out.println(s2);

        char[] arr = new char[]{'h','e','l','l','o'};
        String str2 = new String(arr);
        System.out.println(str2);
    }

    @Test
    public void test3() throws UnsupportedEncodingException {
        String str = "abc中国";
        byte[] bytes = str.getBytes();//使用默认的字符集utf-8进行编码
        System.out.println(Arrays.toString(bytes));

        byte[] gbks = str.getBytes("gbk");//使用gbk字符集进行编码
        System.out.println(Arrays.toString(gbks));

        System.out.println();

        String str2 = new String(bytes);//使用默认的字符集utf-8，进行解码
        System.out.println(str2);

        String str3 = new String(gbks);
        //编码集和解码集不一致
        System.out.println(str3);//结果：abc�й�;

        String str4 = new String(gbks,"gbk");//手动设置编码集
        System.out.println(str4);//


    }
}
