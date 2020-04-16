package top.tinn.BitProblem.Problem_371;

import org.junit.jupiter.api.Test;

/**
 * @ClassName Solution
 * @Description
 * @Author Tinn
 * @Date 2020/4/15 15:38
 */
public class Solution {
    public int getSum(int a, int b) {
        int sum = a ^ b;
        int carry = (a & b) <<1;
        if (carry != 0){
            return getSum(sum, carry);
        }
        return sum;
    }

    @Test
    public void test(){
        System.out.println(getSum(1,3));
        System.out.println(getSum(-1,20));
    }
}
