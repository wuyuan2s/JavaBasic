package cn.lingnan.threadtest;

/**
 * @author wuyuan
 * @create 2020-04-13 23:38
 *
 * 1. start():启动当前线程；调用当前线程的run()
 * 2. run(): 通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
 * 3. currentThread():静态方法，返回执行当前代码的线程
 * 4. getName():获取当前线程的名字
 * 5. setName():设置当前线程的名字
 * 6. yield():释放当前cpu的执行权,有可能释放后再次获得CPU执行权，也可能被其它线程占用CPU
 * 7. join():在线程a中调用线程b的join(),此时线程a就进入阻塞状态，直到线程b完全执行完以后，线程a才结束阻塞状态。
 */
public class ThreadSetName {
    public static void main(String[] args) {
        ThreadFour threadFour = new ThreadFour();
        threadFour.setName("分线程一");
        threadFour.start();

        Thread.currentThread().setName("主线程");
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            if (i == 20) {
                try {
//              7. join():在线程a中调用线程b的join(),此时线程a就进入阻塞状态，
//                        直到线程b完全执行完以后，线程a才结束阻塞状态。
                    threadFour.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}

class ThreadFour extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            if(i % 20 == 0){
//                6. yield():释放当前cpu的执行权,有可能释放后再次获得CPU执行权，也可能被其它线程占用CPU
//                this.yield();

            }

        }
    }
}