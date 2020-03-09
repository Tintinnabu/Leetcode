package top.tinn.TreeProblem.Problem_572;

import org.junit.jupiter.api.Test;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

/**
 * 572. 另一个树的子树
 *
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 示例 1:
 * 给定的树 s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 *
 * 示例 2:
 * 给定的树 s：
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class Solution {
    /**
     * 一个树是另一个树的子树 则
     * 要么这两个树相等
     * 要么这个树是左树的子树
     * 要么这个树hi右树的子树
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s==null) return false;
        return isEqual(s,t)||isSubtree(s.left,t)||isSubtree(s.right,t);
    }

    private boolean isEqual(TreeNode s, TreeNode t) {
        if (s==null&&t==null) return true;
        else  if (s!=null&&t==null) return false;
        else if (s==null&&t!=null) return false;
        else if (s.val!=t.val) return false;
        else return isEqual(s.left,t.left)&&isEqual(s.right,t.right);
    }

    @Test
    public void test(){
        String stree="[3,4,5,1,2]";
        String ttree="[4,1,2]";
        System.out.println(isSubtree(MainClass.stringToTreeNode(stree),MainClass.stringToTreeNode(ttree)));
    }
}
