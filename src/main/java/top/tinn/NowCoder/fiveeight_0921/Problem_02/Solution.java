package top.tinn.NowCoder.fiveeight_0921.Problem_02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Author: Tinn
 * @Date: 2020/9/21 20:21
 */
public class Solution {
    /**
     *
     * @param num int整型 非负整数 num
     * @return int整型一维数组
     */
    public int[] countBits (int num) {
        // write code here
        int[] ans = new int[num + 1];
        int k = 1;
        for (int i = 1; i <= num; i++){
            if (i == k * 2){
                k <<= 1;
            }
            ans[i] = 1 + ans[i - k];
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(countBits(10)));
    }

}
