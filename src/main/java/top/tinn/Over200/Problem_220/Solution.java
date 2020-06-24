package top.tinn.Over200.Problem_220;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            for (Integer key : map.keySet()){
                if (Math.abs(key - nums[i]) <= t && Math.abs(map.get(key) - i) <= k){
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
