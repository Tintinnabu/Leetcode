package top.tinn.Over200.Problem_622;

public class MyCircularQueue {

    private final int size;
    private final int[] arr;
    private int head;
    private int tail;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        size = k + 1;
        arr = new int[size];
        head = tail = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()){
            return false;
        }
        arr[tail] = value;
        tail = (tail + 1) % size;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()){
            return false;
        }
        head = (head + 1) % size;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        return isEmpty() ? -1 : arr[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        return isEmpty() ? -1 : arr[(tail - 1 + size) % size];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head == tail;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (tail + 1) % size == head;
    }
}
