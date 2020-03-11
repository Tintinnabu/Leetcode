package top.tinn.BacktrackProblem.Problem_047;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 47. 全排列 II
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used=new boolean[nums.length];
        Deque<Integer>deque=new ArrayDeque(nums.length);
        backtrack(nums, deque,result,0,used);
        return result;
    }

    private void backtrack(int[] nums, Deque<Integer> temp, List<List<Integer>> result, int index, boolean[] used) {
        if (index==nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i=0;i<nums.length;i++){
            if (used[i]) continue;
            if (i>0&&nums[i]==nums[i-1]&&!used[i-1]) continue;
            temp.addLast(nums[i]);
            used[i]=true;
            backtrack(nums,temp,result,index+1,used);
            used[i]=false;
            temp.removeLast();
        }

    }

    @Test
    public void test(){
        int[] nums={1,2,2};
        System.out.println(permuteUnique(nums));
    }
}
