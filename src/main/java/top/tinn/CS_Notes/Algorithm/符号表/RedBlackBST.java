package top.tinn.CS_Notes.Algorithm.符号表;

import com.sun.org.apache.regexp.internal.RE;

/**
 * 红黑树的性质：
 *  红链接都为左链接；
 *  没有任何一个结点同时和两条红链接相连
 *  完美黑色平衡，即任意空链接到根节点的路径上的黑链接数量相同。
 * @param <Key>
 * @param <Value>
 */
public class RedBlackBST<Key extends Comparable<Key>, Value>
 extends BST<Key, Value>{
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private boolean isRed(Node x){
        if (x == null){
            return false;
        }
        return x.color == RED;
    }

    //左旋转：如果出现右链接为红链接，那么就需要进行左旋转操作
    public Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        x.color = RED;
        x.N = h.N;
        recalculateSize(h);
        return x;
    }

    //右旋转：为了转换两个连续的左红链接。
    public Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        recalculateSize(h);
        return x;
    }

    public void flipColor(Node h){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node x, Key key, Value value){
        if (x == null){
            return new Node(key, value, 1, RED);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0){
            x.left = put(x.left, key, value);
        }else if (cmp > 0){
            x.right = put(x.right, key, value);
        }else {
            x.value = value;
        }
        //左黑右红，一次左旋转
        if (isRed(x.left) && !isRed(x.right)){
            x = rotateLeft(x);
        }
        //左红 左左红，一次右旋转
        if (isRed(x.left) && isRed(x.left.left)){
            x = rotateRight(x);
        }
        //左红右红，变色
        if (isRed(x.left) && isRed(x.right)){
            flipColor(x);
        }
        recalculateSize(x);
        return x;
    }

    /**
     * 删除最小值
     *  1.当前节点的左孩子是3-节点，过
     *  2.当前节点的左孩子是2-节点，但是兄弟节点是3-节点，此时可以向兄弟节点借一个过来，保证自己不是2-节点；
     *  3.当前节点左孩子右孩子都是2-节点，则向父节点借一个，并将借的节点和左孩子右孩子合并。
     */
    public void deleteMin(){

    }

    /*private Node delMin(Node node) {

    }*/

    //这是用于删除节点的flipColor方法，该方法用于节点的合并，将父节点中的部分给与子节点
    private void moveFlipColor(Node x){
        x.color = BLACK;
        x.left.color = RED;
        x.right.color = RED;
    }

    /*private Node moveRedLeft(Node h) {
        moveFlipColor(h);

    }*/

    public static void main(String[] args) {
        RedBlackBST<Integer, Integer> redBlackBST = new RedBlackBST<>();
        redBlackBST.put(2,5);
        redBlackBST.put(3,5);
        redBlackBST.put(1,5);
        System.out.println(Integer.MAX_VALUE);
    }
}
