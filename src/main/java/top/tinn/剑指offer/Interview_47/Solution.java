package top.tinn.剑指offer.Interview_47;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/2 12:56
 */
public class Solution {
    public int maxValue(int[][] grid) {
        int row = grid.length;
        if (row == 0) return 0;
        int column = grid[0].length;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                if (i == 0 && j == 0) continue;
                else if (i == 0) grid[i][j] += grid[i][j - 1];
                else if (j == 0) grid[i][j] += grid[i - 1][j];
                else grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[row - 1][column - 1];
    }
}
