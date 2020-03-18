package top.tinn.DpProblem.Problem_877;

/**
 * 877. 石子游戏
 *
 * 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
 *
 * 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
 *
 * 亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
 *
 * 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
 *
 *  
 *
 * 示例：
 *
 * 输入：[5,3,4,5]
 * 输出：true
 * 解释：
 * 亚历克斯先开始，只能拿前 5 颗或后 5 颗石子 。
 * 假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
 * 如果李拿走前 3 颗，那么剩下的是 [4,5]，亚历克斯拿走后 5 颗赢得 10 分。
 * 如果李拿走后 5 颗，那么剩下的是 [3,4]，亚历克斯拿走后 4 颗赢得 9 分。
 * 这表明，取前 5 颗石子对亚历克斯来说是一个胜利的举动，所以我们返回 true 。
 *  
 *
 * 提示：
 *
 * 2 <= piles.length <= 500
 * piles.length 是偶数。
 * 1 <= piles[i] <= 500
 * sum(piles) 是奇数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/stone-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public boolean stoneGame(int[] nums) {
        int size=nums.length;
        int[][][] dp=new int[size][size][2];
        for (int len=0;len<nums.length;len++){
            for (int start=0;start+len<nums.length;start++){
                int end=start+len;
                if (start==end){
                    dp[start][end][0]=nums[start];
                    dp[start][end][1]=0;
                }else {
                    int left=nums[start]+dp[start+1][end][1];
                    int right=nums[end]+dp[start][end-1][1];
                    if (left>right){
                        dp[start][end][0]=left;
                        dp[start][end][1]=dp[start+1][end][0];
                    }else {
                        dp[start][end][0]=right;
                        dp[start][end][1]=dp[start][end-1][0];
                    }
                }
            }
        }
        return dp[0][size-1][0]>=dp[0][size-1][1];
    }

    public boolean stoneGame2(int[] nums) {
        return true;
    }
}
