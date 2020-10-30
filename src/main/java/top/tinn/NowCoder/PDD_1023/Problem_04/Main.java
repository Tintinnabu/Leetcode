package top.tinn.NowCoder.PDD_1023.Problem_04;

import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/10/23 19:49
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double[] prob = new double[n];
        prob[0] = 1;
        double ans = 1;
        for (int i = 1; i < m; i++){
            double[] newProb = new double[n];
            for (int index = 0; index < n; index++){
                if (index == 0){
                    newProb[index] += prob[index] * (1 - a);
                }else if (index == n - 1){
                    newProb[index] += prob[index] * Math.pow(1 - b, index);
                }else {
                    newProb[index] += prob[index] * ((1 - a) * Math.pow(1 - b, index) + a * b * index);
                }

                if (index != 0){
                    newProb[index] += prob[index - 1] * a * Math.pow(1 - b, index - 1);
                }
                for (int j = index + 1; j < n; j++){
                    if (j == n - 1){
                        newProb[index] += prob[j] * Math.pow(b, j - index) * cnm(j, j - index);
                    }else {
                        newProb[index] += prob[j] * (1 - a) * Math.pow(b, j - index) * cnm(j, j - index);
                        newProb[index] += prob[j] * a * Math.pow(b, j - index + 1) * cnm(j, j - index + 1);
                    }
                }
            }
            prob = newProb;
            ans += prob[0];
        }
        System.out.printf("%.8f", ans);
    }

    private static int cnm(int j, int i) {
        int temp = 1;
        while (j > 1){
            temp *= j;
            j--;
        }
        int temp2 = 1;
        while (i > 1){
            temp2 *= i;
            i--;
        }
        return temp / temp2;
    }
}
