package cn.lingnan.threadtest;

/**
 * @author wuyuan
 * @create 2020-04-15 16:44
 *
 * 1.线程通信涉及到的三个方法：
 * * wait():一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器。
 * * notify():一旦执行此方法，就会唤醒被wait的一个线程。如果有多个线程被wait，就唤醒优先级高的那个。
 * * notifyAll():一旦执行此方法，就会唤醒所有被wait的线程。
 *
 * 2.说明：
 * * 1.wait()，notify()，notifyAll()三个方法必须使用在同步代码块或同步方法中。
 * * 2.wait()，notify()，notifyAll()三个方法的调用者必须是同步代码块或同步方法中的同步监视器。
 * *    否则，会出现IllegalMonitorStateException异常
 * * 3.wait()，notify()，notifyAll()三个方法是定义在java.lang.Object类中。
 */
public class NumberTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);
        t1.setName("线程一");
        t2.setName("线程二");
        System.out.println("两个线程交替打印1-100的数字");
        t1.start();
        t2.start();
    }
}

class Number implements Runnable {
    private int number = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                //当第一个线程进入下面的wait（）方法时进入阻塞状态；并且会释放锁
//                第二个线程进入notify（）方法时唤醒第一个线程为运行状态，并且获得同步锁
//                如果有多个线程被wait，则使用notifyAll（）方法，就唤醒优先级高的
                notify();
                if (number <= 100) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "打印：" + number);
                    number++;

                    try {
                        wait();//线程被wait，并且释放同步锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}