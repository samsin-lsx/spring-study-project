package cn.mldn.java13thread;

/**
 * 说明：实现Lambda表达式实现多线程
 * @author：李尚兴
 * @date：2020-07-16 23:50
 * @version：1.0
 */
public class LambdaRunnableThreadTest {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            String name = "当前第【" + i + "】个线程对象";
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    System.out.println(name + "开始执行，当前循环的次数为：num = " + j);
                }
            }).start();
        }
    }
}
