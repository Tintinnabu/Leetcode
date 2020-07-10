package top.tinn.ConcurrencyProblem.Problem_1114.Synchronization;

public class Foo {
    private int flag = 0;
    private Object lock = new Object();
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock){
            while (flag != 0){
                lock.wait();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            flag = 1;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock){
            while (flag != 1){
                lock.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            flag = 2;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock){
            while (flag != 2){
                lock.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            flag = 0;
            lock.notifyAll();
        }
    }
}
