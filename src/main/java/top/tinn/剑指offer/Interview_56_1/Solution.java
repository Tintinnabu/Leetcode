package top.tinn.剑指offer.Interview_56_1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/5 22:30
 */
public class Solution {
    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int n : nums){
            ret ^= n;
        }
        int index = 1;
        while ((ret & index) == 0)
            index <<= 1;
        int a = 0, b = 0;
        for (int n : nums){
            if ((n & index) != 0){
                a ^= n;
            }else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(singleNumbers(new int[]{1,2,5,2})));
    }
}
