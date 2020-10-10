package top.tinn.NowCoder.Langchao_1009.Problem_02;

import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/10/9 21:25
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean[] mark = new boolean[103];
        for (int i = 0; i < n; i++){
            mark[scanner.nextInt()] = true;
        }
        int i = 1;
        int oddStart = 1;
        int oddLen = 0;
        while (i <= 99){
            while (i <= 99&&mark[i]){
                i += 2;
            }
            int count = 0;
            while (i <= 99&&!mark[i]){
                count++;
                i += 2;
            }
            if (count > oddLen){
                oddLen = count;
                oddStart = i - count * 2;
            }
        }
        int j = 2;
        int evenStart = 2;
        int evenLen = 0;
        while (j <= 100){
            while (j <= 100 && mark[j]){
                j += 2;
            }
            int count = 0;
            while (j <= 100 && !mark[j]){
                count++;
                j+=2;
            }
            if (count > evenLen){
                evenLen = count;
                evenStart = j - count * 2;
            }
        }
        if (oddLen == evenLen){
            if (oddStart < evenStart){
                System.out.printf("%d %d", oddStart, oddLen);
            }else {
                System.out.printf("%d %d", evenStart, evenLen);
            }
        }else if (oddLen > evenLen){
            System.out.printf("%d %d", oddStart, oddLen);
        }else {
            System.out.printf("%d %d", evenStart, evenLen);
        }
    }
}
