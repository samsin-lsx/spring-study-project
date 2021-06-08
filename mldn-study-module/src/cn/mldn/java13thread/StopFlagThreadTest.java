package cn.mldn.java13thread;

/**
 * 说明：优雅的停止线程执行（有效避免死锁的产生）
 * @author：李尚兴
 * @date：2020-07-21 22:59
 * @version：1.0
 */
public class StopFlagThreadTest {
    public static void main(String[] args) {
        MessageStopFlag messageStopFlag = new MessageStopFlag();
        new Thread(messageStopFlag).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        messageStopFlag.stop();
    }
}
class MessageStopFlag implements Runnable {
    private boolean stopFlag = false; // 线程停止的标记
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            if (this.stopFlag) {
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Message类信息输出：i = " + i);
        }
    }
    public void stop() {
        this.stopFlag = true;
    }
}