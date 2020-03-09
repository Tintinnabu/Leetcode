package top.tinn.TreeProblem.Problem_538;

import org.junit.jupiter.api.Test;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

/**
 * 538. 把二叉搜索树转换为累加树
 *
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 *  
 *
 * 例如：
 *
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *  
 *
 * 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    int sum=0;
    public TreeNode convertBST(TreeNode root) {
        if (root==null) return null;
        convertBST(root.right);
        sum+=root.val;
        root.val=sum;
        convertBST(root.left);
        return root;
    }


    @Test
    public void test() {
        String tree = "[1,null,2]";
        TreeNode root=convertBST(MainClass.stringToTreeNode(tree));
    }
}
