package top.tinn.CS_Notes.JavaConcurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExample extends RecursiveTask<Integer> {
    private final int threshold = 5;
    private int first;
    private int last;

    public ForkJoinExample(int first, int last) {
        this.first = first;
        this.last = last;
    }

    @Override
    protected Integer compute() {
        int result = 0;
        if (last -first <= threshold){
            for (int i = first; i <= last; i++){
                result += i;
            }
        }else {
            int middle = first + (last - first) / 2;
            ForkJoinExample leftTask  = new ForkJoinExample(first, middle);
            ForkJoinExample rightTask = new ForkJoinExample(middle + 1, last);
            leftTask.fork();
            rightTask.fork();
            result = leftTask.join() + rightTask.join();
        }
        return result;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinExample example = new ForkJoinExample(1, 10000);
        ForkJoinPool pool = new ForkJoinPool();
        System.out.println("state time: " + System.currentTimeMillis());
        Future result = pool.submit(example);
        System.out.println(result.get());
        System.out.println("end time: " + System.currentTimeMillis());
        int result2 = 0;
        System.out.println("state time: " + System.currentTimeMillis());
        for (int i = 0; i <= 10000; i++){
            result2 += i;
        }
        System.out.println(result2);
        System.out.println("end time: " + System.currentTimeMillis());
    }
}
