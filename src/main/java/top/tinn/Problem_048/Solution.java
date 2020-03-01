package top.tinn.Problem_048;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Solution {
    public void rotate(int[][] matrix) {
        rotate(matrix,0);
    }

    private void rotate(int[][] matrix,int n){
        if(matrix.length/2==n) return;
        else{
            int[] temp= Arrays.copyOf(matrix[n],matrix.length);
            for(int j=matrix.length-1-n;j>=n;j--) matrix[n][j]=matrix[matrix.length-1-j][n];
            for(int i=n+1;i<matrix.length-n;i++) matrix[i][n]=matrix[matrix.length-1-n][i];
            for(int j=n+1;j<matrix.length-n-1;j++) matrix[matrix.length-1-n][j]=matrix[matrix.length-1-j][matrix.length-1-n];
            for(int i=n+1;i<matrix.length-n;i++) matrix[i][matrix.length-1-n]=temp[i];
            rotate(matrix,++n);
        }
    }

    @Test
    public void test(){
        int[][] matrix=new int[3][3];
        matrix[0]=new int[]{1,2,3};
        matrix[1]=new int[]{4,5,6};
        matrix[2]=new int[]{7,8,9};
        rotate(matrix);
    }
}

