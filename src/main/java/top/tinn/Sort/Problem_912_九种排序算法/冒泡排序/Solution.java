package top.tinn.Sort.Problem_912_九种排序算法.冒泡排序;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/16 16:19
 */
public class Solution {
    //插入排序：每次将一个数字插入一个有序的数组里，成为一个长度更长的有序数组，有限次操作以后，数组整体有序。
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i >= 0; i--){
            boolean sorted = true;
            for (int j = 0; j < i; j++){
                if (nums[j] > nums[j + 1]){
                    swap(nums, j, j + 1);
                    sorted = false;
                }
            }
            if (sorted){
                break;
            }
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
        int[] nums = {5, 2, 3, 1, 9, 6, 7, 8};
        int[] res = sortArray(nums);
        System.out.println(Arrays.toString(res));
    }
}
