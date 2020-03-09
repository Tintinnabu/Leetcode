package top.tinn.TreeProblem.Problem_654;

import org.junit.jupiter.api.Test;
import top.tinn.utils.TreeNode;

/**
 * 654. 最大二叉树
 *
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 *  
 *
 * 示例 ：
 *
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 *  
 *
 * 提示：
 *
 * 给定的数组的大小在 [1, 1000] 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums,0,nums.length-1);
    }
    private TreeNode constructMaximumBinaryTree(int[] nums,int start,int end){
        if (start>end) return null;
        int maxValIndex=start;
        for (int i=start+1;i<=end;i++){
            if (nums[i]>nums[maxValIndex]) maxValIndex=i;
        }
        TreeNode root=new TreeNode(nums[maxValIndex]);
        root.left=constructMaximumBinaryTree(nums,start,maxValIndex-1);
        root.right=constructMaximumBinaryTree(nums,maxValIndex+1,end);
        return root;
    }


    @Test
    public void test(){
        int[] tree=new int[]{3,2,1,6,0,5};
        TreeNode root=constructMaximumBinaryTree(tree);
    }
}
