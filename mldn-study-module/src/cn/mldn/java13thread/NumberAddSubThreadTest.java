package cn.mldn.java13thread;

/**
 * 说明：【面试题】多线程加减操作：创建4个线程，实现两个线程做减法操作、两个线程做加法操作
 * @author：李尚兴
 * @date：2020-07-21 23:51
 * @version：1.0
 */
public class NumberAddSubThreadTest {
    public static void main(String[] args) {
        Resource resource = new Resource();
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int x = 0; x < 20; x++) {
                    synchronized (resource) {
                        resource.add();
                    }
                }
            }, "加法线程 - " + i).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int x = 0; x < 20; x++) {
                    synchronized (resource) {
                        resource.sub();
                    }
                }
            }, "减法线程 - " + i).start();
        }
    }
}

class Resource {
    private int number = 0; // 要操作的数字
    private boolean flag; // 加减操作的标记

    // flag = true：表示可以加法操作，但是不允许减法操作
    // flag = false：表示可以减法操作，但是不允许加法操作
    public synchronized void add() {
        while (this.flag == false) {
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
        System.out.println("【" + Thread.currentThread().getName() + "】执行加法操作，当前的操作结果为：" + this.number);
        this.flag = false; // 表示加法执行完毕
        super.notifyAll();
    }

    public synchronized void sub() {
        while (this.flag == true) {
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.number--;
        System.out.println("【" + Thread.currentThread().getName() + "】执行减法操作，当前的操作结果为：" + this.number);
        this.flag = true; // 表示减法操作完成
        super.notifyAll();
    }
}