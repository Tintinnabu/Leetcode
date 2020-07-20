package top.tinn.CS_Notes.JavaConcurrent;

import java.util.concurrent.*;

public class MultiThreads {

    //实现Runnable
    static class MyRunnable implements Runnable{
        @Override
        public void run() {
            //
            System.out.println("runnable");
        }
    }

    //实现callable
    static class MyCallable implements Callable{

        @Override
        public Integer call() throws Exception {
            System.out.println("callable");
            return 123;
        }
    }

    //继承thread
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("thread");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable());
        thread1.start();
        FutureTask<Integer> futureTask = new FutureTask<>(new MyCallable());
        Thread thread2 = new Thread(futureTask);
        thread2.start();
        MyThread myThread = new MyThread();
        myThread.start();

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++){
            executorService.execute(new MyRunnable());
        }
        executorService.shutdown();
    }
}
