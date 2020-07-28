package top.tinn.CS_Notes.Algorithm_4th.Chapter3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName BST
 * @Description 二叉查找树
 * @Author Tintinnabu
 * @Date 2020/4/24 9:39
 */
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;
    private class Node{
        private Key key;
        private Value value;
        private Node left, right;
        private int N; //以该节点为root的子树中的节点总数

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }
    }

    public int size(){
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.N;
    }

    public Value get(Key key){
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        return x.value;
    }

    public void put(Key key, Value value){
        root = put(root, key, value);
    }

    //更新root
    private Node put(Node x, Key key, Value value){
        if (x == null) return new Node(key, value, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, value);
        else if (cmp > 0) x.right = put(x.right, key, value);
        else x.value = value;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min(){
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public Key max(){
        return max(root).key;
    }

    private Node max(Node x){
        if (x.right == null) return x;
        return max(x.right);
    }

    public Key floor(Key key){
        return floor(root, key).key;
    }

    private Node floor(Node x, Key key){
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }

    public Key select(int k){
        return select(root, k).key;
    }

    private Node select(Node x, int k) {
        if (x == null) return null;
        int t = size(x.left);
        if (t > k) return select(x.left, k);
        else if (t < k) return select(x.right,k - t - 1);
        return x;
    }

    public int rank(Key key){
        return rank(root, key);
    }

    private int rank(Node x, Key key) {
        if (x == null) return  0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(x.left, key);
        else if (cmp > 0) return 1 + size(x.left) + rank(x.right, key);
        return size(x.left);
    }

    public void deleteMin(){
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key){
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.left == null) return x.right;
            if (x.right == null) return x.left;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.right) + size(x.left) + 1;
        return x;
    }

    public Iterable<Key> keys(){
        return keys(min(), max());
    }

    private Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new LinkedList<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (root == null) return;
        int cmplo = lo.compareTo(root.key);
        int comhi = hi.compareTo(root.key);
        if (cmplo < 0) keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && comhi >=0) queue.offer(x.key);
        if (comhi > 0) keys(x.right, queue, lo, hi);
    }

    public static void main(String[] args) {
        BST<Integer, Integer> bst = new BST<>();
        bst.put(1,2);
        bst.put(3,2);
        bst.put(2,2);
        bst.put(4,2);
    }
}
