package top.tinn.TreeProblem.Problem_222;

import org.junit.jupiter.api.Test;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 222. 完全二叉树的节点个数
 *
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 说明：
 *
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 示例:
 *
 * 输入:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if (root==null) return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int count=0;
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            count++;
            if (node.left!=null)
                queue.add(node.left);
            if (node.right!=null)
                queue.add(node.right);

        }
        return count;
    }


    public int countNodes2(TreeNode root) {
        if (root==null) return 0;
        int left=countLevel(root.left);
        int right=countLevel(root.right);
        if (right==left) return countNodes2(root.right)+(1<<left);
        return countNodes2(root.left)+(1<<right);
    }

    private int countLevel(TreeNode root) {
        int level=0;
        while (root!=null){
            level++;
            root=root.left;
        }
        return level;
    }

    @Test
    public void test(){
        String tree="[1,2,3,4,5,6,7]";
        System.out.println(countNodes2(MainClass.stringToTreeNode(tree)));
    }
}
