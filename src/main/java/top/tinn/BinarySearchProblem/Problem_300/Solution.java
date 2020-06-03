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

    /**
     * 算法流程：
     *
     * 状态定义：
     *
     * tails[k]tails[k] 的值代表 长度为 k+1k+1 子序列 的尾部元素值。
     * 转移方程： 设 resres 为 tailstails 当前长度，代表直到当前的最长上升子序列长度。设 j∈[0,res)j∈[0,res)，考虑每轮遍历 nums[k]nums[k] 时，通过二分法遍历 [0,res)[0,res) 列表区间，找出 nums[k]nums[k] 的大小分界点，会出现两种情况：
     *
     * 区间中存在 tails[i] > nums[k]tails[i]>nums[k] ： 将第一个满足 tails[i] > nums[k]tails[i]>nums[k] 执行 tails[i] = nums[k]tails[i]=nums[k] ；因为更小的 nums[k]nums[k] 后更可能接一个比它大的数字（前面分析过）。
     * 区间中不存在 tails[i] > nums[k]tails[i]>nums[k] ： 意味着 nums[k]nums[k] 可以接在前面所有长度的子序列之后，因此肯定是接到最长的后面（长度为 resres ），新子序列长度为 res + 1res+1。
     * 初始状态：
     *
     * 令 tailstails 列表所有值 =0=0。
     * 返回值：
     *
     * 返回 resres ，即最长上升子子序列长度。
     */
    public int lengthOfLIS2(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums){
            int i = 0, j = res;
            while (i < j){
                int mid = (j - i) / 2 + i;
                if (tails[mid] < num){
                    i = mid + 1;
                }else {
                    j = mid;
                }
            }
            tails[i] = num;
            if (res == j){
                res++;
            }
        }
        return res;
    }

    @Test
    public void test(){
        int[] nums=new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS2(nums));
    }
}
