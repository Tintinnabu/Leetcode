package top.tinn.DpProblem.Problem_516;

import org.junit.jupiter.api.Test;

/**
 * 516. 最长回文子序列
 *
 * 给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
 *
 * 示例 1:
 * 输入:
 *
 * "bbbab"
 * 输出:
 *
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 *
 * 示例 2:
 * 输入:
 *
 * "cbbd"
 * 输出:
 *
 * 2
 * 一个可能的最长回文子序列为 "bb"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int longestPalindromeSubseq(String s) {
        int size=s.length();
        int[][] dp=new int[size][size];
        for (int len=0;len<size;len++){
            for (int start=0;start+len<size;start++){
                int end=start+len;
                if (start==end) dp[start][end]=1;
                else if (start+1==end){
                    if (s.charAt(start)==s.charAt(end))
                        dp[start][end]=2;
                    else dp[start][end]=1;
                }
                else {
                    if (s.charAt(start)==s.charAt(end))
                        dp[start][end]=2+dp[start+1][end-1];
                    else dp[start][end]=Math.max(dp[start+1][end],dp[start][end-1]);
                }
            }
        }
        return dp[0][size-1];
    }

    @Test
    public void test(){
        System.out.println(longestPalindromeSubseq("bbbab"));
    }
}
