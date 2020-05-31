package top.tinn.Sort.Problem_912_九种排序算法.归并排序;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/16 15:25
 */
public class Solution {
    private static final int INSERTION_SORT_THRESHOLD = 7;
    //基本思路：借助额外空间，合并两个有序数组，得到更长的有序数组
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        mergeSort(nums, 0, len - 1, temp);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (right - left <= INSERTION_SORT_THRESHOLD){
            insertSort(nums, left, right);
            return;
        }
        int mid = left + (right - left) / 2;
        // Java 里有更优的写法，在 left 和 right 都是大整数时，即使溢出，结论依然正确
        // int mid = (left + right) >>> 1;
        //两侧子数组排序，在归并为一个数组
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        if (nums[mid] < nums[mid + 1]){
            return;
        }
        mergeOfTwoSortedArray(nums, left, mid, right, temp);
    }

    private void insertSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = nums[i];
            int j = i;
            while (j > left && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }

    private void mergeOfTwoSortedArray(int[] nums, int left, int mid, int right, int[] temp) {
        System.arraycopy(nums, left, temp, left, right - left + 1);
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++){
            if (i == mid + 1){
                nums[k] = nums[j];
                j++;
            }else if (j == right + 1){
                nums[k] = nums[i];
                i++;
            }else if (temp[i] <= temp[j]){
                nums[k] = nums[i];
                i++;
            }else {
                nums[k] = nums[j];
                j++;
            }
        }
    }

    @Test
    public void test(){
        int[] nums = {5, 2, 3, 1, 9, 6, 7, 8};
        int[] res = sortArray(nums);
        System.out.println(Arrays.toString(res));
    }
}
