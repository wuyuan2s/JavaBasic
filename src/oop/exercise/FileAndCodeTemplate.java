package oop.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @author wuyuan
 * @create 2020-03-25 18:39
 */
/*
* 多行注释的颜色
 */
//单行注释
public class FileAndCodeTemplate {
    public static void main(String[] args) {
        System.out.println("jj");
        System.out.println("args = " + Arrays.deepToString(args));//soutp
        System.out.println("FileAndCodeTemplate.main");//soutm
        System.out.println("args = " + args);//soutv
        System.out.println("true = " + true);
        System.out.println("string");//"strng".sout
        Random random = new Random();
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = random.nextInt(31);
            System.out.println(a[i]);
        }
        for (int i : a) {//itar
            System.out.println(i);
        }

        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        for (int i = 0; i < list.size(); i++) {//list.fori
            System.out.println(list.get(i));
        }
        for (int i = list.size() - 1; i >= 0; i--) {//list.forr
            System.out.println(list.get(i));
        }
        String str = "S";
    }
    public String Hello = "world";
    public String s = "saa";
}
