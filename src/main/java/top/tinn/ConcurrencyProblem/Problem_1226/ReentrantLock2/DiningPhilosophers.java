package top.tinn.ConcurrencyProblem.Problem_1226.ReentrantLock2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {
    final ReentrantLock[] locks = new ReentrantLock[5];
    //临界区保证能得到两把叉子
    final ReentrantLock eater = new ReentrantLock();
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

        //保证eater能同时持有两把叉子
        eater.lock();
        locks[left].lock();
        locks[right].lock();
        eater.unlock();

        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();

        locks[left].unlock();
        locks[right].unlock();
    }
}
