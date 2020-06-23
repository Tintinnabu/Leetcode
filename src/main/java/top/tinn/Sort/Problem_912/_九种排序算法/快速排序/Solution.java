package top.tinn.Sort.Problem_912._九种排序算法.快速排序;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/16 15:36
 */
public class Solution {
    //基本思路：快速排序每一次都排定一个元素（这个元素呆在了它最终应该呆的位置），
    // 然后递归地去排它左边的部分和右边的部分，依次进行下去，直到数组有序；
    /**
     * 列表大小等于或小于该大小，将优先于 quickSort 使用插入排序
     */
    private static final int INSERTION_SORT_THRESHOLD = 7;

    private static final Random RANDOM = new Random();

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (right - left < INSERTION_SORT_THRESHOLD){
            insertSort(nums, left, right);
            return;
        }
        //找一个随机的枢轴，把数组分为两侧，在对两侧数组再做快排
        int random = left + RANDOM.nextInt(right - left + 1);
        swap(nums, random, left);
        int pivot = nums[left];
        int lt = left;
        int gt = right + 1;
        int i = left + 1;
        while (i < gt){
            if (nums[i] < pivot){
                lt++;
                swap(nums, i, lt);
                i++;
            }else if (nums[i] == pivot){
                i++;
            }else {
                gt--;
                swap(nums, i, gt);
            }
        }
        swap(nums, left, lt);
        quickSort(nums, left, lt - 1);
        quickSort(nums, gt, right);
    }

    private void insertSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++){
            int temp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > temp){
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
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
