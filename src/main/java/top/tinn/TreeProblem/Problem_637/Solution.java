package top.tinn.TreeProblem.Problem_637;

import top.tinn.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 637. 二叉树的层平均值
 *
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 *
 * 示例 1:
 *
 * 输入:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出: [3, 14.5, 11]
 * 解释:
 * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
 * 注意：
 *
 * 节点值的范围在32位有符号整数范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    //递归法 DFS
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result=new ArrayList<>();
        List<Integer> count=new ArrayList<>();
        DFS(root,result,count,0);
        for (int i=0;i<result.size();i++)
            result.set(i,result.get(i)/count.get(i));
        return result;
    }

    private void DFS(TreeNode root,List<Double> result,List<Integer> count,int depth){
        if (root==null) return;
        if (depth==count.size()){
            count.add(1);
            result.add(root.val*1.0);
        }else {
            count.set(depth,count.get(depth)+1);
            result.set(depth,result.get(depth)+root.val);
        }
        DFS(root.left,result,count,depth+1);
        DFS(root.right,result,count,depth+1);
    }

    //迭代法：BFS操作队列即可，太简单不写了
}
