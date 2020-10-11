package top.tinn.ConcurrencyProblem.ConsumerProducer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Tinn
 * @Date: 2020/10/11 15:11
 */
public class Solution {
    ReentrantLock lock = new ReentrantLock();
    Condition producer = lock.newCondition();
    Condition consumer = lock.newCondition();
    List<Object> list = new ArrayList<>();
    int size = 10;

    public void produce(){
        try {
            lock.lock();
            while (list.size() + 1 > size){
                producer.await();
            }
            list.add(new Object());
            consumer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public Object consume(){
        Object take = null;
        try {
            lock.lock();
            while (list.size() == 0){
                consumer.await();
            }
            take = list.remove(list.size() - 1);
            producer.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return take;
    }
}
