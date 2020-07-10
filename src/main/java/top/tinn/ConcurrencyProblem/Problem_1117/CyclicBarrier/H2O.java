package top.tinn.ConcurrencyProblem.Problem_1117.CyclicBarrier;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class H2O {
    CyclicBarrier cb;
    CountDownLatch h, o;

    public H2O() {
        cb = new CyclicBarrier(2);
        h = new CountDownLatch(2);
        o = new CountDownLatch(1);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h.await();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
    }
}
