package top.tinn.TreeProblem.Problem_590;

import top.tinn.utils.NTree.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 590. N叉树的后序遍历
 *
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *  
 *
 *
 *
 *  
 *
 * 返回其后序遍历: [5,6,3,2,4,1].
 *
 *  
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    //递归
    private List<Integer> result=new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root!=null){
            for (Node node:root.children)
                postorder(node);
            result.add(root.val);
        }
        return result;
    }

    //迭代
    public List<Integer> postorder2(Node root) {
        List<Integer> result=new ArrayList<>();
        if (root==null) return result;
        Stack<Node> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            root=stack.pop();
            result.add(0,root.val);
            for (Node node:root.children)
                stack.push(node);
        }
        return result;
    }
}
