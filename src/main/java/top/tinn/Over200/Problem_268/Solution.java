package top.tinn.Over200.Problem_268;

/**
 * @ClassName Solution
 * @Description
 * @Author Tinn
 * @Date 2020/4/18 20:55
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int ret = nums.length;
        for (int i = 0; i < nums.length; i++){
            ret ^= i;
            ret ^= nums[i];
        }
        return ret;
    }
}
