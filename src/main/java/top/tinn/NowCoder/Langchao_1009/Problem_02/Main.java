package top.tinn.NowCoder.Langchao_1009.Problem_02;

import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/10/9 21:01
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int curOdd = -1;
        int curEven = 0;
        int evenStart = 0;
        int oddStart = -1;
        int oddLen = 0;
        int evenLen = 0;
        for (int i = 0; i <= n; i++){
            if (i == n){
                int temp = ((100 - curEven) >> 1);
                if (temp > evenLen){
                    evenLen = temp;
                    evenStart = curEven;
                }
                temp = ((99 - curOdd) >> 1);
                if (temp > oddLen){
                    oddLen = temp;
                    oddStart = curOdd;
                }
                break;
            }
            int num = scanner.nextInt();
            //even
            if (num % 2 == 0){
                int temp = ((num - curEven) >> 1) - 1;
                if (temp > evenLen){
                    evenLen = temp;
                    evenStart = curEven;
                }
                curEven = num;
            }else {
                int temp = ((num - curOdd) >> 1) - 1;
                if (temp > oddLen){
                    oddLen = temp;
                    oddStart = curOdd;
                }
                curOdd = num;
            }
        }
        if (evenLen == oddLen){
            if (evenStart < oddStart){
                System.out.printf("%d %d", evenStart + 2, evenLen);
            }else {
                System.out.printf("%d %d", oddStart + 2, evenLen);
            }
        }else if (evenLen < oddLen){
            System.out.printf("%d %d", oddStart + 2, oddLen);
        }else {
            System.out.printf("%d %d", evenStart + 2, evenLen);
        }
    }
}
