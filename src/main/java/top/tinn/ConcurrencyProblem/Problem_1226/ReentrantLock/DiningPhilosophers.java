package top.tinn.ConcurrencyProblem.Problem_1226.ReentrantLock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {
    final ReentrantLock[] locks = new ReentrantLock[5];
    //同时只允许4人就餐，至少有一位能成功就餐
    final Semaphore eatList = new Semaphore(4);
    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++){
            locks[i] = new ReentrantLock();
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int left = (philosopher + 1) % 5;
        int right = philosopher;
        eatList.acquire();
        locks[left].lock();
        locks[right].lock();

        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();

        locks[left].unlock();
        locks[right].unlock();

        eatList.release();
    }
}
