package top.tinn.Top200.Problem_003;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/13 15:51
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ret = 0;
        int[] indexs = new int[128];
        char[] chars = s.toCharArray();
        for (int l = 0, r = 0; r < s.length(); r++){
            l = Math.max(l, indexs[chars[r]]);
            ret = Math.max(ret, r - l + 1);
            indexs[chars[r]] = r + 1;
        }
        return ret;
    }
}
