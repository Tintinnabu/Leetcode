package top.tinn.Over200.Problem_238;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/6/1 16:08
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] lProduct = new int[nums.length];
        int pre = 1;
        for (int i = 0; i < nums.length; i++){
            lProduct[i] = pre;
            pre *= nums[i];
        }
        int[] ans = new int[nums.length];
        pre = 1;
        for (int i = nums.length - 1; i >= 0; i--){
            ans[i] = pre * lProduct[i];
            pre *= nums[i];
        }
        return ans;
    }
}
