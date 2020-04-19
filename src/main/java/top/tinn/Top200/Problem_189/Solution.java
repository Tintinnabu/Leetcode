package top.tinn.Top200.Problem_189;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description
 * @Author Tinn
 * @Date 2020/4/18 19:22
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        int size = nums.length;
        k = k % size;
        while (k-- > 0)
            rotateOnce(nums);
    }

    private void rotateOnce(int[] nums) {
        int temp = nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 1; i--)
            nums[i] = nums[i - 1];
        nums[0] = temp;
    }

    public void rotate2(int[] nums, int k) {
        int size = nums.length;
        k = k % size;
        reverse(nums, 0, size - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, size - 1);
    }

    private void reverse(int[] nums, int i, int i1) {
        while (i < i1){
            int temp = nums[i];
            nums[i++] = nums[i1];
            nums[i1--] =temp;
        }
    }

    public void rotate3(int[] nums, int k) {
        int size = nums.length;
        k = k % size;
       int count = 0;
       for (int start = 0; count < nums.length;start++){
           int current = start;
           int prev = nums[start];
           do{
               int next = (current + k) % size;
               int temp = nums[next];
               nums[next] = prev;
               prev = temp;
               current = next;
               count++;
           }while (start != current);
       }
    }

    @Test
    public void test(){
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate3(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
