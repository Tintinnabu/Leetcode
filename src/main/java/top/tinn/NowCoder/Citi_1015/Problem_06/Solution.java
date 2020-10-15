package top.tinn.NowCoder.Citi_1015.Problem_06;

import java.util.Arrays;

/**
 * @Author: Tinn
 * @Date: 2020/10/15 16:10
 */
public class Solution {
    public String solution(int N) {
        // write your code in Java SE 8
        StringBuilder sb = new StringBuilder();
        char[] str = new char[N];
        Arrays.fill(str, 'a');
        if (N % 2 != 0){
            return new String(str);
        }
        str[N - 1] = 'b';
        return new String(str);
    }
}
