package top.tinn.剑指offer.Interview_56_2;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/5 22:07
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int x1 = 0, x2 = 0, mask;
        for (int n : nums){
            x2 ^= x1 & n;
            x1 ^= n;
            mask = ~(x1 & x2);
            x2 &= mask;
            x1 &= mask;
        }
        return x1;
    }
}
