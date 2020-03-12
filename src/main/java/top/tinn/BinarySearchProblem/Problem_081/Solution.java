package top.tinn.BinarySearchProblem.Problem_081;

import org.junit.jupiter.api.Test;

/**
 * 81. 搜索旋转排序数组 II
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 *
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 *
 * 示例 1:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 * 进阶:
 *
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while (l<=r){
            int mid=l+(r-l)/2;
            if (nums[mid]==target) return true;
            else if (nums[mid]<nums[r]){
                if (nums[mid]<target&&target<=nums[r])
                    l=mid+1;
                else r=mid-1;
            }else if (nums[mid]>nums[r]){
                if (nums[l]<=target&&target<nums[mid])
                    r=mid-1;
                else l=mid+1;
            }else if (nums[mid]==nums[r]){
                r--;
            }
        }
        return false;
    }

    @Test
    public void test(){
        int[] nums={1,1,3,1};
        int target=3;
        System.out.println(search(nums,target));
    }
}
