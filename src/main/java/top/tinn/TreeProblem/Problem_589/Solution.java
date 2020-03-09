package top.tinn.TreeProblem.Problem_589;

import top.tinn.utils.NTree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 589. N叉树的前序遍历
 *
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *  
 *
 *
 *
 *  
 *
 * 返回其前序遍历: [1,3,5,6,2,4]。
 *
 *  
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    //递归
    private List<Integer> result=new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root!=null){
            result.add(root.val);
            for (Node node:root.children)
                preorder(node);
        }
        return result;
    }

    //迭代
    public List<Integer> preorder2(Node root) {
        List<Integer> result=new ArrayList<>();
        if (root==null) return result;
        Stack<Node> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            root=stack.pop();
            result.add(root.val);
            for (int i=root.children.size()-1;i>=0;i--)
                stack.push(root.children.get(i));
        }
        return result;
    }
}
