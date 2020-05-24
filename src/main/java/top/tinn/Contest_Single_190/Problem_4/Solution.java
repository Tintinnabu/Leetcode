package top.tinn.Contest_Single_190.Problem_4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.IntPredicate;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/24 11:10
 */
public class Solution {
    //dp[i][j]的含义是到nums1[i]和nums2[j]为止的子序列的最大点积。
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for (int i = 0; i < nums1.length; i++){
            for (int j = 0; j < nums2.length; j++){
                dp[i][j] = nums1[i] * nums2[j];
                if (i > 0 && j > 0){
                    //选择nums1[i]和nums2[j]
                    dp[i][j] = Math.max(dp[i][j], dp[i][j] + dp[i - 1][j - 1]);
                }
                if (i > 0){
                    //不选择nums1[i],选择nums2[j]
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }
                if (j > 0){
                    //选择nums1[i],不选择nums2[j]
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                }
            }
        }
        return dp[nums1.length - 1][nums2.length - 1];
    }

    @Test
    public void test(){
        int[] nums2 = {-3,-8,3,-10,1,3,9};
        int[] nums1 ={9,2,3,7,-9,1,-8,5,-1,-1};
        System.out.println(maxDotProduct(nums1, nums2));
    }
}
