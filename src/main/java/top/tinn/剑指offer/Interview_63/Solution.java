package top.tinn.剑指offer.Interview_63;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/6 20:47
 */
public class Solution {
    //dp_i0 第i天不持有股票 dp_i1第i天持有股票
    public int maxProfit(int[] prices) {
        // base case: dp[-1][0] = 0, dp[-1][1] = -infinity
        int dp_i0 = 0, dp_i1 = Integer.MIN_VALUE;
        for (int price : prices){
            dp_i0 = Math.max(dp_i0, dp_i1 + price);
            dp_i1 = Math.max(dp_i1, -price);
        }
        return dp_i0;
    }
}
