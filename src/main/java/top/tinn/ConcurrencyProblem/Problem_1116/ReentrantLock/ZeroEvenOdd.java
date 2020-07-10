package top.tinn.ConcurrencyProblem.Problem_1116.ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    Lock lock = new ReentrantLock();
    Condition z = lock.newCondition();
    Condition num = lock.newCondition();
    volatile boolean zTurn = true;
    volatile int zIndex = 0;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (; zIndex < n; ){
            lock.lock();
            try {
                while (!zTurn){
                    z.await();
                }
                printNumber.accept(0);
                zTurn = false;
                num.signalAll();
                zIndex++;
            }finally {
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2){
            lock.lock();
            try {
                while (zTurn || (zIndex & 1) == 1){
                    num.await();
                }
                printNumber.accept(i);
                zTurn = true;
                z.signal();
            }finally {
                lock.unlock();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2){
            lock.lock();
            try {
                while (zTurn || (zIndex & 1) == 0){
                    num.await();
                }
                printNumber.accept(i);
                zTurn = true;
                z.signal();
            }finally {
                lock.unlock();
            }
        }
    }
}