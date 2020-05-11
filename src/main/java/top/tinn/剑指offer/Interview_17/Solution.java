package top.tinn.剑指offer.Interview_17;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/7 17:12
 */
public class Solution {
    public int[] printNumbers(int n) {
        double total = Math.pow(10, n);
        int[] ret = new int[(int)total - 1];
        for (int i = 0; i < total - 1; i++)
            ret[i] = i + 1;
        return ret;
    }
}
