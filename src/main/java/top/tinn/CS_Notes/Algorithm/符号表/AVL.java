package top.tinn.CS_Notes.Algorithm.符号表;

import com.sun.org.apache.bcel.internal.generic.LLOAD;

public class AVL<T extends Comparable<T>> {
    private AVLNode<T> root;
    private class AVLNode<T>{
        T key;
        int height;
        AVLNode<T> left;
        AVLNode<T> right;

        public AVLNode(T key, AVLNode<T> left, AVLNode<T> right) {
            this.key = key;
            this.height = 0;
            this.left = left;
            this.right = right;
        }

        public AVLNode(T key){
            this(key, null, null);
        }
    }

    private int height(AVLNode<T> tree){
        return tree == null ? 0 : tree.height;
    }

    public int height(){
        return height(root);
    }

    private AVLNode<T> leftLeftRotation(AVLNode<T> k2){
        AVLNode<T> k1;
        k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;

        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    private AVLNode<T> rightRightRotation(AVLNode<T> k1){
        AVLNode<T> k2;
        k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;

        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(height(k2.right), k1.height) + 1;
        return k2;
    }

    private AVLNode<T> leftRightRotation(AVLNode<T> k3){
        k3.left = rightRightRotation(k3.left);
        return leftLeftRotation(k3);
    }

    private AVLNode<T> rightLeftRotation(AVLNode<T> k1){
        k1.right = leftLeftRotation(k1.right);
        return rightRightRotation(k1);
    }


    public void insert(T key){
        root = insert(root, key);
    }

    private AVLNode<T> insert(AVLNode<T> root, T key) {
        if (root == null){
            root = new AVLNode<T>(key);

        }else {
            int cmp = key.compareTo(root.key);
            if (cmp < 0){
                root.left = insert(root.left, key);
                if (!isBalanced(root)){
                    if (key.compareTo(root.left.key) < 0){
                        root = leftLeftRotation(root);
                    }else {
                        root = leftRightRotation(root);
                    }
                }
            }else if (cmp > 0){
                root.right = insert(root.right, key);
                if (!isBalanced(root)){
                    if (key.compareTo(root.right.key) > 0){
                        root = rightRightRotation(root);
                    }else {
                        root = rightLeftRotation(root);
                    }
                }
            }else {
                System.out.println("添加失败：不允许添加相同的节点!");
            }
        }
        calculateHeight(root);
        return root;
    }

    private boolean isBalanced(AVLNode<T> root) {
        return Math.abs(root.left.height - root.right.height) < 2;
    }

    private void calculateHeight(AVLNode<T> node){
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }


    public void remove(T key){
        AVLNode<T> z = search(root, key);
        if (z != null){
            root = remove(root, z);
        }else {
            System.out.println("不存在该节点");
        }
    }

    private AVLNode<T> remove(AVLNode<T> root, AVLNode<T> z) {
        if (root == null || z == null){
            return null;
        }
        int cmp = z.key.compareTo(root.key);
        if (cmp < 0){
            root.left = remove(root.left, z);
            if (!isBalanced(root)){
                if (root.right.left.height > root.right.right.height){
                    root = rightLeftRotation(root);
                }else {
                    root = rightRightRotation(root);
                }
            }
        }else if (cmp > 0){
            root.right = remove(root.right, z);
            if (!isBalanced(root)){
                if (root.left.left.height < root.left.right.height){
                    root = leftRightRotation(root);
                }else {
                    root = leftLeftRotation(root);
                }
            }
        } else {
            if (root.left != null && root.right != null){
                if (height(root.left) > height(root.right)){
                    AVLNode<T> max = max(root.left);
                    root.key = max.key;
                    root.left = remove(root.left, max);
                }else {
                    AVLNode<T> min = min(root.right);
                    root.key = min.key;
                    root.right = remove(root.right, min);
                }
            }else {
                root = root.left == null ? root.right : root.left;
            }
            calculateHeight(root);
        }
        return root;
    }

    private AVLNode<T> max(AVLNode<T> root) {
        if (root == null){
            return null;
        }
        while (root.right != null){
            root = root.right;
        }
        return root;
    }

    public AVLNode<T> max(){
        return max(root);
    }

    public AVLNode<T> min(){
        return min(root);
    }

    private AVLNode<T> min(AVLNode<T> root) {
        if (root == null){
            return null;
        }
        while (root.left != null){
            root = root.left;
        }
        return root;
    }

    public AVLNode<T> search(T key){
        return search(root, key);
    }

    private AVLNode<T> search(AVLNode<T> root, T key) {
        if (root == null){
            return null;
        }
        int cmp = key.compareTo(root.key);
        if (cmp < 0){
            return search(root.left, key);
        }else if (cmp > 0){
            return search(root.right, key);
        }
        return root;
    }
}
