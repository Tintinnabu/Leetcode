package top.tinn.Over200.Problem_1365;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] cnt = new int[101];
        for (int num : nums){
            cnt[num]++;
        }
        for (int i = 1; i <= 100; i++){
            cnt[i] += cnt[i - 1];
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0){
                ans[i] = 0;
            }else {
                ans[i] = cnt[nums[i] - 1];
            }
        }
        return ans;
    }

    @Test
    public void test(){
        int[] nums = {8, 1, 1,1, 2, 4, 2, 3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
    }
}
