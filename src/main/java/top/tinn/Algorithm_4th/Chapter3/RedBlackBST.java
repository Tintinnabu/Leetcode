package top.tinn.Algorithm_4th.Chapter3;

/**
 * @ClassName RedBlackBST
 * @Description
 * @Author Tintinnabu
 * @Date 2020/4/24 11:42
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;


    private class Node{
        Key key;
        Value value;
        Node left, right;
        int N;
        boolean color;

        public Node(Key key, Value value, int n, boolean color) {
            this.key = key;
            this.value = value;
            N = n;
            this.color = color;
        }
    }

    private boolean isRed(Node x){
        if (x == null) return false;
        return x.color;
    }

    private Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.N;
    }

    private void flipColor(Node h){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public void put(Key key, Value value){
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value value){
        if (h == null) return new Node(key, value, 1, RED);
        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, value);
        else if (cmp > 0) h.right = put(h.right, key, value);
        else h.value = value;
        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);  //    // \     //
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h); //         //
        if (isRed(h.left) && isRed(h.right)) flipColor(h);  //                            // \\
        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    public void insert(Key key, Value value){
        root = insert(root, key, value);
        root.color = BLACK;
    }

    private Node insert(Node h, Key key, Value value) {
        if (h == null) return new Node(key, value, 1, RED);
        if (isRed(h.left) && isRed(h.right)) flipColor(h);  //                            // \\
        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, value);
        else if (cmp > 0) h.right = put(h.right, key, value);
        else h.value = value;
        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);  //    // \     //
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h); //         //
        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    public static void main(String[] args) {
        RedBlackBST<String, Integer> bst = new RedBlackBST<>();
        bst.put("S",1);
        bst.put("E",1);
        bst.put("A",1);
        bst.put("R",1);
        bst.put("C",1);
        bst.put("H",1);
        bst.put("X",1);
        bst.put("M",1);
        bst.put("P",1);
    }
}
