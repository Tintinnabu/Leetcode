package top.tinn.TreeProblem.Problem_449;

import org.junit.jupiter.api.Test;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

import java.util.Arrays;

/**
 * 449. 序列化和反序列化二叉搜索树
 *
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 *
 * 设计一个算法来序列化和反序列化二叉搜索树。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 *
 * 编码的字符串应尽可能紧凑。
 *
 * 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    //先序遍历即可
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null) return "[]";
        StringBuilder stringBuilder=new StringBuilder("[");
        serialize(root,stringBuilder);
        return stringBuilder.substring(0,stringBuilder.length()-1)+"]";
    }

    private void serialize(TreeNode root,StringBuilder stringBuilder){
        if (root!=null){
            stringBuilder.append(root.val);
            stringBuilder.append(",");
            serialize(root.left,stringBuilder);
            serialize(root.right,stringBuilder);
        }
    }

    //通过先序遍历,中序遍历构造二叉搜索树
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;
        data=data.substring(1,data.length()-1);
        String[] datas=data.split(",");
        int[] preorder=new int[datas.length];
        for (int i=0;i<datas.length;i++) preorder[i]=Integer.parseInt(datas[i]);
        int[] inorder=Arrays.copyOf(preorder,preorder.length);
        Arrays.sort(inorder);
        int start=0,end=datas.length-1;
        return deserialize(preorder,inorder,start,end,start,end);
    }

    private TreeNode deserialize(int[] preorder,int[] inorder, int preStart, int preEnd,int inStart,int inEnd) {
        if (preStart>preEnd||inStart>inEnd) return null;
        int fatherVal=preorder[preStart];
        int index=0;
        for (int i=inStart;i<=inEnd;i++)
            if (inorder[i]==fatherVal) {
                index=i;
                break;
            }
        TreeNode root=new TreeNode(fatherVal);
        root.left=deserialize(preorder,inorder,preStart+1,preStart+index-inStart,inStart,index-1);
        root.right=deserialize(preorder,inorder,preStart+index-inStart+1,preEnd,index+1,inEnd);
        return root;
    }


    @Test
    public void test(){
        String tree="[1,null,2]";
        TreeNode root= MainClass.stringToTreeNode(tree);
        String serialTree=serialize(root);
        TreeNode root2=deserialize(serialTree);
        System.out.println(serialize(root2));
        //System.out.println(serialize(root));
    }
}
