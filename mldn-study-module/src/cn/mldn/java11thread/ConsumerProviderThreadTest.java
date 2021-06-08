package cn.mldn.java11thread;

/**
 * 实现生产者与消费者模型：案例分析
 */
public class ConsumerProviderThreadTest {
    public static void main(String[] args) {
        Message message = new Message();
        Producer pro = new Producer(message);
        Consumer con = new Consumer(message);
        new Thread(pro).start();
        new Thread(con).start();
    }
}
class Producer implements Runnable {
    private Message message;
    public Producer(Message message) {
        this.message = message;
    }
    @Override
    public void run() {
        for (int x = 0; x < 50; x++) {
            if (x % 2 == 0) {
                this.message.set("李大叔", "天下第一大帅哥！");
            } else {
                this.message.set("老方B", "世间闻名大奸雄！");
            }
        }
    }
}
class Consumer implements Runnable {
    private Message message;
    public Consumer(Message message) {
        this.message = message;
    }
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            this.message.get();
        }
    }
}
class Message {
    private String title;
    private String content;
    private boolean flag = true;
    // flag = true表示可以生产，但不可以消费
    // flag = false表示可以消费，但不可以生产
    public synchronized void set(String title, String content) {
        if (this.flag == false) { // 已经生产过了，不可以生产，需要等待消费
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.title = title;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.content = content;
        this.flag = false; // 生产过了
        super.notify(); // 唤醒其他等待线程
    }
    public synchronized void get() {
        if (this.flag == true) { // 此时应该生产
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.title + " - " + this.content);
        this.flag = true; // 表示应该恢复生产
        super.notify(); // 唤醒其他等待线程
    }
}
