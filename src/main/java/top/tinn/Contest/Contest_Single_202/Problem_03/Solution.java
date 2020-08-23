package top.tinn.Contest.Contest_Single_202.Problem_03;

import java.util.Arrays;

/**
 * @Author: Tinn
 * @Date: 2020/8/17 15:00
 */
public class Solution {
    private int inf = (int)1e9;
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int l = 1, r = (position[position.length - 1] - position[0]);
        while(l < r){
            int k = (l + r + 1) / 2;
            if (check(position, m, k)){
                l = k;
            }else{
                r = k - 1;
            }
        }
        return l;
    }

    private boolean check(int[] position, int m, int k){
        int last = -inf;
        for (int x : position){
            if (x - last >= k){
                m--;
                last = x;
            }
        }
        return m <= 0;
    }
}
