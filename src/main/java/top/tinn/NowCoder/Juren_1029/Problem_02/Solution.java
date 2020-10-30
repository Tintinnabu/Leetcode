package top.tinn.NowCoder.Juren_1029.Problem_02;

import org.junit.jupiter.api.Test;

/**
 * @Author: Tinn
 * @Date: 2020/10/29 19:05
 */
public class Solution {
    public int[][] RotateMatrix (int[][] matrix) {
        // write code here
        int N = matrix.length;
        int[][] ans = new int[N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                ans[j][N - i - 1] = matrix[i][j];
            }
        }
        return ans;
    }
}
