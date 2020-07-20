package top.tinn.CS_Notes.JavaConcurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("compute task");
                int result = 0;
                for (int i = 1; i <= 100; i++){
                    Thread.sleep(10);
                    result += i;
                }
                return result;
            }
        });
        Thread computeThread = new Thread(futureTask);
        computeThread.start();
        Thread otherThread = new Thread(()->{
            System.out.println("other task");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        otherThread.start();
        System.out.println(futureTask.get());
    }
}
