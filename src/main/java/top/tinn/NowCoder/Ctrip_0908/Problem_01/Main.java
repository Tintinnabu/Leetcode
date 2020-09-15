package top.tinn.NowCoder.Ctrip_0908.Problem_01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/9/8 19:14
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String targetWord = scanner.nextLine();
        String sentence = scanner.nextLine();
        String replacedWord = scanner.nextLine();
        Map<Character, Integer> map = new HashMap<>();
        int[] mark = new int[128];
        for (char c : targetWord.toCharArray()){
            mark[c]++;
        }
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (j < sentence.length()){
            while (j < sentence.length() && Character.isLetter(sentence.charAt(j))){
                j++;
            }
            String curWord = sentence.substring(i, j);
            if (curWord.length() == targetWord.length() && isMatched(curWord, mark.clone())){
                sb.append(replacedWord);
            }else {
                sb.append(curWord);
            }
            while (j < sentence.length() && !Character.isLetter(sentence.charAt(j))){
                sb.append(sentence.charAt(j));
                j++;
            }
            i = j;
        }
        System.out.println(sb.toString());
    }

    private static boolean isMatched(String curWord, int[] mark) {
        for (char c : curWord.toCharArray()){
            if (--mark[c] < 0){
                return false;
            }
        }
        return true;
    }
}
