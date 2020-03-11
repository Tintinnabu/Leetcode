package top.tinn.BacktrackProblem.Problem_052;

import org.junit.jupiter.api.Test;

public class Solution {
    private boolean[] column;
    private boolean[] diag1;
    private boolean[] diag2;
    private int count;
    public int totalNQueens(int n) {
        column=new boolean[n];
        diag1=new boolean[2*n-1];
        diag2=new boolean[2*n-1];
        count=0;
        backtrack(0,n);
        return count;
    }

    private void backtrack(int i, int n){
        if (i==n){
            count++;
        }
        for (int j=0;j<n;j++){
            if (!column[j]&&isSafe(i,j,n)){
                column[j]=true;
                diag1[i-j+n-1]=true;
                diag2[i+j]=true;
                backtrack(i+1,n);
                diag1[(i-j+n-1)]=false;
                diag2[i+j]=false;
                column[j]=false;
            }
        }
    }

    private boolean isSafe(int i,int j,int n) {
        if (i==0) return true;
        return !diag1[i - j + n - 1]  && !diag2[i + j];
    }

    @Test
    public void test(){
        System.out.println(totalNQueens(8));
    }
}
