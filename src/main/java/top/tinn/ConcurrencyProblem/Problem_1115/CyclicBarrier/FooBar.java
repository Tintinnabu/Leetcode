package top.tinn.ConcurrencyProblem.Problem_1115.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class FooBar {
    private int n;
    private CyclicBarrier barrier;
    private volatile boolean flag;
    public FooBar(int n) {
        this.n = n;
        barrier = new CyclicBarrier(2);
        flag = true;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (!flag);
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            flag = false;
            try {
                barrier.await();
            }catch (BrokenBarrierException e){

            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {
                barrier.await();
            }catch (BrokenBarrierException e){

            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            flag = true;
        }
    }
}
