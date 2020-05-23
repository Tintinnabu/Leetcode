package top.tinn.Top200.Problem_011;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/23 21:33
 */
public class Solution {
    public int maxArea(int[] height) {
        int ret = 0, l = 0, r = height.length - 1;
        while (l < r){
            ret = Math.max(ret, (r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]){
                l++;
            }else {
                r--;
            }
        }
        return ret;
    }
}
