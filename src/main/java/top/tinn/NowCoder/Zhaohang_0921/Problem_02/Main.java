package top.tinn.NowCoder.Zhaohang_0921.Problem_02;

import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/9/21 19:37
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int groups = scanner.nextInt();
        while (groups > 0){
            int len = scanner.nextInt();
            int[] array = new int[len];
            int i = 0;
            //initial
            int even = 0;
            while (i < len){
                int cur = scanner.nextInt();
                array[i++] = cur;
                if (cur % 2 == 0){
                    even++;
                }
            }
            //process
            if (even != len / 2){
                System.out.println(-1);
            }else {
                int count = 0;
                for (int j = 0; j < len; j += 2){
                    if (array[j] % 2 == 0){
                        count++;
                    }
                }
                System.out.println(count);
            }
            groups--;
        }
    }
}
