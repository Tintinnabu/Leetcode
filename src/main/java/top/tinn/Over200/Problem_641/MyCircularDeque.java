package top.tinn.Over200.Problem_641;

public class MyCircularDeque {

    private final int size;
    private final int[] arr;
    private int head;
    private int tail;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        size = k + 1;
        arr = new int[size];
        head = tail = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()){
            return false;
        }
        head = (head - 1 + size) % size;
        arr[head] = value;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()){
            return false;
        }
        arr[tail] = value;
        tail = (tail + 1) % size;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()){
            return false;
        }
        head = (head + 1) % size;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()){
            return false;
        }
        tail = (tail - 1 + size) % size;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return isEmpty() ? -1 : arr[head];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return isEmpty() ? -1 : arr[(tail - 1 + size) % size];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return head == tail;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (tail + 1) % size == head;
    }
}
