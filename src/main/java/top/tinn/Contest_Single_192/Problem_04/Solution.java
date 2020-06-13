package top.tinn.Contest_Single_192.Problem_04;

import java.util.Arrays;

/**
 * @author Tintinnabu
 * @description
 * @data 2020/6/7
 */
public class Solution {
    int inf = (int)1e9;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp = new int[m + 1][n + 1][target + 1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                Arrays.fill(dp[i][j], inf);
            }
        }
        dp[0][0][0] = 0;

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 0; k <= target; k++){
                    if(houses[i - 1] != 0 && houses[i - 1] != j){
                        continue;
                    }
                    int c = cost[i - 1][j - 1];
                    if(houses[i - 1] != 0){
                        c = 0;
                    }
                    //same
                    dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][k] + c);
                    for(int t = 0; t <= n && k > 0; t++){
                        if(t == j){
                            continue;
                        }
                        dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][t][k - 1] + c);
                    }
                }
            }
        }

        int ans = inf;
        for(int i = 1; i <= n; i++){
            ans = Math.min(ans, dp[m][i][target]);
        }

        //System.out.println(Arrays.deepToString(dp));
        if(ans >= inf){
            return -1;
        }
        return ans;
    }
}
