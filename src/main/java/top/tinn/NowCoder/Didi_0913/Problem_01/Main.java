package top.tinn.NowCoder.Didi_0913.Problem_01;

import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/9/13 19:28
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = Integer.parseInt(scanner.nextLine());
        String encryption = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        int i = 0, j = len;
        while(j < encryption.length()){
            for (int k = j - 1; k >= i; k--){
                sb.append(encryption.charAt(k));
            }
            i = j;
            j += len;
        }
        for (int k = encryption.length() - 1; k >= i; k--){
            sb.append(encryption.charAt(k));
        }
        System.out.println(sb.toString());
    }
}
