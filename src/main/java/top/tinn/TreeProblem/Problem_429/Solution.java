package top.tinn.TreeProblem.Problem_429;



import top.tinn.utils.NTree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N叉树的层序遍历
 *
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *
 * 例如，给定一个 3叉树 :
 *
 *  
 *
 *
 *
 *  
 *
 * 返回其层序遍历:
 *
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 *  
 *
 * 说明:
 *
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    //bfs
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result=new ArrayList<>();
        if (root==null) return result;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            List<Integer> temp=new ArrayList<>();
            while (size>0){
                Node node=queue.poll();
                temp.add(node.val);
                for (Node n:node.children)
                    queue.offer(n);
            }
            result.add(temp);
        }
        return result;
    }

    //dfs
    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> result=new ArrayList<>();
        helper(root,0,result);
        return result;
    }

    private void helper(Node root, int depth,List<List<Integer>> result) {
        if (root==null) return;
        if (depth==result.size())
            result.add(new ArrayList<Integer>());
        result.get(depth).add(root.val);
        for (Node node:root.children)
            helper(node,depth+1,result);
    }
}
