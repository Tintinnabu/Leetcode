package top.tinn.MultiThreading.Problem_1115;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName FooBar
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/23 20:51
 */
public class FooBar4 {
    private int n;
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
    private volatile boolean permitFoo = true;
    public FooBar4(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (!permitFoo);
            printFoo.run();
            permitFoo = false;
            cyclicBarrier.wait();
            // printFoo.run() outputs "foo". Do not change or remove this line.
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {
                cyclicBarrier.await();
            }catch (BrokenBarrierException ignored){

            }
            printBar.run();
            permitFoo = true;
        }
    }
}
