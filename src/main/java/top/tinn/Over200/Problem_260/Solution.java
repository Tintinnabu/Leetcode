package top.tinn.Over200.Problem_260;

public class Solution {
    //异或运算
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int n : nums){
            xor ^= n;
        }
        //获取mask这步极为巧妙
        int mask = xor & (-xor);
        int[] ans = new int[2];
        for (int num : nums){
            if ((num & mask) == 0){
                ans[0] ^= num;
            }else {
                ans[1] ^= num;
            }
        }
        return ans;
    }
}
