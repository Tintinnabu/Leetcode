package top.tinn.Sort.Problem_912_九种排序算法.希尔排序;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/16 16:13
 */
public class Solution {
    //思想来源：插入排序的优化。在插入排序里，如果靠后的数字较小，它来到前面就得交换多次。
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        int h = 1;
        //计算最大间隔
        while (3 * h + 1 < len){
            h = 3 * h + 1;
        }
        while (h >= 1){
            for (int i = h; i < len; i++){
                insertForDelta(nums, h, i);
            }
            h /= 3;
        }
        return nums;
    }

    private void insertForDelta(int[] nums, int gap, int i) {
        int temp = nums[i];
        int j = i;
        while (j >= gap && nums[j - gap] > temp){
            nums[j] = nums[j - gap];
            j -= gap;
        }
        nums[j] = temp;
    }

    @Test
    public void test(){
        int[] nums = {5, 2, 3, 1, 9, 6, 7, 8};
        int[] res = sortArray(nums);
        System.out.println(Arrays.toString(res));
    }
}
