package cn.lingnan.threadtest;

/**
 * @author wuyuan
 * @create 2020-04-15 11:11
 *
 * synchronized(同步监视器){
 * *      //需要被同步的代码
 * *
 * *   }
 * *  说明：1.操作共享数据的代码，即为需要被同步的代码。  -->不能包含代码多了，也不能包含代码少了。
 * *       2.共享数据：多个线程共同操作的变量。比如：ticket就是共享数据。
 * *       3.同步监视器，俗称：锁。任何一个类的对象，都可以充当锁。
 * *          要求：多个线程必须要共用同一把锁。
 * *
 * * 补充：在实现Runnable接口创建多线程的方式中，我们可以考虑使用this充当同步监视器。
 *        在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器。
 *
 *   Windows类中：使用同步方法处理实现Runnable接口的线程同步问题
 */
public class TicketWindows2 {
    public static void main(String[] args) {
        Windows4 windows2 = new Windows4();
//        Thread t1 = new Thread(windows2);
//        Thread t2 = new Thread(windows2);
//        Thread t3 = new Thread(windows2);
        Thread t1 = new Thread(windows2);
        Thread t2 = new Thread(windows2);
        Thread t3 = new Thread(windows2);
        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");
        t1.start();
        t2.start();
        t3.start();
    }


}

class Windows2 implements Runnable{
    private int ticket = 100;
//   多个线程必须要共用同一把锁
    private static Object object = new Object();
    @Override
    public void run() {
        while (true) {
//            继承Thread的方式必须要new一个对象，因为它的子类创建了多个对象，ticket也必须是static的
//            synchronized (object) {
//            而实现Runnable接口则只new了一个对象
                synchronized (this) {//this表示唯一的window2对象
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

class Windows4 implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            doRun();
        }
    }

    private synchronized void doRun() {//此时同步监视器是this
        if (ticket > 0) {
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
}
