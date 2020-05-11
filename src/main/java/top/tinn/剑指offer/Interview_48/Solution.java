package top.tinn.剑指offer.Interview_48;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/2 13:03
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, ret = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i)))
                left = Math.max(left, map.get(s.charAt(i)));
            ret = Math.max(ret, i - left + 1);
            map.put(s.charAt(i), i + 1);
        }
        return ret;
    }
}
