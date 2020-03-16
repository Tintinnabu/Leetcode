package top.tinn.DpProblem.Problem_264;

import org.junit.jupiter.api.Test;

public class Solution {

    private static int[] ugly;
    static {
        ugly=new int[1690];
        ugly[0]=1;
        int p2=0,p3=0,p5=0;
        for (int i=1;i<1690;i++){
            int uglyNumber=Math.min(Math.min(ugly[p2]*2,ugly[p3]*3),ugly[p5]*5);
            ugly[i]=uglyNumber;
            if (uglyNumber==ugly[p2]*2) p2++;
            if (uglyNumber==ugly[p3]*3) p3++;
            if (uglyNumber==ugly[p5]*5) p5++;
        }
    }

    
    public int nthUglyNumber(int n) {
        return ugly[n-1];
    }

    @Test
    public void test(){
        System.out.println(nthUglyNumber(10));
    }
}
