package top.tinn.MultiThreading.Problem_1115;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName FooBar
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/23 20:51
 */
public class FooBar3 {
    private int n;
    private volatile boolean permitFoo = true;
    public FooBar3(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n;) {
            if (permitFoo){
                printFoo.run();
                i++;
                permitFoo = false;
                // printFoo.run() outputs "foo". Do not change or remove this line.
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n;) {
            if(!permitFoo) {
                printBar.run();
                i++;
                permitFoo = true;
            }
        }
    }
}
