package cn.lingnan.threadtest;

/**
 * @author wuyuan
 * @create 2020-04-14 15:57
 *
 * * 1. 创建一个实现了Runnable接口的类
 * * 2. 实现类去实现Runnable中的抽象方法：run()
 * * 3. 创建实现类的对象
 * * 4. 将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * * 5. 通过Thread类的对象调用start()
 *
 * * 开发中：优先选择：实现Runnable接口的方式
 * * 原因：1. 实现的方式没类的单继承性的局限性
 * *      2. 实现的方式更适合来处理多个线程共享数据的情况。
 * *
 * * 联系：public class Thread implements Runnable
 * * 相同点：两种方式都需要重写run(),将线程要执行的逻辑声明在run()中。
 */
public class RunnableTest {
    public static void main(String[] args) {
//       3. 创建实现类的对象
        Runable1 runable1 = new Runable1();
//       4. 将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread t1 = new Thread(runable1);
        Thread t2 = new Thread(runable1);
        Thread t3 = new Thread(runable1);
        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");
//        5. 通过Thread类的对象调用start()
        t1.start();
        t2.start();
        t3.start();
    }
}

/**
 *1. 创建一个实现了Runnable接口的类
 */
class Runable1 implements Runnable {
//    即使不加static关键字也可以共享ticket
//    因为只需new一个Runable1的对象；
    private int ticket = 100;

//    2. 实现类去实现Runnable中的抽象方法：run()
    @Override
    public void run() {
        while (true){
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "卖第：" + ticket + " 张票");
                ticket--;
            }else{
                break;
            }
        }
    }
}