package oop.exercise;

/**
 * @author wuyuan
 * @create 2020-04-22 22:48
 */
public class StringTest {
    public static void main(String[] args) {
        String string1 = "ab";
        String string2 = "cd";
        String string3 = "abcd";
        String string4 = "ab" + "cd";
         string1 += "cd";
        System.out.println(string1);
        System.out.println(string4);

        System.out.println(string3 == string4);
        System.out.println(string3 == string1);

    }



}
