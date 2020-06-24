package top.tinn.TreeProblem.Problem_1038;

import top.tinn.utils.TreeNode;

public class Solution {
    //inorder: right - root - left
    private int pre = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root == null){
            return null;
        }
        bstToGst(root.right);
        pre += root.val;
        root.val = pre;
        bstToGst(root.left);
        return root;
    }
}

