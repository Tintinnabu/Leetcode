package top.tinn.BitProblem.Problem_231;

/**
 * @ClassName Solution
 * @Description
 * @Author Tinn
 * @Date 2020/4/15 17:38
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n > 0 && (n & (n - 1)) == 0 )
            return true;
        return false;
    }
}
