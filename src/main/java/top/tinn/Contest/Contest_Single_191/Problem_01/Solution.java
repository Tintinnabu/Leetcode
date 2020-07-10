package top.tinn.Contest.Contest_Single_191.Problem_01;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/31 10:26
 */
public class Solution {
    public int maxProduct(int[] nums) {
        int ret = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                ret = Math.max(ret, (nums[i] - 1) * (nums[j] - 1));
            }
        }
        return ret;
    }
}
