package top.tinn.TreeProblem.Problem_144;

import org.junit.jupiter.api.Test;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 *
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    List<Integer> result=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root!=null){
            result.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return result;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if (root==null) return result;
        Stack<TreeNode> stack=new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            result.add(node.val);
            if (node.right!=null) stack.add(node.right);
            if (node.left!=null) stack.add(node.left);
        }
        return result;
    }


    @Test
    public void test(){
        String s="[1,null,2,3]";
        System.out.println(preorderTraversal(MainClass.stringToTreeNode(s)));
        System.out.println(preorderTraversal2(MainClass.stringToTreeNode(s)));
    }
}
