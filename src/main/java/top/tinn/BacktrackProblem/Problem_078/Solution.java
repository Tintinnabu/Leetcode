package top.tinn.BacktrackProblem.Problem_078;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        result.add(temp);
        for(int i=0;i<nums.length;i++){
            backtrack(nums[i],result);
        }
        return result;
    }

    private void backtrack(int n,List<List<Integer>> result){
        int size=result.size();
        for(int s=0;s<size;s++){
            List<Integer> tmp=result.get(s);
            result.add(new ArrayList(tmp));
            tmp.add(n);
        }
    }
}
