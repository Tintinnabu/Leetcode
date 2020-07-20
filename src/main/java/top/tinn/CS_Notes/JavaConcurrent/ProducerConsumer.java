package top.tinn.CS_Notes.JavaConcurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class ProducerConsumer {

    private static BlockingDeque<String> queue = new LinkedBlockingDeque<>(35);

    private static class Producer extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 20; i++){
                try {
                    queue.put("product" + i);
                    //System.out.println("producing.." + i);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Consumer extends Thread{
        @Override
        public void run() {
            while (true){
                try {
                    String product = queue.take();
                    System.out.println("consuming.." + product);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Producer producer = new Producer();
        producer.start();

        Consumer consumer = new Consumer();
        consumer.start();

    }
}
