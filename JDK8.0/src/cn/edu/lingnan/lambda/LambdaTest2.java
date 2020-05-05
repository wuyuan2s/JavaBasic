package cn.edu.lingnan.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author wuyuan
 * @create 2020-05-03 16:41
 *
 *
 * * java内置的4大核心函数式接口
 *  *
 *  * 消费型接口 Consumer<T>     void accept(T t)
 *  * 供给型接口 Supplier<T>     T get()
 *  * 函数型接口 Function<T,R>   R apply(T t)
 *  * 断定型接口 Predicate<T>    boolean test(T t)
 */
public class LambdaTest2 {

    @Test
    public void test(){
        happyTime(10, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("学习太累了，去爱奇艺冲会员，价格为：" + aDouble);
            }
        });
        System.out.println("***********************************");

        happyTime(20, money -> System.out.println("学习太累了，去腾讯冲会员，价格为：" + money));
    }



    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }


    @Test
    public void test2(){
        List<String> list = Arrays.asList("北京", "南京","东京","北京","深圳","广州","茂名");
        
        List<String> resultList = new ArrayList<>();
        resultList = filterStr(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        for (String s :
                resultList) {
            System.out.println(s);
        }

        System.out.println("********lambda表达式*********");

        resultList = filterStr(list, s -> s.contains("京"));

        for (String s :
                resultList) {
            System.out.println(s);
        }
    }


//    根据给定的规则，过滤集合中的字符串。此规则由Predicate的方法决定
    public List<String> filterStr(List<String> list, Predicate<String> pred){
        List<String> newList = new ArrayList<>();
        for (String str :
                list) {
            if (pred.test(str)){
                newList.add(str);
            }
        }
        return newList;
    }

}
