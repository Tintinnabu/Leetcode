package top.tinn.剑指offer.Interview_26;

import top.tinn.utils.TreeNode;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/4/30 20:33
 */
public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) return false;
        boolean ret = false;
        if (A.val == B.val){
            ret = helper(A, B);
        }
        if (!ret)
            ret = isSubStructure(A.left, B);
        if (!ret)
            ret = isSubStructure(A.right, B);
        return ret;
    }

    private boolean helper(TreeNode a, TreeNode b) {
        if (b == null) return true;
        if (a == null) return false;
        if (a.val == b.val){
            return helper(a.left, b.left) && helper(a.right, b.right);
        }else
            return false;
    }
}
