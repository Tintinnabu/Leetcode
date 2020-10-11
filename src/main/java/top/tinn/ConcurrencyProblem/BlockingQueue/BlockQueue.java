package top.tinn.ConcurrencyProblem.BlockingQueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Tinn
 * @Date: 2020/10/11 15:18
 */
public class BlockQueue<T> {

    private int size;
    private Object[] queue;
    private Lock lock = new ReentrantLock();
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();

    private int index;
    private int removeIndex;
    private int currLen;

    public BlockQueue(){
        this(10);
    }

    public BlockQueue(int size) {
        this.index = 0;
        this.removeIndex = 0;
        this.currLen = 0;
        this.size = size;
        queue = new Object[size];
    }

    public void push(T element){
        lock.lock();
        try {
            while (currLen == size){
                full.await();
            }
            queue[index++] = element;
            if (index == size){
                index = 0;
            }
            currLen++;
            empty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public T pop(){
        lock.lock();
        Object obj = null;
        try {
            while (currLen == 0){
                empty.await();
            }
            obj = queue[removeIndex];
            if (++removeIndex == size){
                removeIndex = 0;
            }
            currLen--;
            full.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return (T)obj;
    }
}
