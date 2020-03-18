package top.tinn.DpProblem.Problem_413;

import org.junit.jupiter.api.Test;

public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int sum=0;
        int dp=0;
        for (int i=2;i<A.length;i++){
            if (A[i]-A[i-1]==A[i-1]-A[i-2]){
                dp=dp+1;
                sum+=dp;
            }else dp=0;
        }
        return sum;
    }

    @Test
    public void test(){
        System.out.println(numberOfArithmeticSlices(new int[]{1,2,3,4}));
    }
}
