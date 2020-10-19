package top.tinn.NowCoder.Dianxinyun_1015;

import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/10/15 18:42
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(",");
        int i = 0;
        while (i < str[0].length()){
            char c = str[0].charAt(i);
            for (int j = 1; j < str.length; j++){
                if (i >= str[j].length() || str[j].charAt(i) != c){
                    System.out.println(str[0].substring(0, i));
                    return;
                }
            }
            i++;
        }
        System.out.println(str[0].substring(0, i));
    }
}
