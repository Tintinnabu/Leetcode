package top.tinn.DpProblem.Problem_062;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/27 17:06
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        int[] cur = new int[m];
        Arrays.fill(cur, 1);
        for (int i = 1; i < n; i++){
            for (int j = 1; j < m; j++){
                cur[j] += cur[j - 1];
            }
        }
        return cur[m - 1];
    }
}
