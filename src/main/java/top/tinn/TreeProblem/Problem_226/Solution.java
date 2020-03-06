package top.tinn.TreeProblem.Problem_226;

import top.tinn.utils.TreeNode;

/**
 * 226. 翻转二叉树
 *
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root!=null){
            TreeNode leftNode=invertTree(root.left);
            TreeNode rightNode=invertTree(root.right);
            root.right=leftNode;
            root.left=rightNode;
        }
        return root;
    }
}
