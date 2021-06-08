package cn.mldn.java11thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 《三》抢答线程
 * 创建三个线程进行抢答，谁抢答成功给出提示，抢答失败也给出提示。
 */
public class AnswerThreadTest {
    public static void main(String[] args) throws Exception {
        AnswerThread answerThread = new AnswerThread();
        FutureTask<String> futureA = new FutureTask<>(answerThread);
        FutureTask<String> futureB = new FutureTask<>(answerThread);
        FutureTask<String> futureC = new FutureTask<>(answerThread);
        new Thread(futureA, "抢答者 - A").start();
        new Thread(futureB, "抢答者 - B").start();
        new Thread(futureC, "抢答者 - C").start();
        System.out.println(futureA.get());
        System.out.println(futureB.get());
        System.out.println(futureC.get());
    }
}

class AnswerThread implements Callable<String> {
    private boolean flag; // 描述抢答结果的标记

    @Override
    public String call() throws Exception {
        String result = null;
        synchronized (this) {
            if (this.flag == false) { // 表示可以进行抢答
                this.flag = true;
                result = "【" + Thread.currentThread().getName() + "】抢答成功！";
            } else {
                result = "【" + Thread.currentThread().getName() + "】抢答失败！";
            }
        }
        return result;
    }
}