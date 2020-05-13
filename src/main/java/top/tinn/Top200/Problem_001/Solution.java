package top.tinn.Top200.Problem_001;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/13 15:41
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ret = new int[2];
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i])){
                ret[1] = i;
                ret[0] = map.get(nums[i]);
            }
            map.put(target - nums[i], i);
        }
        return ret;
    }
}
