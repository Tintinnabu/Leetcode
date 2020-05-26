package top.tinn.DoublePointsProblem.Problem_042;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * 42. 接雨水
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int trap(int[] height) {
        int l=0,r=height.length-1,sum=0;
        while (l<r){
            while (l<r&&height[l]<height[l+1]) l++;
            while (l<r&&height[r]<height[r-1]) r--;
            int lHeight=height[l];
            int rHeight=height[r];
            if (lHeight<=rHeight){
                l++;
                while (l<=r&&height[l]<lHeight){
                    sum+=lHeight-height[l];
                    l++;
                }
            }else {
                r--;
                while (l<=r&&height[r]<rHeight){
                    sum+=rHeight-height[r];
                    r--;
                }
            }
        }
        return sum;
    }

    //单调栈
    public int trap2(int[] height) {
        if (height == null){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int ret = 0;
        for (int i = 0; i < height.length; i++){
            while (!stack.isEmpty() && height[stack.peek()] < height[i]){
                int curIdx = stack.pop();
                // 如果栈顶元素一直相等，那么全都pop出去，只留第一个。
                while (!stack.isEmpty() && height[stack.peek()] == height[curIdx]){
                    stack.pop();
                }
                if (!stack.isEmpty()){
                    int stackTop = stack.peek();
                    ret += (Math.min(height[stackTop], height[i]) - height[curIdx]) * (i - stackTop - 1);
                }
            }
            stack.push(i);
        }
        return ret;
    }

    //dp
    public int trap3(int[] height) {
        int ret = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        for (int i = 1; i < height.length - 1; i++){
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }

        for (int i = 1; i < height.length - 1; i++){
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (min > height[i]){
                ret += (min - height[i]);
            }
        }
        return ret;
    }

    //double points
    public int trap4(int[] height) {
        int sum = 0;
        int max_left = 0, max_right = 0;
        int left = 1, right = height.length - 2;
        for (int i = 1; i < height.length - 1; i++){
            //从左到右更
            if (height[left - 1] < height[right + 1]) {
                max_left = Math.max(max_left, height[left - 1]);
                if (max_left > height[left]){
                    sum += (max_left - height[left]);
                }
                left++;
                //从右到左更
            } else {
                max_right = Math.max(max_right, height[right + 1]);
                int min = max_right;
                if (min > height[right]) {
                    sum = sum + (min - height[right]);
                }
                right--;
            }
        }
        return sum;
    }


    @Test
    public void test(){
        int[] height={5,4,1,2};
        System.out.println(trap(height));
        System.out.println(trap2(height));
        System.out.println(trap3(height));
        System.out.println(trap4(height));
    }
}
