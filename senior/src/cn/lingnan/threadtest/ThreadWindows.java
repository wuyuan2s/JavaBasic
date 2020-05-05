package cn.lingnan.threadtest;

/**
 * @author wuyuan
 * @create 2020-04-15 11:34
 *
 * *   synchronized(同步监视器){
 * *      //需要被同步的代码
 * *
 * *   }
 * *  说明：1.操作共享数据的代码，即为需要被同步的代码。  -->不能包含代码多了，也不能包含代码少了。
 * *       2.共享数据：多个线程共同操作的变量。比如：ticket就是共享数据。
 * *       3.同步监视器，俗称：锁。任何一个类的对象，都可以充当锁。
 * *          要求：多个线程必须要共用同一把锁。
 * *
 * * 补充：在实现Runnable接口创建多线程的方式中，我们可以考虑使用this充当同步监视器。
 *        在继承Thread类创建多线程的方式中，慎用this充当同步监视器，
 *        考虑使用当前类充当同步监视器。
 *
 * *  关于同步方法的总结：
 * *  1. 同步方法仍然涉及到同步监视器，只是不需要我们显式的声明。
 * *  2. 非静态的同步方法，同步监视器是：this
 * *     静态的同步方法，同步监视器是：当前类本身
 *
 */
public class ThreadWindows {

    public static void main(String[] args) {
//        Windows3 windows1 = new Windows3();
//        Windows3 windows2 = new Windows3();
//        Windows3 windows3 = new Windows3();
        Windows5 windows1 = new Windows5();
        Windows5 windows2 = new Windows5();
        Windows5 windows3 = new Windows5();

        windows1.setName("窗口一");
        windows2.setName("窗口二");
        windows3.setName("窗口三");
        windows1.start();
        windows2.start();
        windows3.start();
    }

}

class Windows3 extends Thread{
    private static int ticket = 100;
    //   多个线程必须要共用同一把锁
    private static Object object = new Object();
    @Override
    public void run() {
        while (true) {
//            继承Thread的方式必须要new一个对象，因为它的子类创建了多个对象，ticket也必须是static的
//            synchronized (object) {
            synchronized(Windows3.class){//考虑使用当前类充当同步监视器，类只会加载一次
//            而实现Runnable接口则只new了一个对象
//          synchronized (this) {//this表示windows1,windows2,windows3三个不同的对象
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖第：" + ticket + "张票");
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
/**
 * 使用同步方法来实现继承Thread的线程安全问题！
 *
 * */

class Windows5 extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        while(true){
            doRun();
        }
    }

    private static synchronized void doRun (){//同步监视器是Windows5.class
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖第：" + ticket + "张票");
            ticket--;
        }
    }
}