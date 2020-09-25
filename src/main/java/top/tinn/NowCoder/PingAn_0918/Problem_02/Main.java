package top.tinn.NowCoder.PingAn_0918.Problem_02;

import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/9/18 20:43
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        if (year <= 4){
            System.out.println(year);
            return;
        }
        int n = year + 1;
        int[] big = new int[n];
        int[] age0 = new int[n];
        int[] age1 = new int[n];
        int[] age2 = new int[n];
        for (int i = 1; i <= 4; i++){
            big[i] = 1;
            if (i >= 2){
                age0[i] = 1;
            }
            if (i >= 3){
                age1[i] = 1;
            }
            if (i >= 4){
                age2[i] = 1;
            }
        }
        for (int i = 5; i <= year; i++){
            big[i] = big[i - 1] + age2[i - 1];
            age2[i] = age1[i - 1];
            age1[i] = age0[i - 1];
            age0[i] = big[i];
        }
        int ans = big[year] + age0[year] + age1[year] + age2[year];
        System.out.println(ans);
    }
}
