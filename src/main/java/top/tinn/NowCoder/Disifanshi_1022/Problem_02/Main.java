package top.tinn.NowCoder.Disifanshi_1022.Problem_02;
import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/10/22 19:16
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int groups = scanner.nextInt();
        int[] count = new int[100001];
        for (int i = 0; i < groups; i++){
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            count[start]++;
            count[end]--;
        }
        int ans = 0, cur = 0;
        for (int i = 1; i <= 100000; i++){
            cur += count[i];
            if (cur >= 4){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
