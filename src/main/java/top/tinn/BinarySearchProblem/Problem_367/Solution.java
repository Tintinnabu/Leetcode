package top.tinn.BinarySearchProblem.Problem_367;

import org.junit.jupiter.api.Test;

public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num<2) return true;
        long l=0,r=num/2;
        while (l<=r){
            long mid=l+(r-l)/2;
            long temp=mid*mid;
            if (temp==num) return true;
            else if (temp>num) r=mid-1;
            else l=mid+1;
        }
        return false;
    }

    @Test
    public void test(){
        System.out.println(isPerfectSquare(2147483647));
    }
}
