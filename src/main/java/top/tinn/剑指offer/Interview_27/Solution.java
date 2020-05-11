package top.tinn.剑指offer.Interview_27;

import org.junit.jupiter.api.Test;
import top.tinn.utils.ListNode;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/4/30 20:47
 */
public class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = mirrorTree(root.right);
        root.right = mirrorTree(root.left);
        root.left = temp;
        return root;
    }

    @Test
    public void test(){
        String treeNode = "[4,2,7]";
        TreeNode ret = mirrorTree(MainClass.stringToTreeNode(treeNode));
        System.out.println(ret);
    }
}
