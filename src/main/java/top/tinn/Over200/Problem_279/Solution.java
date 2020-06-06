package top.tinn.Over200.Problem_279;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/6/6 11:31
 */
public class Solution {
    private static final List<Integer> dp = new ArrayList<>();
    public int numSquares(int n) {
        if (dp.size() == 0){
            dp.add(0);
        }
        if (dp.size() <= n){
            //接着之前最后一个值开始计算
            for (int i = dp.size(); i <= n; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j * j <= i; j++) {
                    min = Math.min(min, dp.get(i - j * j) + 1);
                }
                dp.add(min);
            }
        }
        return dp.get(n);
    }
}
