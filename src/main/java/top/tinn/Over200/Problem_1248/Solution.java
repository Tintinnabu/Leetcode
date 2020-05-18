package top.tinn.Over200.Problem_1248;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/16 21:10
 */
public class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int[] mark = new int[nums.length + 1];
        int even = 0;
        int count = 0;
        mark[0] = 1;
        for (int n : nums){
            if ((n & 1) != 0){
                even++;
            }
            mark[even]++;
            if (even >= k){
                count += mark[even - k];
            }
        }
        return count;
    }

    @Test
    public void test(){
        int[] nums = {1,1,2,1,1};
        System.out.println(numberOfSubarrays(nums, 3));
    }
}
