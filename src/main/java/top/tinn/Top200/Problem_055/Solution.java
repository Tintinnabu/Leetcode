package top.tinn.Top200.Problem_055;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/27 16:47
 */
public class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++){
            if (maxReach < i){
                return false;
            }
            maxReach = Math.max(i + nums[i], maxReach);
            if (maxReach > nums.length - 2){
                return true;
            }
        }
        return true;
    }
}
