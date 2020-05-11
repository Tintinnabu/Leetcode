package top.tinn.剑指offer.Interview_34;

import org.junit.jupiter.api.Test;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/1 9:24
 */
public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(root, sum, ret, new ArrayList<>());
        return ret;
    }

    private void dfs(TreeNode root, int sum, List<List<Integer>> ret, List<Integer> cur) {
        if (root == null) return;
        cur.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0)
            ret.add(new ArrayList<>(cur));
        dfs(root.left, sum, ret, cur);
        dfs(root.right, sum, ret, cur);
        cur.remove(cur.size() - 1);
    }

    @Test
    public void test(){
        String treeNode = "[5,4,8,11,null,13,4,7,2,null,null,5,1]";
        System.out.println(pathSum(MainClass.stringToTreeNode(treeNode), 22));
    }
}
