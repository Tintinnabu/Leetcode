package oj;

import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/9/4 18:14
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int ans = 0;
        for (int i = 0; i < num; i++){
            ans += scanner.nextInt();
        }
        System.out.println(ans);
        num = scanner.nextInt();
        ans = 0;
        for (int i = 0; i < num; i++){
            ans += scanner.nextInt();
        }
        System.out.println(ans);

    }
}
