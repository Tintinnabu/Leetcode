package top.tinn.DpProblem.Problem_097;

import org.junit.jupiter.api.Test;

/**
 * 97. 交错字符串
 *
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 *
 * 示例 1:
 *
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 * 示例 2:
 *
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/interleaving-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length()!=s1.length()+s2.length()) return false;
        boolean[][] dp=new boolean[s1.length()+1][s2.length()+1];
        for (int i=0;i<=s1.length();i++){
            for (int j=0;j<=s2.length();j++){
                if (i==0&&j==0) dp[i][j]=true;
                else if (i==0) dp[i][j]=dp[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1);
                else if (j==0) dp[i][j]=dp[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1);
                else dp[i][j]=(dp[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1))||(dp[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1));
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public boolean isInterleave2(String s1, String s2, String s3) {
        if(s3.length()!=s1.length()+s2.length()) return false;
        boolean[] dp=new boolean[s2.length()+1];
        for (int i=0;i<=s1.length();i++){
            for (int j=0;j<=s2.length();j++){
                if (i==0&&j==0) dp[j]=true;
                else if (i==0) dp[j]=dp[j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1);
                else if (j==0) dp[j]=dp[j]&&s1.charAt(i-1)==s3.charAt(i+j-1);
                else dp[j]=(dp[j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1))||(dp[j]&&s1.charAt(i-1)==s3.charAt(i+j-1));
            }
        }
        return dp[s2.length()];
    }

    @Test
    public void test(){
        System.out.println(isInterleave2("a", "b",  "a"));
    }
}
