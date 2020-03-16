package top.tinn.DpProblem.Problem_343;

import org.junit.jupiter.api.Test;

/**
 * 343. 整数拆分
 *
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int integerBreak(int n) {
        int[] dp=new int[n+1];
        for (int i=1;i<=n;i++){
            int max=1;
            for (int j=1;j<i;j++){
                max=Math.max(max,dp[i-j]*j);
                max=Math.max(max,j*(i-j));
            }
            dp[i]=max;
        }
        return dp[n];
    }

    public int integerBreak2(int n) {
        if(n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if(b == 0) return (int)Math.pow(3, a);
        if(b == 1) return (int)Math.pow(3, a - 1) * 4;
        return (int)Math.pow(3, a) * 2;
    }


    @Test
    public void test(){
        System.out.println(integerBreak(20));
    }
}
