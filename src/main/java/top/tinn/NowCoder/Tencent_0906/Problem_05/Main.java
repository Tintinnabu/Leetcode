package top.tinn.NowCoder.Tencent_0906.Problem_05;

import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/9/6 21:13
 */
public class Main {
    private static int ans = 0;
    public static void main(String[] args) {
        ans = 0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String color = scanner.next();
        Chess[] seq = new Chess[n * 2];
        for (int i = 0; i < n * 2; i++){
            Chess cur = new Chess(color.charAt(i), scanner.nextInt());
            seq[i] = cur;
        }
        helper(seq, n);
        System.out.println(ans);
    }

    private static void helper(Chess[] seq, int n) {
        if (n == 1){
            return;
        }
        int Bstart = -1, Bend = -1;
        for (int i = 0; i < seq.length; i++){
            if (seq[i].color == 'B' && seq[i].val == n){
                Bstart = i;
            }else if (Bstart != -1 && seq[i].color == 'B' && seq[i].val < n){
                Bend = i;
            }
        }
        for (int i = Bstart; i < Bend; i++){
            swap(seq, i, i + 1);
            ans++;
        }
        int Rstart = -1, Rend = -1;
        for (int i = 0; i < seq.length; i++){
            if (seq[i].color == 'R' && seq[i].val == n){
                Rstart = i;
            }else if (Rstart != -1 && seq[i].color == 'R' && seq[i].val < n){
                Rend = i;
            }
        }
        for (int i = Rstart; i < Rend; i++){
            swap(seq, i, i + 1);
            ans++;
        }

        helper(seq, n - 1);
    }

    private static void swap(Chess[] seq, int i, int j) {
        Chess temp = seq[i];
        seq[i] = seq[j];
        seq[j] = temp;
    }

    static class Chess{
        char color;
        int val;

        public Chess(char color, int val) {
            this.color = color;
            this.val = val;
        }
    }
}
