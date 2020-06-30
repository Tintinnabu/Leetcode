package top.tinn.Over200.Problem_209;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0, ans = nums.length + 1;
        int l = 0, r = 0;
        while (r < nums.length){
            sum += nums[r];
            r++;
            while (sum >= s){
                ans = Math.min(ans, r - l);
                sum -= nums[l];
                l++;
            }
        }
        return ans == nums.length + 1 ? 0 : ans;
    }

    @Test
    public void test(){
        int s = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(s, nums));
    }
}
