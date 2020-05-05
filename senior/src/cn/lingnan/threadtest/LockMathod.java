package cn.lingnan.threadtest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wuyuan
 * @create 2020-04-15 16:04
 *
 * 方式三：Lock锁  --- JDK5.0新增
 * *
 * * 1. 面试题：synchronized 与 Lock的异同？
 * *   相同：二者都可以解决线程安全问题
 * *   不同：synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器
 * *        Lock需要手动的启动同步（lock()，同时结束同步也需要手动的实现（unlock()）
 *
 * 使用的优先顺序：
 * * Lock ---> 同步代码块（已经进入了方法体，分配了相应资源 ) ---> 同步方法（在方法体之外)
 */
public class LockMathod {

    public static void main(String[] args) {
        Windows6 windows5 = new Windows6();
        Thread t1 = new Thread(windows5);
        Thread t2 = new Thread(windows5);
        Thread t3 = new Thread(windows5);
        t1.setName("窗口一：");
        t2.setName("窗口一：");
        t3.setName("窗口一：");
        t1.start();
        t2.start();
        t3.start();
    }
}

class Windows6 implements Runnable {
    private int ticket = 100;
    //实例化Reentrantlock lock
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "买第：" + ticket + "张票");
                    ticket--;
                }else{
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}