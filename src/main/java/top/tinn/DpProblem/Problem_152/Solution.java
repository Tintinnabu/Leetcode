package top.tinn.DpProblem.Problem_152;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/28 22:21
 */
public class Solution {
    public int maxProduct(int[] nums) {
        int ret = Integer.MIN_VALUE, min = 1, max = 1;
        for (int n : nums){
            if (n < 0){
                int temp = min;
                min = max;
                max = temp;
            }
            min = Math.min(n, n * min);
            max = Math.max(n, n * max);
            ret = Math.max(max, min);
        }
        return ret;
    }
}
