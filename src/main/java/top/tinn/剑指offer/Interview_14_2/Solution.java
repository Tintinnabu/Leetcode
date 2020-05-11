package top.tinn.剑指offer.Interview_14_2;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/4/30 13:59
 */
public class Solution {
    public int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        long res = 1, mod = 1000000007;
        while (n > 4){
            res *= 3;
            res %= mod;
            n -= 3;
        }
        return (int) (res * n % mod);
    }
}
