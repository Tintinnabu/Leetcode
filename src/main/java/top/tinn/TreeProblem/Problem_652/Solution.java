package top.tinn.TreeProblem.Problem_652;

import org.junit.jupiter.api.Test;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 652. 寻找重复的子树
 *
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *
 * 示例 1：
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * 下面是两个重复的子树：
 *
 *       2
 *      /
 *     4
 * 和
 *
 *     4
 * 因此，你需要以列表的形式返回上述重复子树的根结点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-duplicate-subtrees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    List<TreeNode> result;
    Map<String,Integer> count;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count=new HashMap<>();
        result=new ArrayList<>();
        serialize(root);
        return result;
    }

    private String serialize(TreeNode root) {
        if (root==null) return "#";
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(root.val);
        stringBuilder.append(",");
        stringBuilder.append(serialize(root.left));
        stringBuilder.append(",");
        stringBuilder.append(serialize(root.right));
        String serial= stringBuilder.toString();
        count.put(serial,count.getOrDefault(serial,0)+1);
        if (count.get(serial)==2)
            result.add(root);
        return serial;
    }




    @Test
    public void test(){
        String tree="[1,2,3,4,null,2,4,null,null,4]";
        List<TreeNode> res=findDuplicateSubtrees(MainClass.stringToTreeNode(tree));
    }
}
