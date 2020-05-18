package top.tinn.Contest_26.Problem_2;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/16 22:36
 */
public class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> ret = new ArrayList<>();
        for (int i = 2; i <= n; i++){
            for (int j = 1; j < i; j++){
                if (gcd(i, j) != 1){
                    continue;
                }
                ret.add(j + "/" + i);
            }
        }
        return ret;
    }

    private int gcd(int i, int j) {
        while (i % j != 0){
            int temp = i % j;
            i = j;
            j = temp;
        }
        return j;
    }
}
