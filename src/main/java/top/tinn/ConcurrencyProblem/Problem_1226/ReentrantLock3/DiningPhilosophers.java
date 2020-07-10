package top.tinn.ConcurrencyProblem.Problem_1226.ReentrantLock3;

import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {
    //一部分哲学家优先去获取其左边的叉子，再去获取其右边的叉子；
    //再让剩余哲学家优先去获取其右边的叉子，再去获取其左边的叉子。
    final ReentrantLock[] locks = new ReentrantLock[5];
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

        //编号为偶数的哲学家，优先拿起左边的叉子，再拿起右边的叉子
        if (philosopher % 2 == 0){
            locks[left].lock();
            locks[right].lock();
        }else {
            //编号为奇数的哲学家，优先拿起右边的叉子，再拿起左边的叉子
            locks[right].lock();
            locks[left].lock();
        }

        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();

        locks[left].unlock();
        locks[right].unlock();
    }
}
