package top.tinn.Top200.Problem_128;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 *
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int n:nums) set.add(n);
        int max=0;
        for (int n:set){
            if (!set.contains(n-1)){
                int curr=n;
                int len=1;
                while (set.contains(curr+1)){
                    curr++;
                    len++;
                }
                max=Math.max(max,len);
            }
        }
        return max;
    }

    @Test
    public void test(){
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
