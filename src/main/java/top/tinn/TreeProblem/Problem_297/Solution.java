package top.tinn.TreeProblem.Problem_297;

import com.sun.org.apache.bcel.internal.generic.FSUB;
import org.junit.jupiter.api.Test;
import sun.reflect.generics.tree.Tree;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 297. 二叉树的序列化与反序列化
 *
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 示例: 
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null) return "[]";
        StringBuilder sb=new StringBuilder("[");
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            for (int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if (node==null){
                    sb.append("null,");
                }else{
                    sb.append(node.val);
                    sb.append(",");
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }
        return sb.substring(0,sb.length()-1)+"]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;
        data=data.substring(1,data.length()-1);
        String[] datas=data.split(",");
        Queue<TreeNode> queue=new LinkedList<>();
        TreeNode root=new TreeNode(Integer.parseInt(datas[0]));
        queue.add(root);
        int i=1;
        while (!queue.isEmpty()&&i<datas.length){
            int size=queue.size();
            for (int j=0;j<size;j++){
                TreeNode node=queue.poll();
                TreeNode lNode=null,rNode=null;
                if (!datas[i].equals("null")){
                    lNode=new TreeNode(Integer.parseInt(datas[i]));
                }
                if (!datas[i+1].equals("null")){
                    rNode=new TreeNode(Integer.parseInt(datas[i+1]));
                }
                i+=2;
                node.left=lNode;
                node.right=rNode;
                if (lNode!=null)
                    queue.add(lNode);
                if (rNode!=null)
                    queue.add(rNode);
            }
        }
        return root;
    }

    @Test
    public void test(){
        String tree="[1,2,3,null,null,4,5]";
        String serial=serialize(MainClass.stringToTreeNode(tree));
        TreeNode root=deserialize(serial);
        System.out.println(serialize(MainClass.stringToTreeNode(tree)));
        System.out.println(serialize(root));
    }
}
