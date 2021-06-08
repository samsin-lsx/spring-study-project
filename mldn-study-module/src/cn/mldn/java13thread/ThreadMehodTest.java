package cn.mldn.java13thread;

/**
 * 说明：线程买票问题
 * @author：李尚兴
 * @date：2020-07-17 0:59
 * @version：1.0
 */
public class ThreadMehodTest {
    private static int ticket = 5;

    public static void main(String[] args) {
        Runnable body = () -> {
            while (true) {
                synchronized (ThreadMehodTest.class) {
                    if (ticket > 0) {
                        try {
                            Thread.sleep(1000); // 模拟网络延迟
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("【" + Thread.currentThread().getName() + "】售票，剩余票数：" + (--ticket));
                    } else {
                        break;
                    }
                }
            }
        };
        for (int i = 0; i < 5; i++) { // 启动5个线程买票
            new Thread(body, "票贩子 - " + i).start();
        }
    }
}
