package top.tinn.DpProblem.Problem_169;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/28 22:32
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int count = 1, maj = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != maj){
                count--;
                if (count == 0){
                    maj = nums[i + 1];
                }
            }else {
                count++;
            }
        }
        return maj;
    }
}
