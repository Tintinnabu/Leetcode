package top.tinn.TreeProblem.Problem_513;

import org.junit.jupiter.api.Test;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 513. 找树左下角的值
 *
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 *
 * 示例 1:
 *
 * 输入:
 *
 *     2
 *    / \
 *   1   3
 *
 * 输出:
 * 1
 *  
 *
 * 示例 2:
 *
 * 输入:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * 输出:
 * 7
 *  
 *
 * 注意: 您可以假设树（即给定的根节点）不为 NULL。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int result=0;
        while (!queue.isEmpty()){
            /*int size=queue.size();
            for (int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if (i==0) result=node.val;
                if (node.left!=null)
                    queue.offer(node.left);
                if (node.right!=null)
                    queue.offer(node.right);
            }*/
            root=queue.poll();
            if (root.right!=null)
                queue.offer(root.right);
            if (root.left!=null)
                queue.offer(root.left);
        }
        //return result;
        return root.val;
    }

    @Test
    public void test(){
        String tree="[5,2,-5]";
        int res=findBottomLeftValue(MainClass.stringToTreeNode(tree));
        System.out.println(res);
    }
}
