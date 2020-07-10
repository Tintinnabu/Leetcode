package top.tinn.ConcurrencyProblem.Problem_1114.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class Foo {
    //声明两个 CountDownLatch变量
    private CountDownLatch latch1;
    private CountDownLatch latch2;
    public Foo() {
        //初始化每个CountDownLatch的值为1，表示有一个线程执行完后，执行等待的线程
        latch1 = new CountDownLatch(1);
        latch2 = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        //当前只有first线程没有任何的阻碍，其余两个线程都处于等待阶段
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        //直到CountDownLatch01里面计数为0才执行因调用该countDownCatch01.await()而等待的线程
        latch1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        //只有countDownLatch01为0才能通过，否则会一直阻塞
        latch1.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        //直到CountDownLatch02里面计数为0才执行因调用该countDownCatch02.await()而等待的线程
        latch2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        //只有countDownLatch02为0才能通过，否则会一直阻塞
        latch2.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }


}
