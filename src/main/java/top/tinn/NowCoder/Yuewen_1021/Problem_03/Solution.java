package top.tinn.NowCoder.Yuewen_1021.Problem_03;

/**
 * @Author: Tinn
 * @Date: 2020/10/21 19:28
 */
public class Solution {
    public int countBit (int n) {
        // write code here
        int ans = 0;
        while (n != 0){
            n = n & (n - 1);
            ans++;
        }
        return ans;
    }
}
