package top.tinn.BacktrackProblem.Problem_046;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        backtrack(nums,new LinkedList<>(),result,0);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> temp, List<List<Integer>> result, int index) {
        if (index==nums.length) result.add(new ArrayList<>(temp));
        else {
            for (int i=0;i<=temp.size();i++){
                temp.add(i,nums[index]);
                backtrack(nums,temp,result,index+1);
                temp.remove(i);
            }
        }
    }

    @Test
    public void test(){
        int[] nums={1,2,3};
        System.out.println(permute(nums));
    }
}
