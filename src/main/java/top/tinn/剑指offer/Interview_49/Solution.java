package top.tinn.剑指offer.Interview_49;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/2 13:27
 */
public class Solution {
    private int[] ret = new int[1690];
    {
        int m1 = 0, m2 = 0, m3 = 0;
        int n2, n3, n5;
        ret[0] = 1;
        for (int i = 1; i < 1690; i++){
            n2 = ret[m1] * 2;
            n3 = ret[m2] * 3;
            n5 = ret[m3] * 5;
            ret[i] = Math.min(Math.min(n2, n3), n5);
            if (ret[i] == n2) m1++;
            if (ret[i] == n3) m2++;
            if (ret[i] == n5) m3++;
        }
    }

    public int nthUglyNumber(int n) {
        return ret[n - 1];
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.ret));
    }
}
