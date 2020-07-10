package top.tinn.ConcurrencyProblem.Problem_1115.Synchronization;

public class FooBar {

    private Object lock = new Object();
    private int flag = 0;
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock){
                while (flag != 0){
                    lock.wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag = 1;
                lock.notifyAll();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock){
                while (flag != 1){
                    lock.wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag = 0;
                lock.notifyAll();
            }
        }
    }
}
