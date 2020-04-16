package top.tinn.BitProblem.Problem_342;

/**
 * @ClassName Solution
 * @Description
 * @Author Tinn
 * @Date 2020/4/15 15:43
 */
public class Solution {
    public boolean isPowerOfFour(int num) {
        if (num < 0 || (num&(num-1))>0)
            return false;
        return num % 3 == 1;
    }
}
