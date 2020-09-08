package top.tinn.Top200.Problem_069;

import java.util.Random;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/9 16:05
 */
public class Solution {
    public int mySqrt(int a) {
        long x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;
        }
        return (int) x;

    }

    public int mySqrt2(int x) {
        long l = 0, r = x;
        while (l < r){
            long mid = l + (r - l  + 1) / 2;
            if (mid * mid > x) r = mid - 1;
            else if (mid * mid < x) l = mid;
            else return (int)mid;
        }
        return (int)l;
    }
}
