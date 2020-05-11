package top.tinn.剑指offer.Interview_04;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/4/30 10:03
 */
public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = matrix.length;
        if ( row == 0) return false;
        int column = matrix[0].length;
        int i = row - 1, j = 0;
        while (i >=0 && j < column){
            int curr = matrix[i][j];
            if (curr > target) i--;
            else if (curr < target) j++;
            else return true;
        }
        return false;
    }
}
