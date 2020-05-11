package top.tinn.剑指offer.Interview_57_1;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/5 22:23
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int sum = 0;
        while (l < r){
            sum = nums[l] + nums[r];
            if (sum == target) return new int[]{nums[l], nums[r]};
            else if (sum < target) l++;
            else  r--;
        }
        return new int[0];
    }
}
