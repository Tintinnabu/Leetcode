package top.tinn.BinarySearchProblem.Problem_167;

import java.util.ArrayList;
import java.util.List;

/**
 * 167. 两数之和 II - 输入有序数组
 *
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * 通过次数73,529提交次数139,084
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result=new int[2];
        for (int i=0;i<numbers.length;i++){
            if (numbers[i]<=target/2){
                int temp=find(numbers,target-numbers[i],i+1);
                if (temp!=-1){
                    result[0]=i+1;
                    result[1]=temp+1;
                    return result;
                }
            }
        }
        return result;
    }

    private int find(int[] numbers, int target, int start) {
        int l=start,r=numbers.length-1;
        while (l<=r){
            int mid=l+(r-l)/2;
            if (numbers[mid]==target) return mid;
            else if (numbers[mid]>target) r=mid-1;
            else l=mid+1;
        }
        return -1;
    }

    public int[] twoSum2(int[] numbers, int target) {
        int l=0,r=numbers.length-1;
        while (l<r){
            if (numbers[l]+numbers[r]==target)
                return new int[]{l+1,r+1};
            else if (numbers[l]+numbers[r]>target) r--;
            else l++;
        }
        return new int[2];
    }
}
