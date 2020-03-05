package top.tinn.TreeProblem.Problem_105;

import org.junit.jupiter.api.Test;
import sun.reflect.generics.tree.Tree;
import top.tinn.utils.TreeNode;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,inorder,0,preorder.length-1,0,preorder.length-1);
    }

    private TreeNode buildTree(int[] preorder,int[] inorder,int preStart,int preEnd,int inStart,int inEnd){
        if (preStart>preEnd||inStart>inEnd) return null;
        int rootVal=preorder[preStart];
        TreeNode root=new TreeNode(rootVal);
        int index=0;
        for (int i=inStart;i<=inEnd;i++){
            if (inorder[i]==rootVal) index=i;
        }
        root.left=buildTree(preorder,inorder,preStart+1,preStart+index-inStart,inStart,index-1);
        root.right=buildTree(preorder,inorder,preStart+index+1-inStart,preEnd,index+1,inEnd);
        return root;
    }

    @Test
    public void test(){
        int[] preorder=new int[]{3,9,20,15,7};
        int[] inorder=new int[]{9,3,15,20,7};
        TreeNode node=buildTree(preorder,inorder);
        System.out.println(node);
    }
}
