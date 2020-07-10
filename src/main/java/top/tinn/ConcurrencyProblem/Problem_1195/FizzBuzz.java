package top.tinn.ConcurrencyProblem.Problem_1195;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzz {
    private int n;
    Semaphore f, b, fb, nn;
    public FizzBuzz(int n) {
        this.n = n;
        f = new Semaphore(0);
        b = new Semaphore(0);
        fb = new Semaphore(0);
        nn = new Semaphore(1);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <= n; i += 3){
            if (i % 3 == 0 && i % 5 != 0){
                f.acquire();
                printFizz.run();
                nn.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n; i += 5){
            if (i % 3 != 0 && i % 5 == 0){
                b.acquire();
                printBuzz.run();
                nn.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 15; i <= n; i += 15){
            fb.acquire();
            printFizzBuzz.run();
            nn.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++){
            nn.acquire();
            if (i % 3 != 0 && i % 5 != 0) {
                printNumber.accept(i);
                nn.release();
            } else if (i % 3 == 0 && i % 5 != 0) {
                f.release();
            } else if (i % 3 != 0 && i % 5 == 0) {
                b.release();
            } else {
                fb.release();
            }
        }
    }
}
