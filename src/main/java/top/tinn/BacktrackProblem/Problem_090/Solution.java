package top.tinn.BacktrackProblem.Problem_090;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II
 *
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        backtrack(nums,0,new ArrayList<>(),result);
        return result;
    }

    private void backtrack(int[] nums,int start,List<Integer> temp,List<List<Integer>> result){
        result.add(new ArrayList<>(temp));
        for (int i=start;i<nums.length;i++){
            if (i>start&&nums[i]==nums[i-1]) continue;
            temp.add(nums[i]);
            backtrack(nums,i+1,temp,result);
            temp.remove(temp.size()-1);
        }
    }

    @Test
    public void test(){
        int[] nums={1,2,2};
        System.out.println(subsetsWithDup(nums));
    }
}
