package top.tinn.BinarySearchProblem.Problem_300;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 300. 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length<1) return 0;
        int result=1;
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]) {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            result=Math.max(result,dp[i]);
        }
        return result;
    }
    public int lengthOfLIS2(int[] nums) {
        int[] dp=new int[nums.length];
        int len=0;
        for(int num:nums){
            int i=Arrays.binarySearch(dp,0,len,num);
            if (i<0) i=-(i+1);
            dp[i]=num;
            if(i==len) len++;
        }
        return len;
    }

    @Test
    public void test(){
        int[] nums=new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS2(nums));
    }
}
