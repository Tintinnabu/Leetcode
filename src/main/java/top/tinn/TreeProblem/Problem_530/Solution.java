package top.tinn.TreeProblem.Problem_530;

import org.junit.jupiter.api.Test;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

import java.util.List;

/**
 * 530. 二叉搜索树的最小绝对差
 *
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *  
 *
 * 提示：
 *
 * 树中至少有 2 个节点。
 * 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    int min=Integer.MAX_VALUE;
    int pre=-1;
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return min;
    }

    private void helper(TreeNode root){
        if (root!=null){
            helper(root.right);
            if (pre!=-1)
                min=Math.min(min,pre-root.val);
            pre=root.val;
            helper(root.left);
        }
    }

    @Test
    public void test(){
        String tree="[1,null,2]";
        int res=getMinimumDifference(MainClass.stringToTreeNode(tree));
        System.out.println(res);
    }
}
