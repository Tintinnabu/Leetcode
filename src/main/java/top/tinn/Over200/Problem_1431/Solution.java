package top.tinn.Over200.Problem_1431;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/6/1 15:07
 */
public class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for(int n : candies){
            max = Math.max(max, n);
        }
        List<Boolean> ret = new ArrayList<>();
        for (int n : candies){
            if (n + extraCandies >= max){
                ret.add(true);
            }else {
                ret.add(false);
            }
        }
        return ret;
    }
}
