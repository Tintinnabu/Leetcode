package top.tinn.InterviewProblem.面试题17_16;

/**
 * @ClassName SOlution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/11 19:45
 */
public class Solution {
    public int massage(int[] nums) {
        if (nums.length < 1) return 0;
        else if (nums.length < 2) return nums[0];
        int max1 = nums[0];
        int max2 = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++){
            int curMax = Math.max(max1 + nums[i], max2);
            max1 = max2;
            max2 = curMax;
        }
        return Math.max(max1, max2);
    }
}
