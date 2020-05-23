package top.tinn.Top200.Problem_015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/23 21:36
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++){
            if (i == 0 || nums[i] != nums[i - 1]){
                if (nums[i] > 0) break;
                int l = i + 1, r = nums.length - 1, target = 0 - nums[i];
                while (l < r){
                    if (nums[l] + nums[r] == target){
                        ret.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;r--;
                    }else if (nums[l] + nums[r] < target){
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        l++;
                    }else {
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;
                    }
                }
            }
        }
        return ret;
    }
}
