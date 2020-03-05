package top.tinn.Problem_581;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.Stack;

/**
 * 581. 最短无序连续子数组
 *
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 你找到的子数组应是最短的，请输出它的长度。
 *
 * 示例 1:
 *
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 说明 :
 *
 * 输入的数组长度范围在 [1, 10,000]。
 * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] sorted=nums.clone();
        Arrays.sort(sorted);
        int start=nums.length,end=0;
        for(int i=0;i<nums.length;i++){
            if (nums[i]!=sorted[i]){
                start=Math.min(start,i);
                end=Math.max(end,i);
            }
        }
        return (end-start)>0?end-start+1:0;
    }

    public int findUnsortedSubarray2(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        int l=nums.length,r=0;
        for (int i=0;i<nums.length;i++){
            while (!stack.isEmpty()&&nums[stack.peek()]>nums[i]){
                l=Math.min(l,stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        for (int i=nums.length-1;i>=l;i--){
            while (!stack.isEmpty()&&nums[stack.peek()]<nums[i]){
                r=Math.max(r,stack.pop());
            }
            stack.push(i);
        }
        return (r-l)>0?r-l+1:0;
    }

    public int findUnsortedSubarray3(int[] nums) {
        int min=Integer.MAX_VALUE,max= Integer.MIN_VALUE;
        boolean flag=false;
        for (int i=1;i<nums.length;i++){
            if (nums[i]<nums[i-1])
                flag=true;
            if (flag)
                min=Math.min(min,nums[i]);
        }

        flag=false;
        for (int i=nums.length-2;i>=0;i--){
            if (nums[i]>nums[i+1])
                flag=true;
            if (flag)
                max=Math.max(max,nums[i]);
        }

        int l,r;
        for (l=0;l<nums.length;l++) {
            if (nums[l] > min)
                break;
        }
        for (r=nums.length-1;r>=0;r--){
            if (nums[r]<max)
                break;
        }
        return (r-l)>0?r-l+1:0;
    }
}
