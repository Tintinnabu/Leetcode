package top.tinn.Top200.Problem_075;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName Solution
 * @Description
 * @Author Tinn
 * @Date 2020/4/22 15:31
 */
public class Solution {
    public void sortColors(int[] nums) {
        int l=0,r=nums.length-1,curr=0;
        while(curr<=r){
            if(nums[curr]==0){
                swap(nums, l, curr);
                curr++;
                l++;
            }
            else if(nums[curr]==2){
                swap(nums, r, curr);
                r--;
            }else curr++;
        }
        Arrays.sort(nums);
    }

    private void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }


    public void quickSort(int[] nums){
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        Random random = new Random();
        int pivotIdx = left + random.nextInt(right - left);
        int pivot = nums[pivotIdx];
        int i = left, j = right, curr = i;
        while (curr <= j){
            if (nums[curr] < pivot){
                swap(nums, curr ,i);
                curr++;i++;
            }else if (nums[curr] > pivot){
                swap(nums, curr, j);
                j--;
            }else {
                curr++;
            }
        }
        quickSort(nums, left, i - 1);
        quickSort(nums, j + 1, right);
    }

    public void quickSort2(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }

        int left = leftIndex;
        int right = rightIndex;
        //待排序的第一个元素作为基准值
        int key = arr[left];

        //从左右两边交替扫描，直到left = right
        while (left < right) {
            while (right > left && arr[right] >= key) {
                //从右往左扫描，找到第一个比基准值小的元素
                right--;
            }

            //找到这种元素将arr[right]放入arr[left]中
            arr[left] = arr[right];

            while (left < right && arr[left] <= key) {
                //从左往右扫描，找到第一个比基准值大的元素
                left++;
            }

            //找到这种元素将arr[left]放入arr[right]中
            arr[right] = arr[left];
        }
        //基准值归位
        arr[left] = key;
        //对基准值左边的元素进行递归排序
        quickSort2(arr, leftIndex, left - 1);
        //对基准值右边的元素进行递归排序。
        quickSort2(arr, right + 1, rightIndex);
    }

    @Test
    public void test(){
        int[] nums = {6,5,4,3,2,1};
        quickSort2(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

}
