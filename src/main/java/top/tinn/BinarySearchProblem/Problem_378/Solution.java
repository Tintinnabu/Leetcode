package top.tinn.BinarySearchProblem.Problem_378;

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int row=matrix.length,col=matrix[0].length;
        int l=matrix[0][0],r=matrix[row-1][col-1];
        while (l<r){
            int mid=l+(r-l)/2;
            int count=0;
            int i=row-1,j=0;
            while (i>=0&&j<col){
                if (matrix[i][j]<=mid){
                    count+=i+1;
                    j++;
                }else i--;
            }
            if (count<k) l=mid+1;
            else r=mid;
        }
        return l;
    }
}
