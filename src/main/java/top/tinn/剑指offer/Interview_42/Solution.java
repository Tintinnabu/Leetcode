package top.tinn.剑指offer.Interview_42;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/1 20:27
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int cur, pre = 0, ret = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            cur = nums[i];
            if (i != 0 && pre > 0){
                cur += pre;
            }
            pre = cur;
            ret = Math.max(ret, cur);
        }
        return ret;
    }
}
