package top.tinn.TreeProblem.Problem_101;

import org.junit.jupiter.api.Test;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

import java.util.Stack;

/**
 * 101. 对称二叉树
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 *
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    //先序遍历
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return isSymmetric(root.left,root.right);

    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left==null&&right==null) return true;
        else if (left==null||right==null) return false;
        else if (left.val!=right.val) return false;
        return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
    }

    //基于栈的层次遍历
    public boolean isSymmetric2(TreeNode root) {
        if (root==null) return true;
        Stack<TreeNode> stack1=new Stack<>();
        Stack<TreeNode> stack2=new Stack<>();
        stack1.push(root.left);
        stack2.push(root.right);
        while (!stack1.isEmpty()&&!stack2.isEmpty()){
            TreeNode curr1=stack1.pop();
            TreeNode curr2=stack2.pop();
            if (curr1!=null&&curr2!=null&&curr1.val==curr2.val){
                stack1.push(curr1.right);
                stack1.push(curr1.left);
                stack2.push(curr2.left);
                stack2.push(curr2.right);
            }else if (curr1==null&&curr2==null) continue;
            else return false;
        }
        return true;
    }

    @Test
    public void test(){
        String s="[1,2,2,null,3,null,3]";
        System.out.println(isSymmetric2(MainClass.stringToTreeNode(s)));
    }
}
