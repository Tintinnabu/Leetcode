package top.tinn.Contest.Contest_Double_27.Problem_04;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/31 8:11
 */
public class Solution {
    private int[] move = {1, 0, -1};

    /**
     * 1.看题 发现 这个机器人 只会往下走... 这就有意思了.
     * 2.设dp[n][j1][j2] 表示 当前为 第n 层, 也就是 第一个机器人 在 (n,j1) , 第二个机器人 在 (n,j2) 的位置 的最大收益
     * 3.这个收益 来源于 2个部分, 一个是之前的收益 , 一个是当前位置的收益
     * 4.首先当前位置的收益 是 grid[n][j1] + grid[n][j2] 如果 j1 == j2 就再减掉一份就可以了
     * 5.还有一部分 就是 之前的收益... 前一个状态 是 dp[n-1][j1][j2] (j1,j2在能够达到的位置..)这里有点模糊... 可以想一想..
     * 然后剩下的就看代码吧- -...
     *
     * @param grid
     * @return
     */
    public int cherryPickup(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][][] dp = new int[row][col][col];
        dp[0][0][col - 1] = grid[0][0] + grid[0][col - 1];

        for (int i = 1; i < row; i++){
            int limit = Math.min(i, col - 1);
            for (int j = 0; j <= limit; j++){
                for (int jj = col - limit - 1; jj < col; jj++){
                    int max = 0;
                    for (int k : move){
                        int j1 = j + k;
                        if (j1 >= 0 && j1 < col){
                            for (int kk : move){
                                int j2 = jj + kk;
                                if (j2 >= 0 && j2 < col){
                                    max = Math.max(dp[i - 1][j1][j2], max);
                                }
                            }
                        }
                    }
                    dp[i][j][jj] = max + grid[i][j] + grid[i][jj];
                    if (j == jj){
                        dp[i][j][jj] -= grid[i][j];
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < col; j++) {
                max = Math.max(dp[row - 1][i][j], max);
            }
        }
        return max;
    }
}
