package top.tinn.剑指offer.Interview_62;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/6 21:04
 */
public class Solution {
    public int lastRemaining(int n, int m) {
        int last = 0;
        if (n < 2) return last;
        for (int i = 2; i <= n; i++){
            last = (last + m) % n;
        }
        return last;
    }
}
