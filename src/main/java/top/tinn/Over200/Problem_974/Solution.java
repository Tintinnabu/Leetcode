package top.tinn.Over200.Problem_974;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/27 7:58
 */
public class Solution {
    //同余法
    public int subarraysDivByK(int[] A, int K) {
        int[] record = new int[K];
        record[0] = 1;
        int sum = 0, ret = 0;
        for (int n : A){
            sum += n;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int mod = (sum % K + K) % K;
            ret += record[mod]++;
        }
        return ret;
    }

    @Test
    public void test(){
        System.out.println(-5 % 5);
        System.out.println(subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5));
    }
}
