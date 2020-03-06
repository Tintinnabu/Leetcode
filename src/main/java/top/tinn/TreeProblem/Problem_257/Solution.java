package top.tinn.TreeProblem.Problem_257;

import com.sun.org.apache.xerces.internal.impl.xs.models.XSCMUniOp;
import org.junit.jupiter.api.Test;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result=new ArrayList<>();
        binaryTreePaths(root,"",result);
        return result;
    }

    private void  binaryTreePaths(TreeNode root,String curString,List<String> result){
        if (root!=null&&root.left==null&&root.right==null){
            curString=curString+root.val;
            result.add(curString);
        }
        if (root!=null){
            curString=curString+root.val+"->";
            binaryTreePaths(root.left,curString,result);
            binaryTreePaths(root.right,curString,result);
        }
    }

    @Test
    public void test(){
        String tree="[1,2,3,null,5]";
        System.out.println(binaryTreePaths(MainClass.stringToTreeNode(tree)));
    }
}
