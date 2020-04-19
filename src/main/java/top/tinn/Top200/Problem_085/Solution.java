package top.tinn.Top200.Problem_085;

import java.util.Stack;

/**
 * @ClassName Solution
 * @Descriptions
 *
 * 85. 最大矩形
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * 输出: 6
 * @Author Tinn
 * @Date 2020/4/18 13:09
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int[] heights = new int[matrix[0].length];
        int maxArea = 0;
        for (int row = 0; row < matrix.length; row++){
            for (int col = 0; col < matrix[0].length; col++){
                if (matrix[row][col] == '1')
                    heights[col]++;
                else heights[col] = 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < heights.length; i++){
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]){
                res = Math.max(res, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1){
            res = Math.max(res, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return res;
    }
}
