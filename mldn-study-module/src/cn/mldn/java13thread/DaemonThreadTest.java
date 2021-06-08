package cn.mldn.java13thread;

/**
 * 说明：守护线程
 * @author：李尚兴
 * @date：2020-07-21 23:11
 * @version：1.0
 */
public class DaemonThreadTest {
    public static void main(String[] args) {
        new Thread(new MessageDaemon()).start();
    }
}
class MessageDaemon implements Runnable {
    public MessageDaemon() {
        Thread threadDaemon = new Thread(() -> {
            for (int x = 0; x < Integer.MAX_VALUE; x++) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("〖守护线程信息输出〗x = " + x);
            }
        });
        threadDaemon.setDaemon(true); // 设置为守护线程
        threadDaemon.start(); // 启动守护线程
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("【Message类信息输出】i = " + i);
        }
    }
}