package oop.questions;

/**
 * @author wuyuan
 * @create 2020-04-02 22:02
 */
public class Question2 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        System.out.println(arr);//调用public void println(@Nullable Object x)，输出地址值

        char [] arr2 = new char[]{'a','b','c'};
        System.out.println(arr2);//调用public void println(@NotNull char[] x)，输出char类型数组abc
    }
}
