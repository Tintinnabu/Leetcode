package top.tinn.Algorithm_4th.Chapter5;

/**
 * @ClassName TSt
 * @Description
 * @Author Tintinnabu
 * @Date 2020/4/24 19:34
 */
public class TST<Value> {
    private Node root;
    private class Node{
        char c;
        Node left, mid, right;
        Value val;
    }

    public Value get(String key){
        Node x =  get(root, key, 0);
        return x == null ? null : x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        char c = key.charAt(d);
        if (c < x.c) return get(x.left, key, d + 1);
        else if (c > x.c) return get(x.right, key, d + 1);
        else if (d < key.length() - 1) return get(x.mid, key, d + 1);
        return x;
    }

    public void put(String key, Value val){
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {
        char c= key.charAt(d);
        if (x == null){
            x = new Node();
            x.c = c;
        }
        if (c < x.c) x.left = put(x.left, key, val, d + 1);
        else if (c > x.c) x.right = put(x.right, key, val, d + 1);
        else if (d < key.length() - 1) x.mid = put(x.mid, key, val, d + 1);
        else x.val = val;
        return x;
    }
}
