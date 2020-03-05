package top.tinn.Problem_560;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 *
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum=0,count=0;
        int r=0;
        while(r<nums.length){
            sum+=nums[r];
            int l=0,tempSum=sum;
            while (l<=r){
                if(tempSum==k) count++;
                tempSum-=nums[l];
                l++;
            }
            r++;
        }
        return count;
    }

    public int subarraySum2(int[] nums, int k) {
        int count=0,sum=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int num:nums){
            sum+=num;
            if(map.containsKey(sum-k))
                count+=map.get(sum-k);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }


    @Test
    public void test(){
        int[] nums=new int[]{1,-1,1,1,-1};
        int k=0;
        System.out.println(subarraySum(nums,k));
    }
}
