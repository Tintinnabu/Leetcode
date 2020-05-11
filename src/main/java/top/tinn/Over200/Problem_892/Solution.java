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
                if (grid[i][j] >= leftPre) leftPre = grid[i][j];
                else {
                    left += leftPre;
                    leftPre = grid[i][j];
                }
            }
            left += leftPre;
        }
        for (int i = 0; i < col; i++){
            frontPre = 0;
            for (int j = 0; j < row; j++){
                if (grid[j][i] >= frontPre) frontPre = grid[j][i];
                else {
                    front += frontPre;
                    frontPre = grid[j][i];
                }
            }
            front += frontPre;
        }
        return 2 * (up + left + front);
    }
}
