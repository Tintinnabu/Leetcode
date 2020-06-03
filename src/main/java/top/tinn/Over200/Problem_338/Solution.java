package top.tinn.Over200.Problem_338;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/6/1 22:25
 */
public class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
            ans[i] = ans[i >> 1] + (i & 1); // x / 2 is x >> 1 and x % 2 is x & 1
        return ans;
    }
}
