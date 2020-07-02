package top.tinn.Over200.Problem_503;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        //维护一个单调减的栈
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * len - 1; i++){
            while (!stack.isEmpty() && nums[i % len] > nums[stack.peek()]){
                res[stack.pop()] = nums[i % len];
            }
            if (i < len) stack.push(i);
        }
        return res;
    }

    @Test
    public void test(){
        int[] nums = {1, 2, 1};
        nums = new int[]{5,4,3,2,1};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
}
