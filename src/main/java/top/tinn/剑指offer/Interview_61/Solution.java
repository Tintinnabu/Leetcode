package top.tinn.剑指offer.Interview_61;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/6 21:14
 */
public class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int kings = 0;
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] == 0) kings++;
            else if (nums[i] == nums[i + 1]) return false;
            else if (nums[i] + 1 == nums[i + 1]) continue;
            else {
                if (kings > 0){
                    nums[i]++;
                    i--;
                    kings--;
                }else return false;
            }
        }
        return true;
    }
}
