package stringtest;

/**
 * @author wuyuan
 * @create 2020-04-17 11:02
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

//        当拼接中都是字面量，则拼接后的字符串存储在方法区中
//        即常量跟常量的拼接都在常量池中，
//        当拼接时有变量参与，则会在堆内存中开辟空间，存储一个地址指向方法区中；
        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s3 == s7);//false
        System.out.println(s5 == s6);//false
        System.out.println(s5 == s7);//false
        System.out.println(s6 == s7);//false

        String s8 = s6.intern();//返回值得到的s8使用的常量值中已经存在的“javaEEhadoop”
        System.out.println(s3 == s8);//true
        
        final String s9 = "javaEE";//加final后s9为常量
        String s10 = s9 + "hadoop";
        System.out.println(s3 == s10);//结果为true，常量拼接
        
    }
}
