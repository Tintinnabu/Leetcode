package top.tinn.TreeProblem.Problem_653;

import top.tinn.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 653. 两数之和 IV - 输入 BST
 *
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * 案例 1:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * 输出: True
 *  
 *
 * 案例 2:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list=new ArrayList<>();
        traversal(root,list);
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum == k)
                return true;
            if (sum < k)
                l++;
            else
                r--;
        }
        return false;
    }

    private void traversal(TreeNode root,List<Integer> list) {
        if (root!=null){
            traversal(root.left,list);
            list.add(root.val);
            traversal(root.right,list);
        }
    }
}
