package top.tinn.TreeProblem.Problem_508;

import org.junit.jupiter.api.Test;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 508. 出现次数最多的子树元素和
 *
 * 给出二叉树的根，找出出现次数最多的子树元素和。一个结点的子树元素和定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。然后求出出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的元素（不限顺序）。
 *
 *  
 *
 * 示例 1
 * 输入:
 *
 *   5
 *  /  \
 * 2   -3
 * 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。
 *
 * 示例 2
 * 输入:
 *
 *   5
 *  /  \
 * 2   -5
 * 返回 [2]，只有 2 出现两次，-5 只出现 1 次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/most-frequent-subtree-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    Map<Integer,Integer> map=new HashMap<>();
    int maxTimes=0;
    List<Integer> list=new ArrayList<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        traversal(root);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private int traversal(TreeNode root){
        if (root==null) return 0;
        int sum=root.val;
        sum+=traversal(root.left)+traversal(root.right);
        map.put(sum,map.getOrDefault(sum,0)+1);
        if (map.get(sum)>maxTimes){
            list.clear();
            list.add(sum);
            maxTimes=map.get(sum);
        }else if (map.get(sum)==maxTimes)
            list.add(sum);
        return sum;
    }

    @Test
    public void test(){
        String tree="[5,2,-5]";
        int[] res=findFrequentTreeSum(MainClass.stringToTreeNode(tree));
        System.out.println(res);
    }
}
