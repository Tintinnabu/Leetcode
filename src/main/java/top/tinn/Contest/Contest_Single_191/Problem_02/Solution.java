package top.tinn.Contest.Contest_Single_191.Problem_02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/31 10:26
 */
public class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int r = maxDiff(h, horizontalCuts);
        int c = maxDiff(w, verticalCuts);
        double ans = (double) r * c;
        return (int)(ans % (10000000 + 7));
    }

    private int maxDiff(int h, int[] horizontalCuts) {
        Arrays.sort(horizontalCuts);
        int ret = 0;
        for (int i = 0; i <= horizontalCuts.length; i++){
            if (i == 0){
                ret = Math.max(horizontalCuts[0], ret);
            }else if (i < horizontalCuts.length){
                ret = Math.max(horizontalCuts[i] - horizontalCuts[i - 1], ret);
            }else {
                ret = Math.max(h - horizontalCuts[i - 1], ret);
            }
        }
        return ret;
    }
    @Test
    public void test(){
        double a = 1e7 + 7;
        int l = 109866;
        int r = 125201;
        double ret = (double) l * r;
        System.out.println(ret);
        System.out.println(ret % a);

    }
}
