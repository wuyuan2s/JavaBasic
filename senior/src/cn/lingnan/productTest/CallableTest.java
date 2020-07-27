package cn.lingnan.productTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author wuyuan
 * @create 2020-04-15 18:08
 *
 *  如何理解实现Callable接口的方式创建多线程比实现Runnable接口创建多线程方式强大？
 * * 1. call()可以返回值的。
 * * 2. call()可以抛出异常，被外面的操作捕获，获取异常的信息
 * * 3. Callable是支持泛型的
 */
public class CallableTest {

    public static void main(String[] args) {
        //3.创建Callable接口实现类的对象
        NumSum numSum = new NumSum();
//      4.将此Callable接口实现类的对象作为传递到FutureTask构造器中，
//      创建FutureTask的对象
        FutureTask<Integer> futureTask = new FutureTask<>(numSum);
//      5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，
//      并调用start()
        new Thread(futureTask).start();

        Object sum = null;
        try {
            //6.获取Callable中call方法的返回值
            //get()返回值即为FutureTask构造器参数Callable实现类重写的call()的返回值。
            sum = futureTask.get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("一百以内的偶数和：" + sum);

    }
}

//1.创建一个实现Callable的实现类
class NumSum implements Callable<Integer>{
    //2.实现call方法，将此线程需要执行的操作声明在call()中
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i%2 == 0){
                System.out.println(i);
                sum += i;

            }
        }
        return sum;
    }
}