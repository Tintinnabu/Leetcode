package top.tinn.TreeProblem.Problem_098;

import org.junit.jupiter.api.Test;
import sun.reflect.generics.tree.Tree;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

import java.util.Stack;

/**
 * 98. 验证二叉搜索树
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    //中序遍历法
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        double inorder=-Double.MAX_VALUE;
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if (root.val<=inorder) return false;
            inorder=root.val;
            root=root.right;
        }
        return true;
    }


    private long pre = Long.MIN_VALUE;
    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        if(!isValidBST2(root.left)) return false;
        if (root.val <= pre) return false;
        pre = root.val;
        return isValidBST2(root.right);
    }

    @Test
    public void test(){

        System.out.println(isValidBST(MainClass.stringToTreeNode("[5,1,4,null,null,3,6]")));
        System.out.println(isValidBST(MainClass.stringToTreeNode("[0]")));
        //System.out.println(isValidBST2(MainClass.stringToTreeNode("[5,1,4,null,null,3,6]")));
        System.out.println(isValidBST2(MainClass.stringToTreeNode("[0]")));
    }
}
