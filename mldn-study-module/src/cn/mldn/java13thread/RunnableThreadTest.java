package cn.mldn.java13thread;

public class RunnableThreadTest {
    public static void main(String[] args) {
        MyThread myThreadA = new MyThread("线程A");
        MyThread myThreadB = new MyThread("线程B");
        MyThread myThreadC = new MyThread("线程C");
        new Thread(myThreadA).start();
        new Thread(myThreadB).start();
        new Thread(myThreadC).start();
    }
}
class MyThread implements Runnable {
    private String name;
    public MyThread(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.name + "线程运行，i = " + i);
        }
    }
}