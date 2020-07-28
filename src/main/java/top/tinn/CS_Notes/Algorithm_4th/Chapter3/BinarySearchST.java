package top.tinn.CS_Notes.Algorithm_4th.Chapter3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName BinarySearchST
 * @Description
 * @Author Tinn
 * @Date 2020/4/23 21:36
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] values;
    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size(){
        return N;
    }

    public Value get(Key key){
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) return values[i];
        return null;
    }

    //BinarySearch O(logN)
    public int rank(Key key) {
        int l = 0, r = N - 1;
        while (l <= r){
            int mid = l + (r - l)/2;
            int cmp = keys[mid].compareTo(key);
            if (cmp < 0) l = mid + 1;
            else if (cmp > 0) r = mid - 1;
            else return cmp;
        }
        return l;
    }

    private boolean isEmpty() {
        return size() == 0;
    }

    //construct ordered Key array O(N)
    public void put(Key key, Value value){
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        for (int j = N; j > i; j++){
            keys[j] = keys[j - 1];
            values[i] = values[i - 1];
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    public Key min(){
        return keys[0];
    }

    public Key max(){
        return keys[N - 1];
    }

    public Key select(int k){
        return keys[k];
    }

    public Key ceiling(Key key){
        int i = rank(key);
        return keys[i];
    }

    public Key floor(Key key){
        int i = rank(key);
        if (i > 0 && i < N){
            return keys[i - 1];
        }
        return null;
    }

    public void delete(Key key){
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0){
            for (int j = i; j < N; j++){
                keys[j] = keys[j + 1];
                values[j] = values[j + 1];
            }
            N--;
        }
    }

    public Iterable<Key> keys(Key l, Key r){
        Queue<Key> queue = new LinkedList<>();
        for (int i = rank(l); i < rank(r); i++){
            queue.offer(keys[i]);
        }
        if (contains(r)) queue.offer(keys[rank(r)]);
        return queue;
    }

    private boolean contains(Key r) {
        return true;
    }
}
