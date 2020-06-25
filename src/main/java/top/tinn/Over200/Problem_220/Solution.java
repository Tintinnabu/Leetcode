package top.tinn.Over200.Problem_220;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++){
            Long ceiling = set.ceiling((long)nums[i] - t);
            if (ceiling != null && ceiling <= (long)nums[i] + t){
                return true;
            }
            set.add((long)nums[i]);
            if (set.size() == k + 1){
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }
}
