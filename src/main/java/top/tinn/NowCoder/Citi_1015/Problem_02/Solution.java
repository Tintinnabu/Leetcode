package top.tinn.NowCoder.Citi_1015.Problem_02;

/**
 * @Author: Tinn
 * @Date: 2020/10/17 18:51
 */
public class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        boolean pos = true;
        for (int n : A){
            if (n == 0) return 0;
            else if (n < 0) pos = !pos;
        }
        return pos ? 1 : -1;
    }
}
