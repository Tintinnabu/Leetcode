package top.tinn.Over200.Problem_221;

public class Solution {
    public int maximalSquare(char[][] matrix) {

        if(matrix.length<1) return 0;
        int result=0;
        int[][]dp=new int[matrix.length+1][matrix[0].length+1];
        for(int i=1;i<=matrix.length;i++){
            for(int j=1;j<=matrix[0].length;j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                    result=Math.max(result,dp[i][j]);
                }
            }
        }
        return result*result;
    }
}
