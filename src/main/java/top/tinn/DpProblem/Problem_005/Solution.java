package top.tinn.DpProblem.Problem_005;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/13 16:27
 */
public class Solution {
    //dp
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++){
            dp[i][i] = true;
        }
        int start = 0;
        int maxLen = 1;
        char[] chars = s.toCharArray();
        for (int j = 1; j < len; j++){
            for (int i = 0; i < j; i++){
                if (chars[i] == chars[j]){
                    if (j - i < 3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }else {
                    dp[i][j] = false;
                }
                if (dp[i][j]){
                    if (j - i + 1 > maxLen){
                        maxLen = j - i + 1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    //中心扩展
    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++){
            int len1 = expandAroundCenter(chars, i, i);
            int len2 = expandAroundCenter(chars, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start){
                start = i - (len - 1)/ 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(char[] chars, int i, int j) {
        int l = i, r = j;
        while (l >= 0 && r < chars.length && chars[l] == chars[r]){
            l--;r++;
        }
        return r - l - 1;
    }
}
