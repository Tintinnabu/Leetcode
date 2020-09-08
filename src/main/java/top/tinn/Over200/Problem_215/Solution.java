package top.tinn.Over200.Problem_215;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/29 22:47
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    private static final Random RANDOM = new Random();
    private int quickSort(int[] nums, int left, int right, int k_smallest) {
        if (left == right){
            return nums[left];
        }
        int random = left + RANDOM.nextInt(right - left);
        int pivot = nums[random];
        int lt = left, i = left, gt = right;
        while (i <= gt){
            if (nums[i] < pivot){
                swap(nums, i, lt);
                i++;
                lt++;
            }else if (nums[i] > pivot){
                swap(nums, i, gt);
                gt--;
            }else {
                i++;
            }
        }
        if (lt <= k_smallest && k_smallest <= gt){
            return pivot;
        }else if (k_smallest < lt){
            return quickSort(nums, left, lt - 1, k_smallest);
        }
        return quickSort(nums, gt + 1, right, k_smallest);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test(){
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        //System.out.println(RANDOM.nextInt(0));
        System.out.println(findKthLargest(nums, 1));
        int[] nums2 = {1332802,1177178,1514891,871248,753214,123866,1615405,328656,1540395,968891,1884022,252932,1034406,1455178,821713,486232,860175,1896237,852300,566715,1285209,1845742,883142,259266,520911,1844960,218188,1528217,332380,261485,1111670,16920,1249664,1199799,1959818,1546744,1904944,51047,1176397,190970,48715,349690,673887,1648782,1010556,1165786,937247,986578,798663};
        System.out.println(findKthLargest(nums2, 24));
    }
}
