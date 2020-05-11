package top.tinn.剑指offer.Interview_51;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/2 15:57
 */
public class Solution {
    private  int count = 0;
    private int[] aux;
    public int reversePairs(int[] nums) {
        sort(nums, 0, nums.length - 1, new int[nums.length]);
        return count;
    }

    private void sort(int[] nums, int left, int right, int[] aux){
        if (left >= right) return;
        int mid = (right - left) /2 + left;
        sort(nums, left, mid, aux);
        sort(nums, mid + 1, right, aux);
        if (nums[mid] <= nums[mid + 1]) return;
        merge(nums, left, mid, right, aux);
    }

    private void merge(int[] nums, int left, int mid, int right, int[] aux) {
        for (int z = left; z <= right; z++){
            aux[z] = nums[z];
        }
        int i = mid, j = right;
        for (int k = right; k >= left; k--){
            if (i < left) nums[k] = aux[j--];
            else if (j <= mid) nums[k] = aux[i--];
            else if (aux[i] > aux[j]){
                nums[k] = aux[i--];
                count += (j - mid);
            }else if (aux[i] <= aux[j]){
                nums[k] = aux[j--];
            }
        }
    }

    @Test
    public void test(){
        int[] nums = {1,3,2,3,1};
        System.out.println(reversePairs(nums));
    }
}
