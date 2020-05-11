package top.tinn.剑指offer.Interview_53_2;

import org.junit.jupiter.api.Test;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/5 21:18
 */
public class Solution {
    //异或法
    public int missingNumber(int[] nums) {
        int bit = nums.length;
        for (int i = 0; i < nums.length; i++){
            bit ^= nums[i];
            bit ^= i;
        }
        return bit;
    }

    //二分法
    public int missingNumber2(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int mid = l + (r - l)/2;
            if (nums[mid] != mid){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }

    @Test
    public void test(){
        int[] nums = {0,1,2,3,4,5,7,8,9};
        System.out.println(missingNumber2(nums));
    }
}
