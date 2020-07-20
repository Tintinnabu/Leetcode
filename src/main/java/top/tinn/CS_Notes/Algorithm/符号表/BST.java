package top.tinn.CS_Notes.Algorithm.符号表;

import java.util.ArrayList;
import java.util.List;

public class BST<Key extends Comparable<Key>, Value>
        implements OrderedST<Key, Value> {
    protected Node root;

    protected class Node{
        Key key;
        Value value;
        Node left;
        Node right;
        boolean color;
        int N;

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }

        public Node(Key key, Value value, int n, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
            N = n;
        }
    }
    @Override
    public int size() {
        return size(root);
    }

    public int size(Node root) {
        if (root == null){
            return 0;
        }
        return root.N;
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    //dfs
    private Node put(Node x, Key key, Value value) {
        if (x == null)
            return new Node(key, value, 1);
        int cmp = key.compareTo(x.key);
        if (cmp == 0)
            x.value = value;
        else if (cmp < 0)
            x.left = put(x.left, key, value);
        else
            x.right = put(x.right, key, value);
        recalculateSize(x);
        return x;
    }

    public void recalculateSize(Node x) {
        x.N = 1 + size(x.left) + size(x.right);
    }

    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0){
            return get(x.left, key);
        }else if (cmp > 0){
            return get(x.right, key);
        }else {
            return x.value;
        }
    }

    @Override
    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x == null){
            return null;
        }
        if (x.left == null){
            return x;
        }
        return min(x.left);
    }

    @Override
    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if (x == null){
            return null;
        }
        if (x.right == null){
            return x;
        }
        return min(x.right);
    }

    @Override
    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        if (x == null){
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0){
            return size(x.left);
        }else if (cmp < 0){
            return rank(key, x.left);
        }else {
            return 1 + size(x.left) + rank(key, x.right);
        }
    }

    public Key floor(Key key){
        Node x = floor(root, key);
        return x == null ? null : x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0){
            return x;
        }else if (cmp < 0){
            return floor(x.left, key);
        }else {
            Node t = floor(x.right, key);
            return t == null ? x : t;
        }
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null)
            return x.right;
        x.left = deleteMin(x.left);
        recalculateSize(x);
        return x;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0){
            x.left = delete(x.left, key);
        }else if (cmp > 0){
            x.right = delete(x.right, key);
        }else {
            if (x.right == null){
                return x.left;
            }else if (x.left == null){
                return x.right;
            }
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(x.right);
            x.left = t.left;
        }
        recalculateSize(x);
        return x;
    }

    @Override
    public List<Key> keys(Key l, Key h) {
        return keys(root, l, h);
    }

    private List<Key> keys(Node x, Key l, Key h) {
        List<Key> list = new ArrayList<>();
        if (x == null){
            return list;
        }
        int cmpL = l.compareTo(x.key);
        int cmpH = h.compareTo(x.key);
        if (cmpL < 0){
            list.addAll(keys(x.left, l, h));
        }
        if (cmpL <= 0 && cmpH >= 0){
            list.add(x.key);
        }
        if (cmpL > 0){
            list.addAll(keys(x.right, l, h));
        }
        return list;
    }
}
