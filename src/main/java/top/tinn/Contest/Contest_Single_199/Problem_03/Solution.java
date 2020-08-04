package top.tinn.Contest.Contest_Single_199.Problem_03;

import org.junit.jupiter.api.Test;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

public class Solution {
    private int ans = 0;
    public int countPairs(TreeNode root, int distance) {
        if (root == null){
            return 0;
        }
        if (root.left != null){
            countPairs(root.left, distance);
        }
        if (root.right != null){
            countPairs(root.right, distance);
        }
        if (root.left != null && root.right != null){
            countPairs(root.left, root.right, distance, 2);
        }
        return ans;
    }

    private void countPairs(TreeNode left, TreeNode right, int distance, int val) {
        if (val > distance || left == null || right == null){
            return;
        }
        if (isLeaf(left) && isLeaf(right)){
            ans++;
            return;
        }else if (isLeaf(left)){
            val += 1;
            countPairs(left, right.left, distance, val);
            countPairs(left, right.right, distance, val);
        }else if (isLeaf(right)){
            val += 1;
            countPairs(left.left, right, distance, val);
            countPairs(left.right, right, distance, val);
        }else {
            val += 2;
            countPairs(left.left, right.left, distance, val);
            countPairs(left.left, right.right, distance, val);
            countPairs(left.right, right.left, distance, val);
            countPairs(left.right, right.right, distance, val);
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    @Test
    public void test(){
        String tree = "[7,1,4,6,null,5,3,null,null,null,null,null,2]";
        TreeNode root = MainClass.stringToTreeNode(tree);
        int distance = 3;
        System.out.println(countPairs(root, distance));
    }
}
