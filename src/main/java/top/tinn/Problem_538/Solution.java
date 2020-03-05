package top.tinn.Problem_538;

import sun.reflect.generics.tree.Tree;
import top.tinn.utils.TreeNode;

import java.util.Stack;

/**
 * 538. 把二叉搜索树转换为累加树
 *
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 例如：
 *
 * 输入: 二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    private int sum=0;
    public TreeNode convertBST(TreeNode root) {
        if(root!=null){
            convertBST(root.right);
            sum+=root.val;
            root.val=sum;
            convertBST(root.left);
        }
        return root;
    }

    public TreeNode convertBST2(TreeNode root) {
        int sum=0;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode node=root;
        while(!stack.isEmpty()||node!=null){
            while (node!=null){
                stack.push(node);
                node=node.right;
            }
            node=stack.pop();
            sum+=node.val;
            node.val=sum;

            node=node.left;
        }
        return root;
    }
}
