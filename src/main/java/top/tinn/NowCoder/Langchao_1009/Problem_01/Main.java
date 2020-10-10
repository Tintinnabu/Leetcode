package top.tinn.NowCoder.Langchao_1009.Problem_01;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/10/9 20:33
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] stones = new int[n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int k = 0, j = 0, kk = 0, jj = n - 1;
        for (int i = 0; i < n; i++){
            stones[i] = scanner.nextInt();
            if (stones[i] < min){
                k = i;
                min = stones[i];
            }
            if (stones[i] > max){
                kk = i;
                max = stones[i];
            }

        }
        int[] sortedStones = stones.clone();
        Arrays.sort(sortedStones);
        //initial finished
        while (k < n && j < n){
            if (stones[k] == sortedStones[j]){
                j++;
            }
            k++;
        }
        while (kk >= 0 && jj >= 0){
            if (stones[kk] == sortedStones[jj]){
                jj--;
            }
            kk--;
        }
        int ans = Math.min(n - j, jj + 1);
        System.out.println(ans);
    }
}
