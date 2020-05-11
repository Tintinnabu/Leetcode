package top.tinn.剑指offer.Interview_10_1;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/4/30 10:34
 */
public class Solution {
    public int fib(int n) {
        if (n == 1 || n == 0) return n;
        int pre = 0, cur = 1;
        for (int i = 2; i <= n; i++){
            int temp = pre + cur;
            pre = cur;
            cur = temp;
            cur = cur > 1000000007 ? cur % 1000000007 : cur;
        }
        return cur % 1000000007;
    }

}
