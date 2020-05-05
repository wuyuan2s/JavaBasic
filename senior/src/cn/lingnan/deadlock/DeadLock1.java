package cn.lingnan.deadlock;

/**
 * @author wuyuan
 * @create 2020-04-15 13:41
 *
 * 不同的线程分别占用对方需要的同步资源不放弃，
 * 都在等待对方放弃自己需要的同步资源，
 * 就形成了线程的死锁
 *
 * 例子：
 * 第一个线程中：
 * 得到s1锁后，进入sleep后等待s2锁
 * 下面的线程可能运行，
 * 此时第二个进程得到s2锁后等待s1锁
 */
public class DeadLock1 {
    public static void main(String[] args) {
//        String s1 = null;
//        String s2 = null;
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        new Thread(){
            @Override
            public void run() {
                synchronized (s1){
                    s1.append("a");
                    s2.append("1");
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (s2){
                        s1.append("b");
                        s2.append("2");
                    }
                }
                System.out.println(s1);
                System.out.println(s2);
            }
        }.start();
        new Thread(new Runnable(){
            public void run() {
                synchronized (s2){
                    s1.append("c");
                    s2.append("3");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (s1){
                        s1.append("d");
                        s2.append("4");
                    }
                }
                System.out.println(s1);
                System.out.println(s2);
            }
        }).start();
    }

}
