package top.tinn.Top200.Problem_041;

import org.junit.jupiter.api.Test;

/**
 * @ClassName Solution
 * @Description
 * 41. 缺失的第一个正数
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *
 *
 * 提示：
 *
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 * @Author Tinn
 * @Date 2020/4/20 11:50
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++){
            while ( nums[i] > 0 && nums[i] <= len &&
            nums[nums[i] - 1] != nums[i]){
                swap(nums, nums[i] - 1, i);
            }
        }
        for (int i = 0; i < len; i++){
            if (nums[i] != i + 1) return i + 1;
        }
        return len + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test(){
        int[] nums = {3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }
}
