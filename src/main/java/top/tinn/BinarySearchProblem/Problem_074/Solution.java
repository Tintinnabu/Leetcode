package top.tinn.BinarySearchProblem.Problem_074;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0||matrix[0].length==0) return false;
        int i=matrix.length-1,j=0;
        while (0<=i&&i<matrix.length&&0<=j&&j<matrix[0].length){
            if (matrix[i][j]==target) return true;
            else if (matrix[i][j]>target) i--;
            else j++;
        }
        return false;
    }
}
