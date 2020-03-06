package top.tinn.TreeProblem.Problem_145;

import org.junit.jupiter.api.Test;
import sun.reflect.generics.tree.Tree;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 145. 二叉树的后序遍历
 *
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    List<Integer> result=new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root!=null){
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            result.add(root.val);
        }
        return result;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result=new LinkedList<>();
        if (root==null) return result;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            result.add(0,node.val);
            if (node.left!=null) stack.push(node.left);
            if (node.right!=null) stack.push(node.right);
        }
        return result;
    }

    @Test
    public void test(){
        String s="[1,null,2,3]";
        System.out.println(postorderTraversal(MainClass.stringToTreeNode(s)));
        System.out.println(postorderTraversal2(MainClass.stringToTreeNode(s)));

    }
}
