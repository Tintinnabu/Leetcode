package top.tinn.剑指offer.Interview_53_1;

import org.junit.jupiter.api.Test;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/2 16:53
 */
public class Solution {
    public int search(int[] nums, int target) {
        int left = getLeftPosition(nums, target);
        int right = getRightPosition(nums, target);
        return right - left - 1;
    }

    private int getRightPosition(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int mid = (r - l) / 2 + l;
            if (nums[mid] <= target) l = mid + 1;
            else if (nums[mid] > target) r = mid - 1;
        }
        return l;
    }

    private int getLeftPosition(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int mid = (r - l) / 2 + l;
            if (nums[mid] >= target) r = mid - 1;
            else if (nums[mid] < target) l = mid + 1;

        }
        return r;
    }

    @Test
    public void test(){
        int[] nums = {5,7,7,8,8,10};
        System.out.println(getLeftPosition(nums, 8));
        System.out.println(getRightPosition(nums,8));
        System.out.println(search(nums, 8));
    }
}
