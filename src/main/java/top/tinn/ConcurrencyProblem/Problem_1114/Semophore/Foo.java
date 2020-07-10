package top.tinn.ConcurrencyProblem.Problem_1114.Semophore;

import java.util.concurrent.Semaphore;

public class Foo {
    //声明两个 Semaphore变量
    //跟CountDownLatch很相似
    private Semaphore sp1,sp2;
    public Foo() {
        sp1 = new Semaphore(0);
        sp2 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        sp1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        sp1.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        sp2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        sp2.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
