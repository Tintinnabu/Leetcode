package top.tinn.TreeProblem.Problem_103;

import org.junit.jupiter.api.Test;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层次遍历
 *
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root==null) return new ArrayList<>();
        List<List<Integer>> result=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int flag=0;
        while (!queue.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            int size=queue.size();
            for (int i=0;i<size;i++){
                TreeNode head=queue.poll();
                temp.add(head.val);
                if (head.left!=null) queue.add(head.left);
                if (head.right!=null) queue.add(head.right);
            }
            if (flag%2==0)
                result.add(temp);
            else{
                Collections.reverse(temp);
                result.add(temp);
            }
            flag++;
        }
        return result;
    }

    @Test
    public void test(){
        String s="[3,9,20,null,null,15,7]";
        System.out.println(zigzagLevelOrder(MainClass.stringToTreeNode(s)));;
    }
}
