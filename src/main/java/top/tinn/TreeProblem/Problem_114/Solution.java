package top.tinn.TreeProblem.Problem_114;

import sun.reflect.generics.tree.Tree;
import top.tinn.utils.TreeNode;

/**
 * 114. 二叉树展开为链表
 *
 * 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 * 通过次数29,091提交次数42,945
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public void flatten(TreeNode root) {
        while (root!=null){
            if (root.left==null)
                root=root.right;
            else {
                TreeNode pre=root.left;
                while (pre.right!=null) pre=pre.right;
                pre.right=root.right;
                root.right=root.left;
                root.left=null;
                root=root.right;
            }
        }
    }


    private TreeNode pre;
    public void flatten2(TreeNode root) {
        if(root==null) return;
        flatten2(root.right);
        flatten2(root.left);
        root.right=pre;
        root.left=null;
        pre=root;
    }
}
