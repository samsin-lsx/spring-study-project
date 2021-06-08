package cn.mldn.java13thread;

/**
 * 说明：【面试题】电脑生产
 * @author：李尚兴
 * @date：2020-07-22 0:20
 * @version：1.0
 */
public class ComputerCreateGetThreadTest {
    public static void main(String[] args) {
        ComputerResource computerResource = new ComputerResource();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                if (i % 2 == 0) {
                    computerResource.create("外星人 - " + i, 29999.99);
                } else {
                    computerResource.create("联想者 - " + i, 6999.89);
                }
            }
        }, "电脑生产者").start();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                computerResource.get();
            }
        }, "电脑搬运工").start();
    }
}
class ComputerResource {
    private int number = 0; // 统计电脑的数量
    private Computer computer;
    public ComputerResource() {
        Thread computerDaemonThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("【后台线程】统计当前生产的电脑数量为：" + this.number);
            }
        });
        computerDaemonThread.setDaemon(true);
        computerDaemonThread.start();
    }
    public synchronized void create(String brand, double price) {
        if (this.computer != null) { // 可以取走电脑
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
        this.computer = new Computer(brand, price);
        this.number++; // 电脑数量进行累加
        System.out.println("【" + Thread.currentThread().getName() + "】生产电脑，" + this.computer);
        super.notify();
    }
    public synchronized void get() {
        if (this.computer == null) { // 可以生产
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
        System.out.println("【" + Thread.currentThread().getName() + "】搬运电脑，" + this.computer);
        this.computer = null;
        super.notify();
    }
}
class Computer {
    private String brand;
    private double price;
    public Computer(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }
    @Override
    public String toString() {
        return "电脑品牌：" + this.brand + "、电脑价格：" + this.price;
    }
}
