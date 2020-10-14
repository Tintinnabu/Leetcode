package top.tinn.NowCoder.Qunaer_1014.Problem_01;

import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/10/14 19:12
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        long[][] dp = new long[m + 1][n + 1];
        for (int j = 0; j <= n; j++){
            for (int i = j; i <= m; i++){
                if (j == 0){
                    dp[i][j] = 1;
                }else if (i == j){
                    dp[i][j] = 1;
                }else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}
