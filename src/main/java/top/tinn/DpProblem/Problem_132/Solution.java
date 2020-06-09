package top.tinn.DpProblem.Problem_132;

import org.junit.jupiter.api.Test;

/**
 * 132. 分割回文串 II
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回符合要求的最少分割次数。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出: 1
 * 解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int minCut(String s) {
        int len=s.length();
        if (len<2) return 0;
        int[] dp=new int[len];
        for (int i=0;i<len;i++) dp[i]=i;

        boolean[][] palindrome=new boolean[len][len];
        for (int i=len-1;i>=0;i--){
            for (int j=i;j<len;j++){
                if (s.charAt(i)==s.charAt(j)&&(j-i<=2||palindrome[i+1][j-1])) palindrome[i][j]=true;
            }
        }

        for (int i=0;i<len;i++){
            if (palindrome[0][i]){
                dp[i]=0;
                continue;
            }
            for (int j=0;j<i;j++){
                if (palindrome[j+1][i])
                    dp[i]=Math.min(dp[i],dp[j]+1);
            }
        }
        return dp[len-1];
    }


    @Test
    public void test(){
        System.out.println(minCut("aabccb"));
    }
}
