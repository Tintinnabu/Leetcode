package top.tinn.NowCoder.Citi_1015.Problem_05;

import org.junit.jupiter.api.Test;

/**
 * @Author: Tinn
 * @Date: 2020/10/15 16:01
 */
public class Solution {
    private String plus = "plus";
    private String minus = "minus";
    public String solution(String S) {
        // write your code in Java SE 8
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < S.length()){
            if (S.charAt(i) == 'p'){
                int j = 0;
                int k = i;
                while (k < S.length() && j < plus.length() &&
                S.charAt(k) == plus.charAt(j)){
                    j++;
                    k++;
                }
                if (j == plus.length()){
                    sb.append("+");
                    i = k;
                    continue;
                }
            }else if (S.charAt(i) == 'm'){
                int j = 0;
                int k = i;
                while (k < S.length() && j < minus.length() &&
                        S.charAt(k) == minus.charAt(j)){
                    j++;
                    k++;
                }
                if (j == minus.length()){
                    sb.append("-");
                    i = k;
                    continue;
                }
            }
            sb.append(S.charAt(i++));
        }
        return sb.toString();
    }

    @Test
    public void test(){
        System.out.println(solution("minusplusminus"));
        System.out.println(solution("minuplusminusplusminusm"));
    }
}
