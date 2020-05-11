package top.tinn.剑指offer.Interview_16;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/4/30 14:25
 */
public class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return helper(x, N);
    }

    private double helper(double x,long n){
        double ret = 1.0;
        while (n > 0){
            if ((n & 1) == 1){
                ret *= x;
            }
            x *= x;
            n >>= 1;
        }
        return ret;
    }
}
