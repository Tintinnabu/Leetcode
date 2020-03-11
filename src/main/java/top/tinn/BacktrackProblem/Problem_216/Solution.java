package top.tinn.BacktrackProblem.Problem_216;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III
 *
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result=new ArrayList<>();
        backtrack(k,n,1,new ArrayList<>(),result);
        return result;
    }

    private void backtrack(int k, int n, int start, List<Integer> temp, List<List<Integer>> result) {
        if (k==0&&n==0){
            result.add(new ArrayList<>(temp));
            return;
        }
        else if (k==0||n<=0) return;
        for (int i=start;i<=n&&i<=9;i++){
            temp.add(i);
            backtrack(k-1,n-i,i+1,temp,result);
            temp.remove(temp.size()-1);
        }
    }

    @Test
    public void test(){
        System.out.println(combinationSum3(3,9));
    }
}
