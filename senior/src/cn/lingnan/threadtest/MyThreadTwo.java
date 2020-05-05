package cn.lingnan.threadtest;

/**
 * @author wuyuan
 * @create 2020-04-13 23:21
 */
public class MyThreadTwo {
    public static void main(String[] args) {
//        ThreadTwo threadTwo = new ThreadTwo();
//        ThreadThree threadThree = new ThreadThree();
//        threadTwo.start();
//        threadThree.start();
//        创建Thread的匿名子类方式
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if(i % 2 == 0){
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }

                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if(i % 2 != 0){
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }

                }
            }
        }.start();
    }
}


class ThreadTwo extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

        }
    }
}

class ThreadThree extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

        }
    }
}
