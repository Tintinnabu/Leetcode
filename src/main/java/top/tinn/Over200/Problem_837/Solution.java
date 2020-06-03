package top.tinn.Over200.Problem_837;

import org.junit.jupiter.api.Test;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/6/3 16:26
 */
public class Solution {
    public double new21Game(int N, int K, int W) {
        //能抽到的最大点数为 W + K - 1 初始为 0
        //设dp[x]为她手上牌面为x时，能获胜的概率
        double[] dp = new double[W + K];
        double sum = 0d;
        for (int i = K; i <dp.length ; i++){
            if (i <= N){
                dp[i] = 1;
            }
            sum += dp[i];
        }
        for (int i = K - 1; i >= 0; i--){
            dp[i] = sum / W;
            sum = sum - dp[i + W] + dp[i];
        }
        return dp[0];
    }

    @Test
    public void test(){
        System.out.println(new21Game(6,6,10));
    }
}
