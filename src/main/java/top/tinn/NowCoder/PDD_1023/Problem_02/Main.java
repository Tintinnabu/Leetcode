package top.tinn.NowCoder.PDD_1023.Problem_02;

import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/10/23 19:09
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int[] count = new int[128];
        for (char c : str.toCharArray()){
            count[c]++;
        }
        int i = 0, j = str.length() - 1;
        while (j >= i && count[str.charAt(j)] > 1){
            count[str.charAt(j)]--;
            j--;
        }
        int end = j;
        int start = 0;
        char pre = 'z' + 1;
        while (i <= j && count[str.charAt(i)] > 1){
            if (str.charAt(i) < pre){
                pre = str.charAt(i);
                start = i;
            }
            count[str.charAt(i)]--;
            i++;
        }
        System.out.printf("%d %d", start, end - start + 1);
    }
}
