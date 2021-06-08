package cn.mldn.java13thread;

/**
 * 说明：volatile关键字的使用
 * @author：李尚兴
 * @date：2020-07-21 23:34
 * @version：1.0
 */
public class VolatileThreadTest {
    public static void main(String[] args) {
        SaleTicket saleTicket = new SaleTicket();
        new Thread(saleTicket, "票贩子 - A").start();
        new Thread(saleTicket, "票贩子 - B").start();
        new Thread(saleTicket, "票贩子 - C").start();
    }
}
class SaleTicket implements Runnable {
    private volatile int ticket = 3;
    @Override
    public void run() {
        while (this.sale()) {
            ;
        }
    }

    public synchronized boolean sale() {
        if (this.ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "售票，剩余票数为：" + (--this.ticket));
            return true;
        }
        return false;
    }
}