package top.tinn.TreeProblem.Problem_687;

import org.junit.jupiter.api.Test;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

/**
 * 687. 最长同值路径
 *
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 *
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 *
 * 示例 1:
 *
 * 输入:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * 输出:
 *
 * 2
 * 示例 2:
 *
 * 输入:
 *
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * 输出:
 *
 * 2
 * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-univalue-path
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    //过root节点的最大路径
    public int longestUnivaluePath(TreeNode root) {
        if (root==null) return 0;
        int left=longestUnivaluePath(root.left);
        int right=longestUnivaluePath(root.right);
        return Math.max(Math.max(left,right),helper(root.left,root.val)+helper(root.right,root.val));

    }

    //node.val等于value的单向最大路径
    private int helper(TreeNode node,int value){
        if (node==null||node.val!=value) return 0;
        return 1+Math.max(helper(node.left,value),helper(node.right,value));
    }

    @Test
    public void test(){
        String tree="[5,4,5,4,4,5,5,4]";
        System.out.println(longestUnivaluePath(MainClass.stringToTreeNode(tree)));
    }
}
