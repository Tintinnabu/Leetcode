package top.tinn.Over200.Problem_501;

import top.tinn.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Tinn
 * @Date: 2020/9/24 18:55
 */
public class Solution {
    int pre = (int)1e9;
    int max = 0, num = 0;
    List<Integer> ans = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        TreeNode last = dfs(root);
        if (num > max){
            ans.clear();
            ans.add(last.val);
            max = num;
        }else if (num == max){
            ans.add(last.val);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    private TreeNode dfs(TreeNode node){
        if (node == null){
            return null;
        }
        dfs(node.left);
        if (pre == (int)1e9){
            pre = node.val;
            num++;
        }
        if (node.val != pre){
            if (num > max){
                ans.clear();
                ans.add(node.val);
                max = num;
            }else if (num == max){
                ans.add(node.val);
            }
        }
        dfs(node.right);
        return node;
    }
}
