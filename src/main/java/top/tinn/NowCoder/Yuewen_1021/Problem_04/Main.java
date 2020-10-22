package top.tinn.NowCoder.Yuewen_1021.Problem_04;

import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/10/21 19:30
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Integer.MAX_VALUE);
        int num = scanner.nextInt();
        if (num < 4){
            System.out.println(true);
        }else if (num % 2 == 0) {
            System.out.println(false);
        }else {
            for (int i = 3; i <= Math.sqrt(num); i++){
                if (num % i == 0){
                    System.out.println(false);
                }
            }
            System.out.println(true);
        }
    }
}
