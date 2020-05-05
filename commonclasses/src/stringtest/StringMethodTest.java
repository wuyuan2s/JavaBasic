package stringtest;

import org.junit.Test;

/**
 * @author wuyuan
 * @create 2020-04-17 11:35
 */
public class StringMethodTest {
    /*
    int length()：返回字符串的长度： return value.length
char charAt(int index)： 返回某索引处的字符return value[index]
boolean isEmpty()：判断是否是空字符串：return value.length == 0
String toLowerCase()：使用默认语言环境，将 String 中的所字符转换为小写
String toUpperCase()：使用默认语言环境，将 String 中的所字符转换为大写
String trim()：返回字符串的副本，忽略前导空白和尾部空白
boolean equals(Object obj)：比较字符串的内容是否相同
boolean equalsIgnoreCase(String anotherString)：与equals方法类似，忽略大小写
String concat(String str)：将指定字符串连接到此字符串的结尾。 等价于用“+”
int compareTo(String anotherString)：比较两个字符串的大小
String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后的一个子字符串。
String substring(int beginIndex, int endIndex) ：返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。
     */

    @Test
    public void test1(){
        String s1 = "helloworld";
        System.out.println(s1.length());
        System.out.println(s1.charAt(0));
        System.out.println(s1.charAt(9));

        System.out.println(s1.isEmpty());//判断是否是空字符串
        System.out.println(s1.toUpperCase());
        String s2 = s1.toUpperCase();
        System.out.println("s2: " + s2 + "    " + "s1: " + s1);//s1.toUpperCase和s1.toLowerCase方法不会修改s1的值

    }
    @Test
    public void test2(){

//        String trim()：返回字符串的副本，忽略前导空白和尾部空白
        String s1 = "   s1  2   3     ";
        String s2 = s1.trim();
        System.out.println("---" + s1 + "---");
        System.out.println("---" + s2 + "---");

//        boolean equalsIgnoreCase(String anotherString)：与equals方法类似，忽略大小写
        String s3 = "HelloWorld!";
        String s4 = "helloworld!";
        System.out.println(s3.equalsIgnoreCase(s4));//ture

        String s5 = "abc";
        String s6 = "abd";
//        s.compareTo(s2)字符串排序，返回负数 s<s2, elseif 返回正数 s>s2 else =
        System.out.println(s5.compareTo(s6));

        String s7 = "HelloWorld!";
        //String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后的一个子字符串。
        System.out.println(s7.substring(8));
//        String substring(int beginIndex, int endIndex) ：返回一个新字符串，
//        它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。
//        左闭右开：
        System.out.println(s7.substring(0,5));
    }

    /*
    boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束
    boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始
    boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的子字符串是否以指定前缀开始

    boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列时，返回 true
    int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
    int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
    int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引
    int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索

    注：indexOf和lastIndexOf方法如果未找到都是返回-1
     */
    @Test
    public void test3(){
        String s1 = "helloworld";
        System.out.println(s1.endsWith("d"));
        System.out.println(s1.startsWith("h"));

//        测试此字符串从指定索引开始的子字符串是否以指定前缀开始
        System.out.println(s1.startsWith("llo",2));

//        当且仅当此字符串包含指定的 char 值序列时，返回 true
        String s2 = "helloworld";
        System.out.println(s1.contains(s2));

//        注：indexOf和lastIndexOf方法如果未找到都是返回-1
//        int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
        System.out.println(s2.indexOf("l"));
//        int indexOf(String str, int fromIndex)：
        System.out.println("返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始");
        System.out.println(s2.indexOf("wor",2));
//        int lastIndexOf(String str, int fromIndex)：
//        返回指定子字符串在此字符串中最后一次出现处的索引，
//        从指定的索引开始反向搜索
        System.out.println("从指定的索引开始反向搜索：" + s2.lastIndexOf("wor",10));


    }

    /*
    替换：
    String replace(char oldChar, char newChar)：返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所 oldChar 得到的。
    String replace(CharSequence target, CharSequence replacement)：使用指定的字面值替换序列替换此字符串所匹配字面值目标序列的子字符串。
    String replaceAll(String regex, String replacement)：使用给定的 replacement 替换此字符串所匹配给定的正则表达式的子字符串。
    String replaceFirst(String regex, String replacement)：使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。
    匹配:
    boolean matches(String regex)：告知此字符串是否匹配给定的正则表达式。
    切片：
    String[] split(String regex)：根据给定正则表达式的匹配拆分此字符串。
    String[] split(String regex, int limit)：根据匹配给定的正则表达式来拆分此字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中。
         */
    @Test
    public void test4(){
        String s1 = "岭南师范学院";
        String s2 = "嘻嘻哈哈开开心心";

        //返回新的一个字符串，原来的不变
        System.out.println(s1.replace("南", "北"));
        System.out.println(s2.replace("哈", "呱"));
        System.out.println(s1);
        System.out.println(s2);
//        String replace(CharSequence target, CharSequence replacement)
//        字符序列：
        System.out.println(s1.replace("岭南", "南岭"));
    }
}
