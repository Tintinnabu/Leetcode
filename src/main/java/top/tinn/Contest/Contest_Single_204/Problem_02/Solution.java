package top.tinn.Contest.Contest_Single_204.Problem_02;

import org.junit.jupiter.api.Test;

/**
 * @Author: Tinn
 * @Date: 2020/8/30 11:21
 */
public class Solution {
    public int getMaxLen(int[] nums) {
        int pos = 0, neg = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0){
                pos = 0;
                neg = 0;
            }else if (nums[i] > 0){
                pos++;
                neg = neg > 0 ? neg + 1 : 0;
            }else{
                int temp = neg;
                neg = pos + 1;
                pos = temp > 0 ? temp + 1 : 0;
            }
            ans = Math.max(ans, pos);
        }
        return ans;
    }

    @Test
    public void test(){
        int[] nums = {1, -2, -3, 4};
        System.out.println(getMaxLen(nums));
    }
}
