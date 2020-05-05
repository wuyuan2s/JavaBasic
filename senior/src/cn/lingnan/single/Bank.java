package cn.lingnan.single;

/**
 * @author wuyuan
 * @create 2020-04-15 13:18
 */
public class Bank {
    private Bank(){}
    private static Bank instance = null;
    public static synchronized Bank getInstance(){//线程已经是安全的
        if (instance == null){
            instance = new Bank();
        }
        return instance;
    }
    private static Bank getInstance2() {
        //方式一：效率较差
//        synchronized (Bank.class) {
//            if (instance == null) {
//                instance = new Bank();
//            }
//            return instance;
//        }
        //方式二：效率较高，后来的线程不再等待
        if (instance == null){
            synchronized (Bank.class) {
                instance = new Bank();
            }
        }
        return instance;
    }
}
