package top.tinn.DpProblem.Problem_070;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/27 17:12
 */
public class Solution {
    public int climbStairs(int n) {
        if (n < 3){
            return n;
        }
        int p1 = 1, p2 = 2;
        for (int i = 3; i <= n; i++){
            int cur = p1 + p2;
            p1 = p2;
            p2 = cur;
        }
        return p2;
    }
}
