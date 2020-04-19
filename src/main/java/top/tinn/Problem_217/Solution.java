package top.tinn.Problem_217;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Solution
 * @Description
 * @Author Tinn
 * @Date 2020/4/18 20:40
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer n : nums){
            if (set.contains(n))
                return true;
            set.add(n);
        }
        return false;
    }
}
