package top.tinn.NowCoder.JD_0917.Problem_01;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @Author: Tinn
 * @Date: 2020/9/17 19:34
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String[] str = scanner.nextLine().split(" ");
        for (String s : str){
            if (s.length() == 4){
                if (s.matches("[1-3]\\d{3}")){
                    sb.append(s + " ");
                }
            }else if (s.length() == 5){
                if (s.charAt(4) == ',' || s.charAt(4) == '.'){
                    s = s.substring(0, 4);
                    if (s.matches("[1-3]\\d{3}")){
                        sb.append(s + " ");
                    }
                }
            }
        }
        if (sb.length() > 0){
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println(sb.toString());
    }
}
