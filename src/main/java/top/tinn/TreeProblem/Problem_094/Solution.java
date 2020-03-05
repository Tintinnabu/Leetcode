package top.tinn.TreeProblem.Problem_094;

import org.junit.jupiter.api.Test;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

import java.util.*;

/**
 * 94. 二叉树的中序遍历
 *
 * 给定一个二叉树，返回它的中序 遍历。
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
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while (cur!=null||!stack.isEmpty()){
            if (cur!=null){
                stack.add(cur);
                cur=cur.left;
            }else {
                cur=stack.pop();
                list.add(cur.val);
                cur=cur.right;
            }
        }
        return list;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        inorderTraversal2(root,list);
        return list;
    }

    private void inorderTraversal2(TreeNode root, List<Integer> list) {
        if (root!=null){
            inorderTraversal2(root.left,list);
            list.add(root.val);
            inorderTraversal2(root.right,list);
        }
    }

    @Test
    public void test(){
        String str="[1,null,2,3]";
        System.out.println(inorderTraversal(MainClass.stringToTreeNode(str)));
        System.out.println(inorderTraversal2(MainClass.stringToTreeNode(str)));
    }
}
