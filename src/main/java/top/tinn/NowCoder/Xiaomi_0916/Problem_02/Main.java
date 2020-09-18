package top.tinn.NowCoder.Xiaomi_0916.Problem_02;

import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/9/15 19:33
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        boolean[] mark = new boolean[128];
        for (char c : str.toCharArray()){
            if (!mark[c]){
                sb.append(c);
                mark[c] = true;
            }
        }
        System.out.println(sb.toString());
    }
}
