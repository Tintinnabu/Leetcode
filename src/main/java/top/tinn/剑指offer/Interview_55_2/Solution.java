package top.tinn.剑指offer.Interview_55_2;

import org.junit.jupiter.api.Test;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/5 21:50
 */
public class Solution {

    //后序遍历
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        if (left == -1) return -1;
        int right = helper(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

    @Test
    public void test(){
        String treeNode = "[1,2,2,3,3,null,null,4,4]";
        System.out.println(isBalanced(MainClass.stringToTreeNode(treeNode)));
    }
}
