package cn.mldn.java13thread;

/**
 * 说明：买票程序（Runnable接口实现数据共享的概念）
 * @author：李尚兴
 * @date：2020-07-16 23:52
 * @version：1.0
 */
public class TicketThreadTest {
    public static void main(String[] args) {
        MyTicketThread myTicketThread = new MyTicketThread();
        Thread saleThreadA = new Thread(myTicketThread);
        Thread saleThreadB = new Thread(myTicketThread);
        Thread saleThreadC = new Thread(myTicketThread);
        saleThreadA.start();
        saleThreadB.start();
        saleThreadC.start();
    }
}

class MyTicketThread implements Runnable {
    private int ticket = 5;
    @Override
    public void run() {
        while (this.ticket > 0) {
            if (this.ticket > 0) {
                System.out.println("开始买票，票数剩余：" + this.ticket--);
            } else {
                break;
            }
        }
    }
}
