package top.tinn.Contest.Contest_Single_201.Problem_03;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        int len = nums.length;
        int[] preSum = new int[len];
        //preSum, index
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int preIndex = -1;
        int res = 0;
        for (int i = 0; i < len; i++){
            if (i == 0){
                preSum[0] = nums[0];
            }else {
                preSum[i] = preSum[i - 1] + nums[i];
            }
            if (map.containsKey(preSum[i] - target)){
                if (map.get(preSum[i] - target) > preIndex){
                    res++;
                    preIndex = i;
                }
            }
            map.put(preSum[i], i + 1);
        }
        return res;
    }

    @Test
    public void test(){
        int[] nums = {0,0,0,0,0};
        int target = 0;
        System.out.println(maxNonOverlapping(nums, target));
    }
}
