package oop.questions;

import java.io.PrintStream;

/**
 * @author wuyuan
 * @create 2020-04-02 21:38
 */

public class Question1 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
//        method(a,b);//第一种方式
        method2(a,b);//第二种方式

//        需要在method方法被调用后，仅打印出a=100，b=200，请写出method的方法体；
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
    public static void method(int a, int b){
        a = 100;
        b = 200;
        System.out.println(a);
        System.out.println(b);
        System.exit(0);//终止当前程序
    }

//    -----通过重写println（）方法实现输出----
    public static void method2(int a, int b){
                  PrintStream ps = new PrintStream(System.out){
                      @Override
                      public void println(String x){
                          if("a = 10".equals(x)){
                  x = "a = 100";
              }else if ("b = 20".equals(x)){
                  x = "b = 200";
              }
              super.println(x);
          }
        };
        System.setOut(ps);
    }
}
