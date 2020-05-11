package top.tinn.DailyProblem.Problem_983;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/6 16:22
 */
public class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length, maxDay = days[len - 1], minDay = days[0];
        int[] dp = new int[maxDay + 31];
        for (int d = maxDay, i = len - 1; d >= minDay; d--){
            if (d == days[i]){
                dp[d] = minPirce(dp[d + 1] + costs[0],
                        dp[d + 7] + costs[1],
                        dp[d + 30] + costs[2]);
                i--;
            }else dp[d] = dp[d + 1];
        }
        return dp[minDay];
    }

    private int minPirce(int a, int b, int c){
        return Math.min(Math.min(a, b), c);
    }

    @Test
    public void test(){
        int[] days = {1,2,3,4,6,8,9,10,13,14,16,17,19,21,24,26,27,28,29};
        int[] costs = {3,14,50};
        System.out.println(mincostTickets(days, costs));
    }
}
