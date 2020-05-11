package top.tinn.剑指offer.Interview_07;

import org.junit.jupiter.api.Test;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/7 10:51
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int pLeft, int pRight, int iLeft, int iRight) {
        if (pLeft > pRight || iLeft > iRight) return null;
        int rootVal = preorder[pLeft];
        TreeNode root = new TreeNode(preorder[pLeft]);
        int k = iLeft;
        while (inorder[k] != rootVal)
            k++;
        root.left = buildTree(preorder, inorder, pLeft + 1, pLeft + k - iLeft, iLeft, k - 1);
        root.right = buildTree(preorder, inorder, pLeft + k - iLeft + 1, pRight, k + 1, iRight);
        return root;
    }

    @Test
    public void test(){
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println(treeNode);
    }
}
