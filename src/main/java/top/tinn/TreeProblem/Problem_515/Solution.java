package top.tinn.TreeProblem.Problem_515;

import org.junit.jupiter.api.Test;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 515. 在每个树行中找最大值
 *
 * 您需要在二叉树的每一行中找到最大的值。
 *
 * 示例：
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * 输出: [1, 3, 9]
 * 通过次数7,669提交次数13,022
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    //迭代方式 BFS
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if (root==null) return list;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            int max=Integer.MIN_VALUE;
            for (int i=0;i<size;i++){
                TreeNode node=queue.poll();
                max=Math.max(max,node.val);
                if (node.left!=null)
                    queue.offer(node.left);
                if (node.right!=null)
                    queue.offer(node.right);
            }
            list.add(max);
        }
        return list;
    }

    //递归方式 DFS
    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        leverOrder(root,list,0);
        return list;
    }

    private void leverOrder(TreeNode root, List<Integer> list, int level) {
        if (root!=null){
            if (level>=list.size()){
                list.add(level,root.val);
            }else{
                Integer preVal=list.get(level);
                if (root.val>preVal)
                    list.set(level,root.val);
            }
            leverOrder(root.left,list,level+1);
            leverOrder(root.right,list,level+1);
        }
    }

    @Test
    public void test(){
        String tree="[1,3,2,5,3,null,9]";
        List<Integer> res=largestValues(MainClass.stringToTreeNode(tree));
        System.out.println(res);
        List<Integer> res2=largestValues2(MainClass.stringToTreeNode(tree));
        System.out.println(res2);
    }
}
