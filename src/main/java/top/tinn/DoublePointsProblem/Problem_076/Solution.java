package top.tinn.DoublePointsProblem.Problem_076;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 *
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public String minWindow(String s, String t) {
        int l = 0, r = 0, match = 0, start = 0, len = Integer.MAX_VALUE, size = 0;
        int[] tMap = new int[128];
        int[] windowMap = new int[128];
        for (char c : t.toCharArray()){
            if (tMap[c] == 0){
                size++;
            }
            tMap[c]++;
        }
        char[] chars = s.toCharArray();
        while (r < s.length()){
            if (tMap[chars[r]] > 0){
                windowMap[chars[r]]++;
                if (windowMap[chars[r]] == tMap[chars[r]]){
                    match++;
                }
            }
            while (match == size){
                if (r - l + 1 < len){
                    start = l;
                    len = r - l + 1;
                }
                if (tMap[chars[l]] > 0){
                    windowMap[chars[l]]--;
                    if (windowMap[chars[l]] < tMap[chars[l]]){
                        match--;
                    }
                }
                l++;
            }
            r++;
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    @Test
    public void test(){
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
