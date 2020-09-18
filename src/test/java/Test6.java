import java.util.PriorityQueue;

/**
 * @Author: Tinn
 * @Date: 2020/9/13 10:45
 */
public class Test6 extends Thread{


    public static void main(String[] args) {
        Thread t = new Thread(new ThreadLocalTest());
        t.start();
    }

    static class ThreadLocalTest implements Runnable{
        private ThreadLocal<String> stringThreadLocal1 = ThreadLocal.withInitial(()->new String("111"));
        private ThreadLocal<String> stringThreadLocal2 = ThreadLocal.withInitial(()->new String("222"));
        @Override
        public void run() {
            System.out.println(stringThreadLocal1.get());
            stringThreadLocal1.set("333");
            System.out.println(stringThreadLocal2.get());
        }
    }
}
