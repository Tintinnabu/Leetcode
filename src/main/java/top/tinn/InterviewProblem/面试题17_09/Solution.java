package top.tinn.InterviewProblem.面试题17_09;

public class Solution {
    public int getKthMagicNumber(int k) {
        int[] dp = new int[k];
        dp[0] = 1;
        int p3 = 0, p5 = 0, p7 = 0;
        for (int i = 1; i < k; i++){
            int min = Math.min(Math.min(dp[p3] * 3, dp[p5] * 5), dp[p7] * 7);
            dp[i] = min;
            if (min % 3 == 0) p3++;
            if (min % 5 == 0) p5++;
            if (min % 7 == 0) p7++;
        }
        return dp[k - 1];
    }
}
