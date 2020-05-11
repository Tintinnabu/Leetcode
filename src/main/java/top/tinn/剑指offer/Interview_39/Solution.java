package top.tinn.剑指offer.Interview_39;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/1 16:24
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int pre = 0;
        int count = 0;
        for (int i = 0; i <nums.length; i++){
            if (count == 0) {
                pre = nums[i];
                count++;
            }else {
                if (nums[i] == pre) count++;
                else count--;
            }
        }
        return pre;
    }
}
