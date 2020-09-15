package top.tinn.NowCoder.Vivo_0912.Problem_02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/9/12 20:04
 */
public class Main {
    static int deleteIndex = -1;
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String str = scanner.nextLine();
        int len =str.length();
        int cut = 1;
        if (len % 2 == 0){
            if (isPaladine(str, len / 2 - 1, len / 2)){
                System.out.println(str);
            }else if (helper2(str, len / 2, len / 2, cut)){
                String newStr = str.substring(0, deleteIndex) + str.substring(deleteIndex + 1);
                System.out.println(newStr);
            }else if (helper1(str, len / 2 - 1, len / 2 - 1, cut)){
                String newStr = str.substring(0, deleteIndex) + str.substring(deleteIndex + 1);
                System.out.println(newStr);
            }else {
                System.out.println(false);
            }
        }else {
            if (isPaladine(str, len / 2, len / 2)){
                System.out.println(str);
            }else if (helper2(str, len / 2, len / 2 + 1, cut)){
                String newStr = str.substring(0, deleteIndex) + str.substring(deleteIndex + 1);
                System.out.println(newStr);
            }else if (helper1(str, len / 2 - 1, len / 2, cut)){
                String newStr = str.substring(0, deleteIndex) + str.substring(deleteIndex + 1);
                System.out.println(newStr);
            }else {
                System.out.println(false);
            }
        }
    }

    private static boolean isPaladine(String str, int i, int j) {
        while (i >= 0 && j < str.length() && str.charAt(i) == str.charAt(j)){
            i--;
            j++;
        }
        return i == -1 && j == str.length();
    }

    private static boolean helper1(String str, int i, int j, int cut) {
        while (i >= 0 && j < str.length() && cut >= 0){
            while (i >= 0 && j < str.length() && str.charAt(i) == str.charAt(j)){
                i--;
                j++;
            }
            if (cut > 0){
                deleteIndex = j;
                j++;
                cut--;
            }else {
                if (i >= 0){
                    return false;
                }
            }
        }
        return i == -1 && j == str.length();
    }

    private static boolean helper2(String str, int i, int j, int cut) {
        while (i >= 0 && j < str.length() && cut >= 0){
            while (i >= 0 && j < str.length() && str.charAt(i) == str.charAt(j)){
                i--;
                j++;
            }
            if (cut > 0){
                deleteIndex = i;
                i--;
                cut--;
            }else {
                if (i >= 0){
                    return false;
                }
            }
        }
        return i == -1 && j == str.length();
    }
}
