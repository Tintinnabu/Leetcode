package top.tinn.TreeProblem.Problem_1028;

import top.tinn.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tintinnabu
 * @description
 * @data 2020/6/18
 */
public class Solution {
    //先序遍历 根-左-右
    public TreeNode recoverFromPreorder(String S) {
        Map<Integer, TreeNode> map = new HashMap<>();
        TreeNode dummy = new TreeNode(0);
        map.put(-1, dummy);
        int i = 0;
        while(i < S.length()){
            int depth = 0;
            while(i < S.length() && S.charAt(i) == '-'){
                depth++;
                i++;
            }
            int val = 0;
            while(i < S.length() && S.charAt(i) != '-'){
                val = 10 * val + S.charAt(i) - '0';
                i++;
            }
            TreeNode node = new TreeNode(val);
            TreeNode parent = map.get(depth - 1);
            if (parent.left == null){
                parent.left = node;
            }else{
                parent.right = node;
            }
            map.put(depth, node);
        }
        return dummy.left;
    }
}
