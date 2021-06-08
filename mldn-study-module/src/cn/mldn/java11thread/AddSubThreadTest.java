package cn.mldn.java11thread;

/**
 * 《一》使用生产者与消费者模型
 * 实现两个线程加操作、两个线程减操作
 */
public class AddSubThreadTest {
    public static void main(String[] args) {
        Resource resource = new Resource();
        for (int x = 0; x < 4; x++) {
            if (x % 2 == 0) {
                new Thread(() -> {
                    for (int i = 0; i < 50; i++) {
                        synchronized (resource) {
                            resource.sub(); // 执行减法操作
                        }
                    }
                }, "减法线程 - " + x).start();
            } else {
                new Thread(() -> {
                    for (int i = 0; i < 50; i++) {
                        synchronized (resource) {
                            resource.add();
                        }
                    }
                }, "加法线程 - " + x).start();
            }
        }
    }
}

class Resource {
    private int number = 0;
    private boolean flag; // 设置同步属性

    // flag = true：表示允许进行加法操作，不允许进行减法操作
    // flag = false：表示允许减法操作，不允许进行加法操作
    public synchronized void add() {
        if (this.flag == false) {
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.number++;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("【" + Thread.currentThread().getName() + "】执行加法操作，结果为：" + this.number);
        this.flag = false;
        super.notify();
    }

    public synchronized void sub() {
        if (this.flag == true) {
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.number--;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("【" + Thread.currentThread().getName() + "】执行减法操作，结果为：" + this.number);
        this.flag = true;
        super.notify();
    }
}
