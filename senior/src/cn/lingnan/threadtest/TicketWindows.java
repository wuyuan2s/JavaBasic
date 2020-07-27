package cn.lingnan.threadtest;

/**
 * @author wuyuan
 * @create 2020-04-14 15:46
 */
public class TicketWindows {
    public static void main(String[] args) {
        Windows windows1 = new Windows();
        Windows windows2 = new Windows();
        Windows windows3 = new Windows();
        windows1.start();
        windows2.start();
        windows3.start();

    }


}

class Windows extends Thread {
    private static int ticket = 100;
    
    @Override
    public void run() {
        while (true){
        if (ticket > 0) {
            System.out.println("第" + ticket + " 张票");
            ticket--;
            } else {
            break;
        }
        }
    }
}