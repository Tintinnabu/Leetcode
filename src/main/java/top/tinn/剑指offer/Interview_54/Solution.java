package top.tinn.剑指offer.Interview_54;

import org.junit.jupiter.api.Test;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/5 21:37
 */
public class Solution {
    //中序遍历
    private int k;
    private int ret;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        kthLargest(root);
        return ret;
    }

    public void kthLargest(TreeNode root) {
        if (root == null) return;
        kthLargest(root.right);
        if (--k == 0) ret = root.val;
        kthLargest(root.left);
    }

    @Test
    public void test(){
        String TreeNode = "[3,1,4,null,2]";
        int k = 1;
        System.out.println(kthLargest(MainClass.stringToTreeNode(TreeNode), k));
    }
}
