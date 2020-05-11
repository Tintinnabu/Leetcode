package top.tinn.剑指offer.Interview_60;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/7 11:19
 */
public class Solution {
    public double[] twoSum(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];
        for (int i = 1; i <= 6; i++)
            dp[1][i] = 1;
        for (int k = 2; k <= n; k++){
            for (int i = k; i <= 6 * k; i++){
                for (int j = 1; j <= 6; j++){
                    if (i - j < 1) break;
                    dp[k][i] += dp[k - 1][i - j];
                }
            }
        }
        double all = Math.pow(6, n);
        double[] ret = new double[5 * n + 1];
        for (int i = n; i <= 6 * n; i++){
            ret[i - n] = dp[n][i] / all;
        }
        return ret;
    }

    @Test
    public void test(){
        for (int i = 1; i <= 10; i++)
            System.out.println(Arrays.toString(twoSum(i)));
    }
}
