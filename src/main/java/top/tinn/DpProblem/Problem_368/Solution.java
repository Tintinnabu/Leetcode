package top.tinn.DpProblem.Problem_368;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new LinkedList<>();
        if (nums.length < 1){
            return res;
        }
        Arrays.sort(nums);
        int max = 0, endIdx = 0;
        int[] dp = new int[nums.length];
        int[] last = new int[nums.length];
        Arrays.fill(last, -1);
        for (int end = 0; end < nums.length; end++){
            for (int start = 0; start < end; start++){
                if (nums[end] % nums[start] == 0 && dp[end] <= dp[start]){
                    dp[end] = dp[start] + 1;
                    last[end] = start;
                }
            }
            if (max < dp[end]){
                max = dp[end];
                endIdx = end;
            }
        }
        for (int i = endIdx; i > - 1; i = last[i]){
            res.add(0, nums[i]);
        }
        return res;
    }
}
