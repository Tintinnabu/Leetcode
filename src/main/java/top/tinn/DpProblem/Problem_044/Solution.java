package top.tinn.DpProblem.Problem_044;

import org.junit.jupiter.api.Test;

/**
 * 44. 通配符匹配
 *
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 *
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 示例 4:
 *
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 示例 5:
 *
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输入: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wildcard-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        if (p.equals(s)||p.equals("*")) return true;
        if (p.isEmpty()||s.isEmpty()) return false;
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        for (int i=1;i<=p.length();i++){
            dp[0][i]=dp[0][i-1]&&p.charAt(i-1)=='*';
        }
        for (int i=1;i<=s.length();i++){
            for (int j=1;j<=p.length();j++){
                if (s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?')
                    dp[i][j]=dp[i-1][j-1];
                if (p.charAt(j-1)=='*')
                    dp[i][j]=dp[i][j-1]||dp[i-1][j];
            }
        }
        return dp[s.length()][p.length()];
    }

    public boolean isMatch2(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        boolean[][] dp = new boolean[lenP + 1][lenS + 1];
        char[] charS = s.toCharArray();
        char[] charP = p.toCharArray();
        dp[0][0] = true;
        for (int i = 0; i < lenP; i++){
            if (charP[i] == '*'){
                dp[i + 1][0] = dp[i][0];
            }
        }
        for (int i = 0; i < lenP; i++){
            for (int j = 0; j < lenS; j++){
                //匹配一个字符
                if (charP[i] == charS[j] || charP[i] == '?'){
                    dp[i + 1][j + 1] = dp[i][j];
                }else if (charP[i] == '*'){
                    //可以选择匹配0个或者若干位字符
                    dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j];
                }
            }
        }
        return dp[lenP][lenS];
    }

    @Test
    public void test(){
        System.out.println(isMatch("abcbdk","*a*?k"));
    }
}
