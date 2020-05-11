package top.tinn.Over200.Problem_494;

import org.junit.jupiter.api.Test;

/**
 * 494. 目标和
 *
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 示例 1:
 *
 * 输入: nums: [1, 1, 1, 1, 1], S: 3
 * 输出: 5
 * 解释:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * 一共有5种方法让最终目标和为3。
 * 注意:
 *
 * 数组非空，且长度不会超过20。
 * 初始的数组的和不会超过1000。
 * 保证返回的最终结果能被32位整数存下。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
    int count=0;
    public int findTargetSumWays(int[] nums, int S) {
        calculate(nums,0,0,S);
        return count;
    }


    private void calculate(int[] nums, int index,int currentSum,int target){
        if (index==nums.length){
            if(currentSum==target) count++;
        }else {
            calculate(nums,index+1,currentSum+nums[index],target);
            calculate(nums,index+1,currentSum-nums[index],target);
        }
    }

    @Test
    public void test(){
        int[] nums=new int[]{1,0};
        int S=1;
        System.out.println(findTargetSumWays3(nums,S));
    }

    public int findTargetSumWays2(int[] nums,int S){
        int[][] dp=new int[nums.length][2001];
        dp[0][1000+nums[0]]=1;
        dp[0][1000-nums[0]]+=1;
        for(int i=1;i<nums.length;i++){
            for(int sum=-1000;sum<=1000;sum++){
                if(dp[i-1][sum+1000]>0){
                    dp[i][sum+nums[i]+1000]+=dp[i-1][sum+1000];
                    dp[i][sum-nums[i]+1000]+=dp[i-1][sum+1000];
                }
            }
        }
        return S>1000?0:dp[nums.length-1][S+1000];

    }
    public int findTargetSumWays3(int[] nums,int S){
        int[] dp=new int[2001];
        dp[1000+nums[0]]=1;
        dp[1000-nums[0]]+=1;
        for(int i=1;i<nums.length;i++){
            int[] next=new int[2001];
            for(int sum=-1000;sum<=1000;sum++){
                if(dp[sum+1000]>0){
                    next[sum+nums[i]+1000]+=dp[sum+1000];
                    next[sum-nums[i]+1000]+=dp[sum+1000];
                }
            }
            dp=next;
        }
        return S>1000?0:dp[S+1000];
    }
}
