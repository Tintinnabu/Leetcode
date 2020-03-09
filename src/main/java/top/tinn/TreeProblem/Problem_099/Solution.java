package top.tinn.TreeProblem.Problem_099;

import org.junit.jupiter.api.Test;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 99. 恢复二叉搜索树
 *
 * 二叉搜索树中的两个节点被错误地交换。
 *
 * 请在不改变其结构的情况下，恢复这棵树。
 *
 * 示例 1:
 *
 * 输入: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * 输出: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 * 示例 2:
 *
 * 输入: [3,1,4,null,null,2]
 *
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 *
 * 输出: [2,1,4,null,null,3]
 *
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 * 进阶:
 *
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recover-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    TreeNode lNode,rNode,pre;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp=lNode.val;
        lNode.val=rNode.val;
        rNode.val=temp;
    }

    private void inorder(TreeNode root){
        if (root==null) return;
        inorder(root.left);
        if (pre!=null&&pre.val>root.val){
            if (lNode==null) lNode=pre;
            rNode=root;
        }
        pre=root;
        inorder(root.right);
    }


    @Test
    public void test(){
        String tree="[3,1,4,null,null,2]";
        TreeNode root= MainClass.stringToTreeNode(tree);
        recoverTree(root);
    }
}
