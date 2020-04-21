package top.tinn.Problem_395;

import org.junit.jupiter.api.Test;

/**
 * @ClassName Solution
 * @Description
 * 395. 至少有K个重复字符的最长子串
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 *
 * 示例 1:
 *
 * 输入:
 * s = "aaabb", k = 3
 *
 * 输出:
 * 3
 *
 * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2:
 *
 * 输入:
 * s = "ababbc", k = 2
 *
 * 输出:
 * 5
 *
 * 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 * @Author Tinn
 * @Date 2020/4/20 15:39
 */
public class Solution {
    public int longestSubstring(String s, int k) {
        int len = s.length();
        if (len == 0 || k > len) return 0;
        if (k < 2) return len;
        return helper(s.toCharArray(), k, 0, len - 1);
    }

    private int helper(char[] chars, int k, int l, int r) {
        if (r - l + 1 < k) return 0;
        int[] count = new int[26];
        for (int i = l; i <= r; i++){
            count[chars[i] - 'a']++;
        }
        while (r - l + 1 < k && count[chars[l] - 'a'] < k)
            l++;
        while (r - l + 1 < k && count[chars[r] - 'a'] < k)
            r--;
        if (r - l + 1 < k) return 0;
        for (int i = l; i <= r; i++){
            if (count[chars[i] - 'a'] < k){
                return Math.max(helper(chars, k, l, i - 1), helper(chars, k, i + 1, r));
            }
        }
        return r - l + 1;
    }


    @Test
    public void test(){
        String s = "aaabb";
        int k = 3;
        System.out.println(longestSubstring(s, k));
    }
}
