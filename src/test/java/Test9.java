import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @Author: Tinn
 * @Date: 2020/10/19 21:00
 */
public class Test9 {
    public int findKthLargest(int[] nums, int k) {
        return helper(nums, 0, nums.length - 1, nums.length - k);
    }

    Random random = new Random();
    private int helper(int[] nums, int l, int r, int k) {

        int i = l, j = r, cur = i;
        //int pivot = random.nextInt(r - l) + l;
        int pivotVal = nums[l];
        while (cur <= j){
            if (nums[cur] < pivotVal){
                swap(nums, i, cur);
                i++;
                cur++;
            }else if (nums[cur] > pivotVal){
                swap(nums, cur, j);
                j--;
            }else {
                cur++;
            }
        }
        if (i <= k && k <= j){
            return pivotVal;
        }else if (i > k){
            return helper(nums, l, i - 1, k);
        }
        return helper(nums, j + 1, r, k);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test(){
        int[] nums = {3,2,3,1,2,4,5,5,6};
        for (int i = 1; i <= nums.length; i++){
            System.out.println(findKthLargest(nums, i));
        }
    }
}
