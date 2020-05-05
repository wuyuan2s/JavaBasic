package cn.lingnan.threadtest;

import java.sql.PseudoColumnUsage;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author wuyuan
 * @create 2020-04-15 23:09
 *
 * 创建线程的方式四：使用线程池
 *
 * * 好处：
 * * 1.提高响应速度（减少了创建新线程的时间）
 * * 2.降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 * * 3.便于线程管理
 * *      corePoolSize：核心池的大小
 * *      maximumPoolSize：最大线程数
 * *      keepAliveTime ：线程没有任务时最多保持多长时间会终止
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
//        1.提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
//        体现便于线程的管理：设置线程池的一些属性
        ThreadPoolExecutor setService = (ThreadPoolExecutor)service;
//        setService.setCorePoolSize(); 核心池的大小
//        setService.setMaximumPoolSize();最大线程数
//        setService.setKeepAliveTime();线程没有任务时最多保持多长时间会终止

//      2.执行指定的线程的操作，需要提供实现Runnable接口或Callable接口实现类的对象
        service.execute(new Number2());//适用于Runnable
        service.execute(new Number3());//适用于Runnable
    //    service.submit();//适用于callable
//        3.关闭连接池
        service.shutdown();
    }
}

class Number2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

        }
    }
}

class Number3 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

        }
    }
}