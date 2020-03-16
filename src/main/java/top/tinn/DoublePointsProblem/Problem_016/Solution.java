package top.tinn.DoublePointsProblem.Problem_016;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result=nums[0]+nums[1]+nums[2];
        for (int start=0;start<nums.length-2;start++){
            int left=start+1,right=nums.length-1;
            while (left<right){
                int temp=nums[start]+nums[left]+nums[right];
                if (temp==target) return target;
                else {
                    if (Math.abs(temp-target)<Math.abs(result-target))
                        result=temp;
                    if (temp>target) right--;
                    else left++;
                }
            }
        }
        return result;
    }

    @Test
    public void test(){
        int [] nums={-3,-2,-5,3,-4};
        System.out.println(threeSumClosest(nums,-1));
    }
}
