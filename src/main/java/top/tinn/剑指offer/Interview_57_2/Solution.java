package top.tinn.剑指offer.Interview_57_2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/6 17:12
 */
public class Solution {
    public int[][] findContinuousSequence(int target) {
        int left = 1, right = 1, sum = 0;
        List<int[]> list = new ArrayList<>();
        while (right <= (target + 1)/2 && left <= right){
            sum += right++;
            while (sum >= target){
                if (sum == target) list.add(new int[]{left, right - 1});
                sum -= left++;
            }
        }
        int[][] ret = new int[list.size()][];
        int k = 0;
        for (int[] set : list){
            int[] temp = new int[set[1] - set[0] + 1];
            for (int i = 0; i < temp.length; i++)
                temp[i] = set[0] + i;
            ret[k++] = temp;
        }
        return ret;
    }

    @Test
    public void test(){
        int[][] ret = findContinuousSequence(15);
        System.out.println(1);
    }
}
