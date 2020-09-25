package top.tinn.NowCoder.Duxiaoman_0920.Problem_01;

import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/9/20 20:30
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.next();
        String B = scanner.next();
        int ans = 0;
        int[] count = new int[26];
        for (char c : A.toCharArray()){
            count[c - 'A']++;
        }
        for (char c : B.toCharArray()){
            if (count[c - 'A']-- > 0){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
