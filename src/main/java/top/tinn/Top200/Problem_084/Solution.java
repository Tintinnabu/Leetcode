package top.tinn.Top200.Problem_084;

import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        //单调栈
        int res = 0;
        for (int i = 0; i < heights.length; i++){
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]){
                res = Math.max(res, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1){
            res = Math.max(heights[stack.pop()] * (heights.length - stack.peek() - 1), res);
        }
        return res;
    }
}
