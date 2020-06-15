package top.tinn.Over200.Problem_398;

import java.util.*;

/**
 * @author Tintinnabu
 * @description
 * @data 2020/6/15
 */
public class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    public Solution(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            if (map.get(nums[i]) == null) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        Random random = new Random();
        List<Integer> list = map.get(target);
        int count = 0;
        int reserve = 0;
        int i = 0;
        while (i < list.size()){
            count++;
            int rand = random.nextInt(count) + 1;
            if(count == rand){
                reserve = i;
            }
            i++;
        }
        return list.get(reserve);
    }
}
