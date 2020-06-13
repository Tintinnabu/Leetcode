package top.tinn.Contest_Single_192.Problem_01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tintinnabu
 * @description
 * @data 2020/6/7
 */
public class Solution {
    public int[] shuffle(int[] nums, int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++){
            res.add(nums[i]);
            res.add(nums[i + n]);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
