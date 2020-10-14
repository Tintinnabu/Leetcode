package top.tinn.NowCoder.Qunaer_1014.Problem_02;

import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/10/14 19:26
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] a = scanner.nextLine().split(" ");
        String[] b = scanner.nextLine().split(" ");
        int[][] dp = new int[n + 1][n + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                if (b[i - 1].equals(a[j - 1])){
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i][j - 1]);
                }else {
                    dp[i][j] = dp[i][j - 1];
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        System.out.println(ans);
    }
}
