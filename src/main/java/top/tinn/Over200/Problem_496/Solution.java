package top.tinn.Over200.Problem_496;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = nums2.length - 1; i >= 0; i--){
            while (stack.peek() != -1 && nums2[i] >= stack.peek()){
                stack.pop();
            }
            map.put(nums2[i], stack.peek());
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++){
            if (map.get(nums1[i]) > -1){
                nums1[i] = map.get(nums1[i]);
            }else {
                nums1[i] = -1;
            }
        }
        return nums1;
    }

    @Test
    public void test(){
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }
}
