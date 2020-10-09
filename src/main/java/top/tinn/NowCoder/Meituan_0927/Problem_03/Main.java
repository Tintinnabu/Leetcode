package top.tinn.NowCoder.Meituan_0927.Problem_03;

import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/9/27 10:21
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String str = scanner.nextLine();
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++){
            if (i == 0){
                dp[0] = str.charAt(0) == 'E' ? 1 : -1;
            }else {
                dp[i] = str.charAt(i) == 'E' ? 1 : -1;
                dp[i] = dp[i - 1] < 0 ? dp[i] : dp[i] + dp[i - 1];
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
