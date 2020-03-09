package top.tinn.TreeProblem.Problem_671;

import org.junit.jupiter.api.Test;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

/**
 * 671. 二叉树中第二小的节点
 *
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。 
 *
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   2   5
 *      / \
 *     5   7
 *
 * 输出: 5
 * 说明: 最小的值是 2 ，第二小的值是 5 。
 * 示例 2:
 *
 * 输入:
 *     2
 *    / \
 *   2   2
 *
 * 输出: -1
 * 说明: 最小的值是 2, 但是不存在第二小的值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    private int min;
    public int findSecondMinimumValue(TreeNode root) {
        if (root==null) return -1;
        min=root.val;
        return helper(root);
    }

    private int helper(TreeNode node){
        if (node!=null){
            if (node.val>min) return node.val;
            int left=helper(node.left);
            int right=helper(node.right);
            if (left==-1&&right==-1) return -1;
            else if (left!=-1&&right!=-1) return Math.min(helper(node.left),helper(node.right));
            return Math.max(helper(node.left),helper(node.right));
        }
        return -1;
    }

    @Test
    public void test(){
        String tree="[1,1,3,1,1,3,4,3,1,1,1,3,8,4,8,3,3,1,6,2,1]\n";
        System.out.println(findSecondMinimumValue(MainClass.stringToTreeNode(tree)));
    }
}
