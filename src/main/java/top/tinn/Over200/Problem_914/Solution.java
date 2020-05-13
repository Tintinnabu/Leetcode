package top.tinn.Over200.Problem_914;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/13 15:19
 */
public class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int d : deck) map.put(d, map.getOrDefault(d, 0) + 1);
        int pre = -1;
        for (int key : map.keySet()){
            if (pre == -1){
                pre = map.get(key);
            }else if (pre == 1) return false;
            else {
                pre = helper(pre, map.get(key));
            }
        }
        return pre > 1;
    }

    private int helper(int pre, Integer value) {
        if (value == 0) return pre;
        return helper(value, pre % value);
    }
}
