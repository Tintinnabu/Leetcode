package top.tinn.NowCoder.PingAn_0918.Problem_01;

import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/9/18 20:33
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        double fenzi = max3(a + b, b, c);
        int fenmu = max3(a, b + c, c) + max3(a, b, b + c);
        if (fenmu == 0){
            System.out.println("ERROR");
        }else{
            double m = fenzi / fenmu;
            //m = 0.054;
            double ret = (int)(m * 100 + 0.5) / 100d;
            System.out.println(ret);
        }
    }

    public static int max3(int a, int b, int c){
        return Math.max(Math.max(a, b), c);
    }
}
