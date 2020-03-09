package top.tinn.TreeProblem.Problem_501;

import org.junit.jupiter.api.Test;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 501. 二叉搜索树中的众数
 *
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    List<Integer> list=new ArrayList<>();
    int preVal=0,curTimes=0,maxTimes=0;
    public int[] findMode(TreeNode root) {
        traversal(root);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private void traversal(TreeNode root) {
        if (root!=null){
            traversal(root.left);
            if (preVal==root.val)
                curTimes++;
            else{
                preVal=root.val;
                curTimes=1;
            }
            if (curTimes==maxTimes)
                list.add(root.val);
            else if (curTimes>maxTimes){
                list.clear();
                list.add(root.val);
                maxTimes=curTimes;
            }
            traversal(root.right);
        }
    }

    @Test
    public void test(){
        String tree="[1,null,2,2]";
        int[] res=findMode(MainClass.stringToTreeNode(tree));
        System.out.println(res);
    }
}
