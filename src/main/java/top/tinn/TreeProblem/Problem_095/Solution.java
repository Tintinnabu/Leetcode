package top.tinn.TreeProblem.Problem_095;

import org.junit.jupiter.api.Test;
import sun.reflect.generics.tree.Tree;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 95. 不同的二叉搜索树 II
 *
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n==0) return new ArrayList<TreeNode>();
        return generateTrees(1,n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> ans=new ArrayList<>();
        //此时没有数字，将 null 加入结果中
        if (end<start){
            ans.add(null);
            return ans;
        }
        //只有一个数字，当前数字作为一棵树加入结果中
        else if (end==start){
            TreeNode node=new TreeNode(start);
            ans.add(node);
            return ans;
        }
        //尝试每个数字作为根节点
        for (int i=start;i<=end;i++){
            //得到所有可能的左子树
            List<TreeNode> leftTrees=generateTrees(start,i-1);
            //得到所有可能的右子树
            List<TreeNode> rightTrees=generateTrees(i+1,end);
            //左子树右子树两两组合
            for (TreeNode lNode:leftTrees){
                for (TreeNode rNode:rightTrees){
                    TreeNode root=new TreeNode(i);
                    root.left=lNode;
                    root.right=rNode;
                    //加入到最终结果中
                    ans.add(root);
                }
            }
        }
        return ans;
    }

    @Test
    public void test(){
        List<TreeNode> result=generateTrees(3);
        System.out.println(result);
    }
}
