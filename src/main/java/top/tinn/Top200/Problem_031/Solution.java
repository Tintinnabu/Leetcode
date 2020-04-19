package top.tinn.Top200.Problem_031;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description
 *
 * 31. 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * @Author Tinn
 * @Date 2020/4/18 10:38
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        nextPermutation(nums, 0, nums.length-1);
    }

    private void nextPermutation(int[] nums, int left, int right) {
        int i = right;
        for (; i > left; i--){
            if (nums[i] > nums[i-1]){
                int index = findBiggerNumIndex(nums, i, right, nums[i - 1]);
                swap(nums, i-1, index);
                Arrays.sort(nums, i, right + 1);
                break;
            }
        }
        if (i == left)
            Arrays.sort(nums);
    }

    private void swap(int[] nums, int i, int index) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }

    private int findBiggerNumIndex(int[] nums, int left, int right, int num) {
        int min = Integer.MAX_VALUE;
        int ret = left;
        for (int i = left; i <= right; i++){
            if (nums[i] > num && nums[i] < min){
                min = nums[i];
                ret = i;
            }
        }
        return ret;
    }

    @Test
    public void test(){
        int[] nums = {1,2,3};
        for (int i = 0; i < 6; i++){
            nextPermutation(nums);
            System.out.println(Arrays.toString(nums));
        }
    }
}
