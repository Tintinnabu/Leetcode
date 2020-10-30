package top.tinn.NowCoder.Juren_1029.Problem_01;

import org.junit.jupiter.api.Test;

/**
 * @Author: Tinn
 * @Date: 2020/10/29 19:07
 */
public class Solution {
    public int ConvertData (int originData) {
        // write code here
        int temp = originData;
        temp |= (temp >> 1);
        temp |= (temp >> 2);
        temp |= (temp >> 4);
        temp |= (temp >> 8);
        temp |= (temp >> 16);
        return temp - originData;
    }

    @Test
    public void test(){
        System.out.println(ConvertData(2));
        System.out.println(ConvertData(5));
    }
}
