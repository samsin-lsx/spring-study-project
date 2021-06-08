package cn.mldn.java13thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 说明：【面试题】竞拍抢答
 * @author：李尚兴
 * @date：2020-07-22 0:45
 * @version：1.0
 */
public class AnswerThreadTest {
    public static void main(String[] args) throws Exception {
        AnswerThread answerThread = new AnswerThread();
        FutureTask futureTaskA = new FutureTask(answerThread);
        FutureTask futureTaskB = new FutureTask(answerThread);
        FutureTask futureTaskC = new FutureTask(answerThread);
        new Thread(futureTaskA, "抢答者A").start();
        new Thread(futureTaskB, "抢答者B").start();
        new Thread(futureTaskC, "抢答者C").start();
        System.out.println(futureTaskA.get());
        System.out.println(futureTaskB.get());
        System.out.println(futureTaskC.get());
    }
}
class AnswerThread implements Callable<String> {
    private boolean flag; // 设置抢答成功与否的标记
    @Override
    public String call() throws Exception {
        Thread.sleep(100);
        synchronized (this) {
            if (this.flag == false) { // 现在可以抢答
                this.flag = true;
                return "【" + Thread.currentThread().getName() + "】恭喜，抢答成功！";
            } else {
                return "【" + Thread.currentThread().getName() + "】遗憾，抢答失败！";
            }
        }
    }
}

