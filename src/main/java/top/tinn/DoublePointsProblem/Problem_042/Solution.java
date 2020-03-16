package top.tinn.DoublePointsProblem.Problem_042;

import org.junit.jupiter.api.Test;

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

    @Test
    public void test(){
        int[] height={5,4,1,2};
        System.out.println(trap(height));
    }
}
