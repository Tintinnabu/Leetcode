package top.tinn.TreeProblem.Problem_113;

import org.junit.jupiter.api.Test;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root,sum,new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int sum,List<Integer> list){
        if (root==null) return ;
        List<Integer> temp=new ArrayList<>(list);
        temp.add(root.val);
        if (root.val==sum&&root.left==null&&root.right==null) {
            result.add(temp);
        }
        helper(root.left,sum-root.val,temp);
        helper(root.right,sum-root.val,temp);
    }


    @Test
    public void test(){
        String tree="[5,4,8,11,null,13,4,7,2,null,null,5,1]";
        int sum=22;
        System.out.println(pathSum(MainClass.stringToTreeNode(tree),sum));
    }
}
