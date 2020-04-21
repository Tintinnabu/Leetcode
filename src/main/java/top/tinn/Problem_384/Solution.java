package top.tinn.Problem_384;


import java.util.*;

/**
 * @ClassName Solution
 * @Description
 * @Author Tinn
 * @Date 2020/4/20 15:08
 */
public class Solution {
    private int[] pre;
    private int[] cur;
    private Random random = new Random();
    public Solution(int[] nums) {
        pre = nums.clone();
        cur = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        cur = pre;
        pre = pre.clone();
        return pre;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < cur.length; i++){
            swap(i, randRange(i, cur.length));
        }
        return cur;
    }

    private void swap(int i, int j) {
        int temp = cur[i];
        cur[i] = cur[j];
        cur[j] = temp;
    }

    private int randRange(int l, int r) {
        return random.nextInt(r - l) + l;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Solution solution = new Solution(nums);
        for (int i = 0 ; i < 2; i++){
            System.out.println(Arrays.toString(solution.shuffle()));
            System.out.println(Arrays.toString(solution.shuffle()));
            System.out.println(Arrays.toString(solution.shuffle()));
            System.out.println(Arrays.toString(solution.reset()));
        }

    }
}
