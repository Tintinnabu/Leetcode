package top.tinn.剑指offer.Interview_15;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/4/30 14:18
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0){
            n &= (n-1);
            count++;
            n >>>= 1;
        }
        return count;
    }
}
