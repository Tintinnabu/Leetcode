package top.tinn.Top200.Problem_190;

import org.junit.jupiter.api.Test;

/**
 * @ClassName Solution
 * @Description
 * @Author Tinn
 * @Date 2020/4/18 19:50
 */
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++){
            int temp = n & 1;
            n >>= 1;
            ret = (ret<<1) + temp;
        }
        return ret;
    }

    public int reverseBits2(int n) {
        n = ((n & 0xffff0000) >>>16) | ((n & 0x0000ffff) << 16);
        n = ((n & 0xff00ff00) >>>8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>>4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>>2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>>1) | ((n & 0x55555555) << 1);
        return n;
    }

    @Test
    public void test(){
        System.out.println(reverseBits2(-3));
    }
}
