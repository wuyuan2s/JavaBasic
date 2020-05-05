package cn.edu.lingnan.methodref;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author wuyuan
 * @create 2020-05-03 17:39
 *
 *
 * /**
 *  * 方法引用的使用
 *  *
 *  * 1.使用情境：当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用！
 *  *
 *  * 2.方法引用，本质上就是Lambda表达式，而Lambda表达式作为函数式接口的实例。所以
 *  *   方法引用，也是函数式接口的实例。
 *  *
 *  * 3. 使用格式：  类(或对象) :: 方法名
 *  *
 *  * 4. 具体分为如下的三种情况：
 *  *    情况1     对象 :: 非静态方法
 *  *    情况2     类 :: 静态方法
 *  *
 *  *    情况3     类 :: 非静态方法
 *  *
 *  * 5. 方法引用使用的要求：要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的
 *  *    形参列表和返回值类型相同！（针对于情况1和情况2）
 *  *
 *  * Created by shkstart.
 *  *
 */
public class MethodRefTest {

    // 情况一：对象 :: 实例方法
    //Consumer中的void accept(T t)
    //PrintStream中的void println(T t)
    @Test
    public void test(){
        Consumer<String> con = str -> System.out.println(str);
        con.accept("lambda表达式！");

        System.out.println("======方法引用情况一：对象 :: 实例方法====");


        PrintStream ps = System.out;
        Consumer<String> con2 = ps :: println;
        con2.accept("方法引用！");

    }

    // 情况二：类 :: 静态方法
    //Comparator中的int compare(T t1,T t2)
    //Integer中的int compare(T t1,T t2)
    @Test
    public void test2(){
        Comparator<Integer> comp = (t1, t2) -> t1.compareTo(t2);
        System.out.println(comp.compare(1, 2));

        System.out.println("情况二：类 :: 静态方法");

        Comparator<Integer> comp2 = Integer::compareTo;
        System.out.println(comp2.compare(100, 50));

    }

    //Function中的R apply(T t)
    //Math中的Long round(Double d)
    @Test
    public void test4() {
        Function<Double,Long> func = new Function<Double, Long>() {
            @Override
            public Long apply(Double d) {
                return Math.round(d);
            }
        };

        System.out.println("*******************");

        Function<Double,Long> func1 = d -> Math.round(d);
        System.out.println(func1.apply(12.3));

        System.out.println("********参数类型相同，返回值类型相同***********");

        Function<Double,Long> func2 = Math::round;
        System.out.println(func2.apply(12.6));
    }

    // 情况三：类 :: 实例方法  (有难度)
    // Comparator中的int comapre(T t1,T t2)
    // String中的int t1.compareTo(t2)
//    前一个参数作为方法的调用者，第二个参数为方法的参数
    @Test
    public void test3(){
        Comparator<String> com = (t1, t2) -> t1.compareTo(t2);
        System.out.println(com.compare("a", "c"));

        System.out.println("情况三：类 :: 实例方法  (有难度)");

        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("c", "a"));
    }
    //BiPredicate中的boolean test(T t1, T t2);
    //String中的boolean t1.equals(t2)
    @Test
    public void test5() {
        BiPredicate<String,String> pre1 = (s1, s2) -> s1.equals(s2);
        System.out.println(pre1.test("abc","abc"));

        System.out.println("*******************");
        BiPredicate<String,String> pre2 = String :: equals;
        System.out.println(pre2.test("abc","abd"));
    }

    // Function中的R apply(T t)
    // Employee中的String getName();
    @Test
    public void test7() {
        /*Employee employee = new Employee(1001, "Jerry", 23, 6000);


        Function<Employee,String> func1 = e -> e.getName();
        System.out.println(func1.apply(employee));

        System.out.println("*******************");


        Function<Employee,String> func2 = Employee::getName;
        System.out.println(func2.apply(employee));*/

    }
}
