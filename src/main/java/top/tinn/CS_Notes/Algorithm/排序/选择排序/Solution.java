package top.tinn.CS_Notes.Algorithm.排序.选择排序;

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
    //从数组中选择最小元素，将它与数组的第一个元素交换位置。
    // 再从数组剩下的元素中选择出最小的元素，将它与数组的第二个元素交换位置。
    // 不断进行这样的操作，直到将整个数组排序。
    //选择排序需要 ~N2/2 次比较和 ~N 次交换，它的运行时间与输入无关，
    // 这个特点使得它对一个已经排序的数组也需要这么多的比较和交换操作。
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
