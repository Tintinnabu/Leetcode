package top.tinn.DoublePointsProblem.Problem_018;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    //O(n^3)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        for (int start1=0;start1<nums.length-3;start1++){
            if (start1!=0&&nums[start1]==nums[start1-1]) continue;
            for (int start2=start1+1;start2<nums.length-2;start2++){
                if (start2!=start1+1&&nums[start2]==nums[start2-1]) continue;
                int l=start2+1,r=nums.length-1;
                while (l<r){
                    int t=nums[start1]+nums[start2]+nums[l]+nums[r];
                    if (t==target){
                        List<Integer> temp=new ArrayList<>();
                        temp.add(nums[start1]);
                        temp.add(nums[start2]);
                        temp.add(nums[l]);
                        temp.add(nums[r]);
                        result.add(temp);
                        while (l<r&&nums[l]==nums[l+1]) l++;
                        while (l<r&&nums[r]==nums[r-1]) r--;
                        l++;r--;
                    }else if (t>target) r--;
                    else l++;
                }
            }
        }
        return result;
    }


    @Test
    public void test(){
        int[] nums={0,0,0,0};
        System.out.println(fourSum(nums,0));
    }
}
