package top.tinn.Contest.Contest_Single_202.Problem_04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Tinn
 * @Date: 2020/8/16 11:26
 */
public class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    public int minDays(int n) {
        if (n == 0){
            return 0;
        }
        if (!map.containsKey(n)){
            int ans = n;
            int half = n / 2;
            int third = n / 3;
            ans = Math.min(ans, minDays(half) + n - half * 2 + 1);
            ans = Math.min(ans, minDays(third) + n - third * 3 + 1);
            map.put(n, ans);
        }
        return map.get(n);

    }
}
