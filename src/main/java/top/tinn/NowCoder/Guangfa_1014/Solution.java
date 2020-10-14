package top.tinn.NowCoder.Guangfa_1014;

import org.junit.jupiter.api.Test;

/**
 * @Author: Tinn
 * @Date: 2020/10/14 15:30
 */
public class Solution {
    public int getNumber (int n) {
        // write code here
        int p = 0;
        for (int i = 2; i <= n; i++){
            p = (p + 3) % i;
        }
        return p + 1;
    }

    @Test
    public void test(){
        System.out.println(getNumber(1));
        System.out.println(getNumber(2));
        System.out.println(getNumber(3));
        System.out.println(getNumber(4));
    }
}
