package top.tinn.Sort.Problem_912_九种排序算法.选择排序;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/16 15:16
 */
public class Solution {
    //1.选择排序：每一轮选择最小元素交换到未排定部分的开头
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++){
            int minIndex = i;
            for (int j = i; j < len; j++){
                if (nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test(){
        int[] nums = {5, 2, 3, 1};
        int[] res = sortArray(nums);
        System.out.println(Arrays.toString(res));
    }
}
