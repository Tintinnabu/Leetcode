package top.tinn.Contest.Contest_Single_197.Problem_01;

import java.util.Arrays;

public class Solution {
    public int numIdenticalPairs(int[] nums) {
        Arrays.sort(nums);
        int pre = -1;
        int ans = 0, len = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != pre){
                pre = nums[i];
                ans += (len - 1) * len / 2;
                len = 1;
            }else{
                len++;
            }
        }
        ans += (len - 1) * len / 2;
        return ans;
    }
}
