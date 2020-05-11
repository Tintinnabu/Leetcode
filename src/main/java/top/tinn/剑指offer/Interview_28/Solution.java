package top.tinn.剑指offer.Interview_28;

import top.tinn.utils.TreeNode;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/4/30 20:58
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSame(root.left, root.right);
    }

    private boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left == null || right == null || left.val != right.val) return false;
        else{
            return isSame(left.left, right.right) && isSame(left.right, right.left);
        }
    }
}
