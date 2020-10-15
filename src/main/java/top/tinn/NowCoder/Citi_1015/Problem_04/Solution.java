package top.tinn.NowCoder.Citi_1015.Problem_04;

import org.junit.jupiter.api.Test;

/**
 * @Author: Tinn
 * @Date: 2020/10/15 15:56
 */
public class Solution {
    private String[] weeks = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
    public String solution(String S, int K) {
        // write your code in Java SE 8
        int start = 0;
        for (int i = 0; i < 7; i++){
            if (weeks[i].equals(S)){
                start = i;
            }
        }
        start = (start + (K % 7)) % 7;
        return weeks[start];
    }

    @Test
    public void test(){
        System.out.println(solution("Wed", 2));
        System.out.println(solution("Sat", 2));
    }
}
