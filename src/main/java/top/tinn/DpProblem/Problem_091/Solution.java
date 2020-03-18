package top.tinn.DpProblem.Problem_091;

import org.junit.jupiter.api.Test;

/**
 * 91. 解码方法
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    //用一个 dp 数组， dp [ i ] 代表字符串 s [ i, s.len-1 ]，也就是 s 从 i 开始到结尾的字符串的解码方式。
    public int numDecodings(String s) {
        int[] dp=new int[s.length()+1];
        int len=s.length();
        dp[len]=1;
        if (s.charAt(len-1)!='0')dp[len-1]=1;
        for (int i=len-2;i>=0;i--){
            if (s.charAt(i)=='0') continue;
            int ans1=dp[i+1];
            int ans2=0;
            if (s.charAt(i)<'2'||(s.charAt(i)<'3'&&s.charAt(i+1)<'7'))
                ans2=dp[i+2];
            dp[i]=ans1+ans2;
        }
        return dp[0];
    }

    @Test
    public void test(){
        System.out.println(numDecodings("226"));
    }

}
