package top.tinn.TreeProblem.Problem_623;

import org.junit.jupiter.api.Test;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

/**
 * 623. 在二叉树中增加一行
 *
 * 给定一个二叉树，根节点为第1层，深度为 1。在其第 d 层追加一行值为 v 的节点。
 *
 * 添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，为 N 创建两个值为 v 的左子树和右子树。
 *
 * 将 N 原先的左子树，连接为新节点 v 的左子树；将 N 原先的右子树，连接为新节点 v 的右子树。
 *
 * 如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。
 *
 * 示例 1:
 *
 * 输入:
 * 二叉树如下所示:
 *        4
 *      /   \
 *     2     6
 *    / \   /
 *   3   1 5
 *
 * v = 1
 *
 * d = 2
 *
 * 输出:
 *        4
 *       / \
 *      1   1
 *     /     \
 *    2       6
 *   / \     /
 *  3   1   5
 *
 * 示例 2:
 *
 * 输入:
 * 二叉树如下所示:
 *       4
 *      /
 *     2
 *    / \
 *   3   1
 *
 * v = 1
 *
 * d = 3
 *
 * 输出:
 *       4
 *      /
 *     2
 *    / \
 *   1   1
 *  /     \
 * 3       1
 * 注意:
 *
 * 输入的深度值 d 的范围是：[1，二叉树最大深度 + 1]。
 * 输入的二叉树至少有一个节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-one-row-to-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d==1){
            TreeNode nRoot=new TreeNode(v);
            nRoot.left=root;
            return nRoot;
        }
        return getNthDepthNode(root,v,d-2);
    }

    private TreeNode getNthDepthNode(TreeNode root,int v,int d){
        if (d==0&&root!=null){
            //modified;
            if (root.left!=null){
                TreeNode lNode=new TreeNode(v);
                lNode.left=root.left;
                root.left=lNode;
            }else root.left=new TreeNode(v);
            if (root.right!=null){
                TreeNode rNode=new TreeNode(v);
                rNode.right=root.right;
                root.right=rNode;
            }else root.right=new TreeNode(v);
        }else if (d>0&&root!=null){
            getNthDepthNode(root.left,v,d-1);
            getNthDepthNode(root.right,v,d-1);
        }
        return root;
    }

    @Test
    public void test(){
        String tree="[4,2,6,3,1,5]";
        TreeNode root=addOneRow(MainClass.stringToTreeNode(tree),1,3);
        System.out.println(root);
    }
}
