package top.tinn.InterviewProblem.面试题01_07;

import org.junit.jupiter.api.Test;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/11 19:34
 */
public class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverseRow(matrix);
    }

    private void reverseRow(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int j = 0, k = matrix[0].length - 1;
            while (j < k) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
                j++;k--;
            }
        }
    }

    private void transpose(int[][] matrix){
        int len = matrix.length;
        for (int start = 0; start < len; start++){
            for (int distance = 0; distance + start < len; distance++){
                int temp = matrix[start][start + distance];
                matrix[start][start + distance] = matrix[start + distance][start];
                matrix[start + distance][start] = temp;
            }
        }
    }


    @Test
    public void test(){
        int[][] matrix = new int[2][2];
        matrix[0] = new int[]{1,2};
        matrix[1] = new int[]{3,4};
        rotate(matrix);
    }
}
