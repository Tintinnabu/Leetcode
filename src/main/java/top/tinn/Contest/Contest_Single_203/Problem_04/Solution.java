package top.tinn.Contest.Contest_Single_203.Problem_04;

import org.junit.jupiter.api.Test;

/**
 * @Author: Tinn
 * @Date: 2020/8/23 11:37
 */
public class Solution {
    public int stoneGameV(int[] stoneValue) {
        if (stoneValue.length == 1){
            return 0;
        }
        return helper(stoneValue, 0, stoneValue.length - 1);
    }

    private int helper(int[] stoneValue, int start, int end) {
        if (start >=  end){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end; i++){
            int left = count(stoneValue, start, i);
            int right = count(stoneValue, i + 1, end);
            int temp;
            if (left < right){
                temp = left + helper(stoneValue, start, i);
            }else if (left > right){
                temp = right + helper(stoneValue, i + 1, end);
            }else{
                temp = left + Math.max(helper(stoneValue, start, i),
                        helper(stoneValue, i + 1, end));
            }
            max = Math.max(temp, max);
        }
        return max;
    }

    private int count(int[] stoneValue, int start, int end) {
        int ans = 0;
        for (int i = start; i <= end; i++){
            ans += stoneValue[i];
        }
        return ans;
    }

    /**
     * 使用前缀和缩小计算量
     * @param stoneValue
     * @return
     */
    public int stoneGameV2(int[] stoneValue) {
        int n = stoneValue.length;
        int[][] dp = new int[n + 1][n + 1];
        int[] sum = new int[n + 1];
        sum[1] = stoneValue[0];
        for (int i = 2; i <= n; i++){
            sum[i] = sum[i - 1] + stoneValue[i - 1];
        }
        for (int distance = 1; distance <= n; distance++){
            for (int i = 1; i <= n - distance; i++){
                int j = i + distance;
                int temp;
                int max = Integer.MIN_VALUE;
                for (int k = i; k < j; k++) {
                    int left = sum[k] - sum[i - 1];
                    int right = sum[j] - sum[k];
                    if (left < right) {
                        temp = left + dp[i][k];
                    } else if (left > right) {
                        temp = right + dp[k + 1][j];
                    } else {
                        temp = left + Math.max(dp[i][k], dp[k + 1][j]);
                    }
                    max = Math.max(temp, max);
                }
                dp[i][j] = max;
            }
        }
        return dp[1][n];
    }

    @Test
    public void test(){
        int[] stoneValue = {6,2,3,4,5,5};
        System.out.println(stoneGameV2(stoneValue));
        stoneValue = new int[]{7,7,7,7,7,7,7};
        System.out.println(stoneGameV2(stoneValue));
        System.out.println(stoneGameV2(new int[]{4}));
    }
}
