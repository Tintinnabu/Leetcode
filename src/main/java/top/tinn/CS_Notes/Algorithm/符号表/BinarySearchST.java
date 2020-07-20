package top.tinn.CS_Notes.Algorithm.符号表;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchST<Key extends Comparable<Key>, Value>
 implements OrderedST<Key, Value>{
    private Key[] keys;
    private Value[] values;
    private int N = 0;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public void put(Key key, Value value) {
        int index = rank(key);
        if (index < N && keys[index].compareTo(key) == 0) {
            values[index] = value;
            return;
        }
        if (keys[index].compareTo(key) < 0){
            index++;
        }
        for (int j = N; j >= index; j--){
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[index] = key;
        values[index] = value;
        N++;
    }

    @Override
    public Value get(Key key) {
        int index = rank(key);
        if (index < N && keys[index].compareTo(key) == 0)
            return values[index];
        return null;
    }

    @Override
    public Key min() {
        return keys[0];
    }

    @Override
    public Key max() {
        return keys[N - 1];
    }

    @Override
    public int rank(Key key) {
        int l = 0, r = N - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0){
                r = mid - 1;
            }else if (cmp > 0){
                l = mid + 1;
            }else {
                return mid;
            }
        }
        return l;
    }

    @Override
    public List<Key> keys(Key l, Key h) {
        int index = rank(l);
        List<Key> list = new ArrayList<>();
        while (keys[index].compareTo(h) <= 0) {
            list.add(keys[index]);
            index++;
        }
        return list;
    }
}
