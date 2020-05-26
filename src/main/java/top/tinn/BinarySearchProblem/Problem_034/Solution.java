package top.tinn.BinarySearchProblem.Problem_034;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int l = 0, r = nums.length - 1;
        //找到最大的小于target的值
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (nums[mid] < target){
                l = mid + 1;
            }else if (nums[mid] == target){
                r = mid - 1;
            }else {
                r = mid - 1;
            }
        }
        //l = h + 1;
        if (l >= nums.length || nums[l] != target){
            return result;
        }
        result[0] = l;
        l = 0;
        r = nums.length - 1;
        //找到最小的大于target的值
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (nums[mid] > target){
                r = mid - 1;
            }else if (nums[mid] == target){
                l = mid + 1;
            }else {
                l = mid + 1;
            }
        }
        //l = r + 1;
        /*if (r < 0 || nums[r] != target){
            return result;
        }*/
        result[1] = r;
        return result;
    }

    @Test
    public void test(){
        int[] nums={5,7,7,7,8,10};
        int[] res=searchRange(nums,6);
        System.out.println(Arrays.toString(res));
    }
}
