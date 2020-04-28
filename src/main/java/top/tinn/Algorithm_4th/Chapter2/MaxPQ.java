package top.tinn.Algorithm_4th.Chapter2;

/**
 * @ClassName MaxPQ
 * @Description
 * @Author Tinn
 * @Date 2020/4/23 15:46
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;  // 基于堆的完全按二叉树
    private int N = 0; // 存储于p q [ l . .N ]中，p q [0 ]没有使用

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }

    private void swim(int n) {
        while (n > 1 && less(n/2, n)){
            exch(n/2, n);
            n >>>= 1;
        }
    }

    public Key delMax(){
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    private void sink(int i) {
        while (i*2 <= N ){
            int j = 2*i;
            if (j < N && less(j, j + 1)) j++;
            if (less(j, i)) break;
            exch(i, j);
            i = j;
        }
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private boolean less(int i, int j){
        int ret = pq[i].compareTo(pq[j]);
        return ret < 0;
    }

    public static void main(String[] args) {
        MaxPQ<Integer> maxPQ = new MaxPQ<>(10);
        for (int i = 1; i < 6; i++){
            maxPQ.insert(i);
        }
        while (!maxPQ.isEmpty())
            System.out.print(maxPQ.delMax()+" ");
    }
}
