package top.tinn.Contest_26.Problem_3;

import top.tinn.utils.TreeNode;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/16 22:40
 */
public class Solution {
    private int ret = 0;
    public int goodNodes(TreeNode root) {
        maxNodeVal(root, Integer.MIN_VALUE);
        return ret;
    }


    private int maxNodeVal(TreeNode root, int max){
        if (root == null){
            return max;
        }
        if (root.val >= max){
            ret++;
            max = root.val;
        }
        maxNodeVal(root.left, max);
        maxNodeVal(root.right, max);
        return max;
    }
}
