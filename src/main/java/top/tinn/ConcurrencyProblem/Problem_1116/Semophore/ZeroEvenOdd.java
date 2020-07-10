package top.tinn.ConcurrencyProblem.Problem_1116.Semophore;

import com.sun.xml.internal.ws.server.WSEndpointMOMProxy;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    private Semaphore z, e, o;

    public ZeroEvenOdd(int n) {
        this.n = n;
        z = new Semaphore(1);
        e = new Semaphore(0);
        o = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++){
            z.acquire();
            printNumber.accept(0);
            if ((i & 1) == 0){
                e.release();
            }else {
                o.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2){
            e.acquire();
            printNumber.accept(i);
            z.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2){
            o.acquire();
            printNumber.accept(i);
            z.release();
        }
    }
}
