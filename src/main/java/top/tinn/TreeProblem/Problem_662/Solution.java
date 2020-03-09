package top.tinn.TreeProblem.Problem_662;

import org.junit.jupiter.api.Test;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

import java.util.*;

/**
 * 662. 二叉树最大宽度
 *
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 *
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 *
 * 示例 1:
 *
 * 输入:
 *
 *            1
 *          /   \
 *         3     2
 *        / \     \
 *       5   3     9
 *
 * 输出: 4
 * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 * 示例 2:
 *
 * 输入:
 *
 *           1
 *          /
 *         3
 *        / \
 *       5   3
 *
 * 输出: 2
 * 解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
 * 示例 3:
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        /
 *       5
 *
 * 输出: 2
 * 解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
 * 示例 4:
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        /     \
 *       5       9
 *      /         \
 *     6           7
 * 输出: 8
 * 解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
 * 注意: 答案在32位有符号整数的表示范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-width-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth=0;
        if (root==null) return maxWidth;
        ArrayDeque<TreeNode> queue=new ArrayDeque<>();
        queue.offerLast(root);
        TreeNode NULL=new TreeNode(0);
        while (!queue.isEmpty()){
            while (queue.peekFirst()==NULL) queue.pollFirst();
            while (queue.peekLast()==NULL) queue.pollLast();
            int size=queue.size();
            maxWidth=Math.max(size,maxWidth);
            for (int i=0;i<size;i++){
                root=queue.poll();
                if (root!=NULL){
                    queue.offerLast(root.left==null?NULL:root.left);
                    queue.offerLast(root.right==null?NULL:root.right);
                }else {
                    queue.offerLast(NULL);
                    queue.offerLast(NULL);
                }
            }
        }
        return maxWidth;
    }


    int ans;
    Map<Integer,Integer> left;
    public int widthOfBinaryTree2(TreeNode root) {
        ans=0;
        left=new HashMap<>();
        dfs(root,0,0);
        return ans;
    }

    private void dfs(TreeNode root, int depth, int position) {
        if (root == null) return;
        left.computeIfAbsent(depth,x->position);
        ans=Math.max(ans,position-left.get(depth)+1);
        dfs(root.left,depth+1,2*position);
        dfs(root.right,depth+1,2*position+1);
    }


    @Test
    public void test(){
        String tree="[1,3,2,5,3,null,9]";
        int res=widthOfBinaryTree(MainClass.stringToTreeNode(tree));
        System.out.println(res);
    }
}
