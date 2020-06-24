package top.tinn.TreeProblem.Problem_1373;

import top.tinn.utils.TreeNode;

public class Solution {

    public int maxSumBST(TreeNode root) {
        int[] res = {0};
        maxSumBST(res, root);
        return res[0];
    }

    private void maxSumBST(int[] res, TreeNode node) {
        if (isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE)){
            sumNodeValue(res, node);
            return;
        }
        maxSumBST(res, node.left);
        maxSumBST(res, node.right);
    }

    private int sumNodeValue(int[] res, TreeNode node) {
        if (node == null){
            return 0;
        }
        int sum = node.val + sumNodeValue(res, node.left) +
                sumNodeValue(res, node.right);
        res[0] = Math.max(res[0], sum);
        return sum;
    }

    private boolean isBST(TreeNode node, int minValue, int maxValue) {
        if (node == null){
            return true;
        }
        return minValue < node.val && node.val < maxValue &&
                isBST(node.left, minValue, node.val) &&
                isBST(node.right, node.val, maxValue);
    }
}
