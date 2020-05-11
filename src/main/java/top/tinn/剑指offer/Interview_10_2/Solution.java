package top.tinn.剑指offer.Interview_10_2;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/4/30 10:47
 */
public class Solution {
    public int numWays(int n) {
        if (n == 1 || n == 0) return n;
        int pre = 1, cur = 1;
        for (int i = 2; i <= n; i++){
            int temp = pre + cur;
            pre = cur;
            cur = temp > 1000000007 ? temp % 1000000007 : temp;
        }
        return cur;
    }
}
