package top.tinn.TreeProblem.Problem_1382;

import org.junit.jupiter.api.Test;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sortList = new ArrayList<>();
        inOrder(root, sortList);
        return helper(sortList, 0, sortList.size() - 1);
    }

    private TreeNode helper(List<Integer> sortList, int l, int r) {
        if (l > r){
            return null;
        }
        int mid = l + (r - l >> 1);
        TreeNode root = new TreeNode(sortList.get(mid));
        root.left = helper(sortList, l, mid - 1);
        root.right = helper(sortList, mid + 1, r);
        return root;
    }

    private void inOrder(TreeNode root, List<Integer> sortList) {
        if (root != null){
            inOrder(root.left, sortList);
            sortList.add(root.val);
            inOrder(root.right, sortList);
        }
    }

    @Test
    public void test(){
        String root = "[1,null,2,null,3,null,4,null,null]";
        TreeNode node = balanceBST(MainClass.stringToTreeNode(root));
        System.out.println(1);
    }
}
