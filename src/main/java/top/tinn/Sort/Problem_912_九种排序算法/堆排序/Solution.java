package top.tinn.Sort.Problem_912_九种排序算法.堆排序;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/16 15:54
 */
public class Solution {

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        //大根堆
        heapify(nums);
        for (int i = len - 1; i >= 1;){
            //头节点最大
            swap(nums, 0, i);
            i--;
            shiftDown(nums, 0, i);
        }
        return nums;
    }

    private void heapify(int[] nums) {
        int len = nums.length;
        // 只需要从 i = (len - 1) / 2 这个位置开始逐层下移
        for (int i = (len - 1)/2; i >= 0; i--){
            shiftDown(nums, i, len - 1);
        }
    }

    private void shiftDown(int[] nums, int k, int end) {
        while (2 * k + 1 <= end){
            int j = 2 * k + 1;
            //获取两个中最大的一个
            if (j + 1 <= end && nums[j + 1] > nums[j]){
                j++;
            }
            if (nums[j] > nums[k]){
                swap(nums, j, k);
            }else {
                break;
            }
            k = j;
        }
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
