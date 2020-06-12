package top.tinn.DpProblem.Problem_410;

import org.junit.jupiter.api.Test;

public class Solution {
    public int splitArray(int[] nums, int m) {
        double[][] dp = new double[m + 1][nums.length];
        for (int i = 1; i <= m; i++){
            for (int j = i - 1; j < nums.length; j++){
                if (i == 1){
                    if (j == 0){
                        dp[1][0] = nums[0];
                    }else
                        dp[i][j] = nums[j] + dp[i][j - 1];
                }else{
                    double min = Double.MAX_VALUE;
                    for (int k = i - 2; k < j; k++){
                        min = Math.min(min, Math.max(dp[i - 1][k], dp[1][j] - dp[1][k]));
                    }
                    dp[i][j] = min;
                }
            }
        }
        return (int)dp[m][nums.length - 1];
    }

    public int splitArray2(int[] nums, int m) {
        int max = 0;
        int sum = 0;

        // 计算「子数组各自的和的最大值」的上下界
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        // 使用「二分查找」确定一个恰当的「子数组各自的和的最大值」，
        // 使得它对应的「子数组的分割数」恰好等于 m
        int left = max;
        int right = sum;
        while (left < right) {
            int mid = left + (right - left) / 2;

            int splits = split(nums, mid);
            if (splits > m) {
                // 如果分割数太多，说明「子数组各自的和的最大值」太小，此时需要将「子数组各自的和的最大值」调大
                // 下一轮搜索的区间是 [mid + 1, right]
                left = mid + 1;
            } else {
                // 下一轮搜索的区间是上一轮的反面区间 [left, mid]
                right = mid;
            }
        }
        return left;
    }

    /***
     *
     * @param nums 原始数组
     * @param maxIntervalSum 子数组各自的和的最大值
     * @return 满足不超过「子数组各自的和的最大值」的分割数
     */
    private int split(int[] nums, int maxIntervalSum) {
        // 至少是一个分割
        int splits = 1;
        // 当前区间的和
        int curIntervalSum = 0;
        for (int num : nums) {
            // 尝试加上当前遍历的这个数，如果加上去超过了「子数组各自的和的最大值」，就不加这个数，另起炉灶
            if (curIntervalSum + num > maxIntervalSum) {
                curIntervalSum = 0;
                splits++;
            }
            curIntervalSum += num;
        }
        return splits;
    }


    @Test
    public void test(){
        //System.out.println(splitArray(new int[]{1, Integer.MAX_VALUE}, 2));
        System.out.println(splitArray(new int[]{1,4,4}, 3));
    }
}
