package cn.mldn.java13thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 说明：使用Callable接口实现多线程
 * @author：李尚兴
 * @date：2020-07-17 0:36
 * @version：1.0
 */
public class CallableThreadTest {
    public static void main(String[] args) throws Exception {
        MyCallableThread myCallableThread = new MyCallableThread();
        FutureTask<String> futureTask = new FutureTask<>(myCallableThread);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }
}
class MyCallableThread implements Callable<String> {
    private String result = "";
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 10; i++) {
            result += "正在学习多线程编程知识！\n";
        }
        return result;
    }
}
