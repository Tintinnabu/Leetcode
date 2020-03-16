package top.tinn.DpProblem.Problem_120;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120. 三角形最小路径和
 *
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size=triangle.size();
        int[] dp=new int[size];
        for (List<Integer> row:triangle){
            for (int i=row.size()-1;i>=0;i--){
                if (i==0) dp[i]+=row.get(i);
                else if (i==row.size()-1) dp[i]=dp[i-1]+row.get(i);
                else dp[i]=Math.min(dp[i],dp[i-1])+row.get(i);
            }
        }
        int min=dp[0];
        for(int n:dp){
            if (n<min)
                min=n;
        }
        return min;
    }

    @Test
    public void test(){
        List<List<Integer>> triangle=new ArrayList<>();
        List<Integer> t1= Arrays.asList(2);
        List<Integer> t2= Arrays.asList(3,4);
        List<Integer> t3= Arrays.asList(6,5,7);
        List<Integer> t4= Arrays.asList(4,1,8,3);
        triangle.add(t1);
        triangle.add(t2);
        triangle.add(t3);
        triangle.add(t4);
        System.out.println(minimumTotal(triangle));

    }
}
