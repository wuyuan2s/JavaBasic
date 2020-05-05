package cn.lingnan.threadtest;

/**
 * @author wuyuan
 * @create 2020-04-13 22:20
 *
 * * >>>创建线程的第一种方式:继承Thread类的方式：
 * * 1. 创建一个继承于Thread类的子类
 * * 2. 重写Thread类的run() --> 将此线程执行的操作声明在run()中
 * * 3. 创建Thread类的子类的对象
 * * 4. 通过此对象调用start()：①启动当前线程 ② 调用当前线程的run()
 */
public class MyThread {
    public static void main(String[] args) {
//      3. 创建Thread类的子类的对象
        ThreadOne threadOne = new ThreadOne();

//      4. 通过此对象调用start()：①启动当前线程 ② 调用当前线程的run()
        threadOne.start();

//     下面的for循环在main线程（主线程）下运行，上面的start方法是另一个线程同步运行
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.print(Thread.currentThread().getName() + ":");
                System.out.println(i);
            }
        }
//        问题二：如果再启动一个线程，必须重新创建一个Thread子类的对象，调用此对象的start().
//          threadOne.start();//错误的
            ThreadOne threadOne2 = new ThreadOne();//正确的
             threadOne2.start();
    }
}

//1. 创建一个继承于Thread类的子类
class ThreadOne extends Thread{
    // 2. 重写Thread类的run() --> 将此线程执行的操作声明在run()中
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.print(Thread.currentThread().getName() + ":");
                System.out.println(i);
            }
        }
    }
}
