package cn.mldn.java13thread;

/**
 * 说明：生产者与消费者模型
 * @author：李尚兴
 * @date：2020-07-19 23:57
 * @version：1.0
 */
public class ProducerConsumerThreadTest {
    public static void main(String[] args) {
        Message message = new Message();
        new Thread(new ProducerThread(message)).start(); // 启动生产者线程
        new Thread(new ConsumerThread(message)).start(); // 启动消费者线程
    }
}

class Message {
    private String title;
    private String content;
    private boolean flag = true; // 标志位，用于控制生产与消费的标记
    // flag = true：表示可以生产，但是不允许消费
    // flag = false：表示可以消费，但是不允许生产
    public synchronized void set(String title, String content) {
        if (this.flag == false) { // 可以消费，不允许生产
            try {
                super.wait(); // 需要等待生产线程生产完毕后再执行
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
        this.flag = false; // 表示生产完成，可以消费了
        super.notify();
    }

    public synchronized String get() {
        if (this.flag == true) { // 不允许消费，可以生产
            try {
                super.wait(); // 需要等待生产线程生产完毕后再执行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.flag = true; // 表示消费完成，可以生产了
        super.notify();
        return "title = " + this.title + "、content = " + this.content;
    }
}

class ProducerThread implements Runnable {
    private Message message;

    public ProducerThread(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int x = 0; x < 50; x++) {
            try {
                if (x % 2 == 0) {
                    this.message.set("samsin", "李尚兴是个大帅哥！");
                } else {
                    this.message.set("boanda", "博安达是个坑爹货！");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class ConsumerThread implements Runnable {
    private Message message;

    public ConsumerThread(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int x = 0; x < 50; x++) {
            System.out.println("【消费者】" + this.message.get());
        }
    }
}
