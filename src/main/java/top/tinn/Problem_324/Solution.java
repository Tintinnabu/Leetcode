package top.tinn.Problem_324;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @ClassName Solution
 * @Description
 * 324. 摆动排序 II
 * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 *
 * 示例 1:
 *
 * 输入: nums = [1, 5, 1, 1, 6, 4]
 * 输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
 * 示例 2:
 *
 * 输入: nums = [1, 3, 2, 2, 3, 1]
 * 输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
 * 说明:
 * 你可以假设所有输入都会得到有效的结果。
 *
 * 进阶:
 * 你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 * @Author Tinn
 * @Date 2020/4/21 11:13
 */
public class Solution {

    public void wiggleSort(int[] nums) {
        int len = nums.length;
        //quickSelect(nums, 0, len - 1, (len - 1)/ 2);
        quickselect(0, len - 1, (len - 1) / 2, nums);
        int mid = nums[(len - 1)/ 2];
        int midIdx = (len - 1)/2;
        // 3-way-partition
        int i = 0, j = 0, k = len - 1;
        while (j < k){
            if (nums[j] > mid){
                swap(j, k--, nums);
            }else if (nums[j] < mid) {
                swap(j++, i++, nums);
            }else j++;
        }
        int[] temp = nums.clone();
        if (len % 2 == 1){
            for (i = nums.length - 1;i >= midIdx + 1; i--){
                nums[nums.length -((i - midIdx) * 2)] = temp[i];
            }
            for (i = 0; i <= midIdx; i++){
                nums[nums.length - 1- 2 * i] = temp[i];
            }
        }else {
            for (i = nums.length - 1;i >= midIdx + 1; i--){
                nums[nums.length -((i - midIdx) * 2 - 1)] = temp[i];
            }
            for (i = 0; i <= midIdx; i++){
                nums[nums.length - 2- 2 * i] = temp[i];
            }
        }


    }

    private int quickselect(int left,int right,int k_smallest,int[] nums){
        if(left==right) return nums[left];
        Random random=new Random();
        int pivot_index = left + random.nextInt(right - left);
        pivot_index = partition(left, right, pivot_index,nums);
        if(pivot_index==k_smallest) return nums[k_smallest];
        else if (k_smallest < pivot_index)
            return quickselect(left, pivot_index - 1, k_smallest,nums);
        return quickselect(pivot_index + 1, right, k_smallest,nums);
    }

    private int partition(int left,int right,int pivot_index,int[] nums){
        int pivot=nums[pivot_index];
        swap(pivot_index,right,nums);
        int store_index=left;
        for(int i=left;i<nums.length;i++){
            if(nums[i]<pivot){
                swap(i,store_index,nums);
                store_index++;
            }
        }
        swap(store_index,right,nums);
        return store_index;
    }

    private void swap(int left,int right,int[] nums){
        int tmp=nums[left];
        nums[left]=nums[right];
        nums[right]=tmp;
    }

    @Test
    public void test(){
        int[] nums = {1,1,2,1,2,2};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
