package top.tinn.TreeProblem.Problem_106;

import org.junit.jupiter.api.Test;
import top.tinn.utils.TreeNode;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(postorder,inorder,0,inorder.length-1,0,postorder.length-1);
    }

    private TreeNode buildTree(int[] postorder,int[] inorder,int posStart,int posEnd,int inStart,int inEnd){
        if (posStart>posEnd||inStart>inEnd) return null;
        int rootVal=postorder[posEnd];
        TreeNode root=new TreeNode(rootVal);
        int index=0;
        for (int i=inStart;i<=inEnd;i++){
            if (inorder[i]==rootVal) index=i;
        }
        root.left=buildTree(postorder,inorder,posStart,posStart+index-inStart-1,inStart,index-1);
        root.right=buildTree(postorder,inorder,posStart+index-inStart,posEnd-1,index+1,inEnd);
        return root;
    }

    @Test
    public void test(){
        int[] postorder=new int[]{9,15,7,20,3};
        int[] inorder=new int[]{9,3,15,20,7};
        TreeNode node=buildTree(inorder,postorder);
        System.out.println(node);
    }
}
