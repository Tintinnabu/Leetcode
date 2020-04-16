package top.tinn.BitProblem.Problem_476;

import org.junit.jupiter.api.Test;

/**
 * @ClassName Solution
 * @Description
 * @Author Tinn
 * @Date 2020/4/15 17:17
 */
public class Solution {
    public int findComplement(int num) {
        /*int mask = 0;
        for (int i=0; i < 32; i++){
            mask |=(1<<i);
            if (mask>=num)
                break;
        }
        return (~num)&mask;*/
        int temp = num, c = 0;
        while (temp > 0){
            temp >>= 1;
            c = (c << 1) + 1;
        }
        return num ^ c;
    }
    @Test
    public void test(){
        System.out.println(findComplement(1));
    }
}
