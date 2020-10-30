package top.tinn.NowCoder.PDD_1023.Problem_01;

import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/10/23 19:01
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < N; i++){
            int cur = scanner.nextInt();
            min = Math.min(min, cur);
            max = Math.max(max, cur);
        }
        if (max - min <= M){
            System.out.printf("%d %d", min, max);
        }else if (max - min <= 2 * M){
            int a = min + M;
            int b = max - M;
            System.out.printf("%d %d", b, a);
        }else {
            System.out.println(-1);
        }
    }
}
