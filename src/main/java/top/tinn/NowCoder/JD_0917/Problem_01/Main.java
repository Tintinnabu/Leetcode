package top.tinn.NowCoder.JD_0917.Problem_01;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: Tinn
 * @Date: 2020/9/17 19:23
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String str = scanner.nextLine();
        int i = 0;
        while (i < str.length()){
            while (i < str.length() && !Character.isDigit(str.charAt(i))){
                i++;
            }
            StringBuilder temp = new StringBuilder();
            while (i < str.length() && Character.isDigit(str.charAt(i))){
                temp.append(str.charAt(i));
                i++;
            }
            /*if (temp.length() >= 4){
                for (int start = 0; start <= temp.length() - 4; start++){
                    int year = Integer.parseInt(temp.substring(start, start + 4));
                    if (year >= 1000 && year <= 3999){
                        sb.append(year);
                        sb.append(" ");
                    }
                }
            }*/
            if (temp.length() == 4){
                int year = Integer.parseInt(temp.toString());
                if (year >= 1000 && year <= 3999){
                    sb.append(year);
                    sb.append(" ");
                }
            }
        }
        if (sb.length() > 0){
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println(sb.toString());
    }
}
