package top.tinn.Over200.Problem_892;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/9 16:55
 */
public class Solution {
    public int surfaceArea(int[][] grid) {
        int row = grid.length;
        if (row == 0) return 0;
        int col = grid[0].length;
        int up = 0;
        int left = 0, leftPre = 0, front = 0, frontPre = 0;
        for (int i = 0; i < row; i++){
            leftPre = 0;
            for (int j = 0; j < col; j++){
                if (grid[i][j] > 0){
                    up++;
                }
                left += Math.abs(grid[i][j] - leftPre);
                leftPre = grid[i][j];
                if (j == col - 1) left += leftPre;
            }
        }
        for (int i = 0; i < col; i++){
            frontPre = 0;
            for (int j = 0; j < row; j++){
                front += Math.abs(grid[j][i] - frontPre);
                frontPre = grid[j][i];
                if (j == row - 1) front += frontPre;
            }
        }
        return 2 * up + left + front;
    }

    public int surfaceArea2(int[][] grid) {
        int n = grid.length, area = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                int level = grid[i][j];
                if (level > 0){
                    area += (level << 2) + 2;
                    area -= i > 0 ? Math.min(level, grid[i - 1][j]) << 1 : 0;
                    area -= j > 0 ? Math.min(level, grid[i][j - 1]) << 1 : 0;
                }
            }
        }
        return area;
    }
}
