package top.tinn.Problem_416;

import org.junit.jupiter.api.Test;

/**
 * 416. 分割等和子集
 *
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *  
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        int size=nums.length;
        if(size==0) return false;
        int sum=0;
        for(int num:nums) sum+=num;
        if (sum%2==1) return false;
        int target=sum/2;

        // 具体做法是：画一个 len 行，target + 1 列的表格。这里 len 是物品的个数，
        // target 是背包的容量。len 行表示一个一个物品考虑，target + 1多出来的那 1 列，
        // 表示背包容量从 0 开始，很多时候，我们需要考虑这个容量为 0 的数值。

        boolean[][] dp=new boolean[size][target+1];
        if (nums[0]<=target) dp[0][nums[0]]=true;
        for(int i=1;i<size;i++){
            for(int j=1;j<=target;j++){
                dp[i][j] = dp[i - 1][j];

                if (nums[i] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
            // 由于状态转移方程的特殊性，提前结束，可以认为是剪枝操作
            if (dp[i][target]) {
                return true;
            }
        }
        return dp[size-1][target];
    }

    @Test
    public void test(){
        int[] nums=new int[]{2,2,3,5};
        System.out.println(canPartition(nums));
    }

    public boolean canPartition2(int[] nums) {
        int size=nums.length;
        if(size==0) return false;
        int sum=0;
        for(int num:nums) sum+=num;
        if (sum%2==1) return false;
        int target=sum/2;

        // 具体做法是：画一个 len 行，target + 1 列的表格。这里 len 是物品的个数，
        // target 是背包的容量。len 行表示一个一个物品考虑，target + 1多出来的那 1 列，
        // 表示背包容量从 0 开始，很多时候，我们需要考虑这个容量为 0 的数值。

        boolean[] dp=new boolean[target+1];
        dp[0]=true;
        if (nums[0]<=target) dp[nums[0]]=true;
        for(int i=1;i<size;i++){
            for(int j=target;nums[i]<=j;j--){
            // 由于状态转移方程的特殊性，提前结束，可以认为是剪枝操作
                if (dp[target]) {
                    return true;
                }
                dp[j]=dp[j]||dp[j-nums[i]];}

        }
        return dp[target];
    }
}
