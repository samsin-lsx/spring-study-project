package cn.mldn.java11thread;

/**
 * 《二》电脑生产者与消费者模型
 * 实现生产一台电脑就取走一台电脑，并统计生产电脑的个数
 */
public class ComputerThreadTest {
    public static void main(String[] args) {
        ComputerResource computerResource = new ComputerResource();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                if (i % 2 == 0) {
                    computerResource.create("联想电脑", 9000);
                } else {
                    computerResource.create("小米电脑", 6999);
                }
            }
        }, "电脑生产者").start();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                computerResource.get();
            }
        }, "电脑消费者").start();
    }
}

class ComputerResource {
    private Computer computer; // 保存电脑的生成与取走数量

    public synchronized void create(String brand, double price) {
        if (this.computer != null) {
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.computer = new Computer(brand, price);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("〖" + Thread.currentThread().getName() + "〗生产电脑：" + this.computer);
        super.notify();
    }

    public synchronized void get() {
        if (this.computer == null) {
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
        System.out.println("【" + Thread.currentThread().getName() + "】取走电脑：" + this.computer);
        this.computer = null;
        super.notify();
    }
}

class Computer {
    private String brand;
    private double price;
    private static int count; // 计算生产电脑的个数

    public Computer(String brand, double price) {
        System.out.println("生产电脑的个数：" + Computer.count++);
        this.brand = brand;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
