package top.tinn.BitProblem.Problem_421;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Solution
 * @Description
 * 421. 数组中两个数的最大异或值
 *
 * 给定一个非空数组，数组中元素为 a0, a1, a2, … , an-1，其中 0 ≤ ai < 231 。
 *
 * 找到 ai 和aj 最大的异或 (XOR) 运算结果，其中0 ≤ i,  j < n 。
 *
 * 你能在O(n)的时间解决这个问题吗？
 *
 * 示例:
 *
 * 输入: [3, 10, 5, 25, 2, 8]
 *
 * 输出: 28
 *
 * 解释: 最大的结果是 5 ^ 25 = 28.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Tinn
 * @Date 2020/4/15 16:56
 */
public class Solution {
    public int findMaximumXOR(int[] nums) {
        int res = 0;
        int mask = 0;
        for (int i = 30; i>=0; i--){
            mask |=(1<<i);
            //保留前缀
            Set<Integer> set = new HashSet<>();
            for (int num : nums){
                set.add(num & mask);
            }
            //假定第n位为1
            int temp  = res | (1<<i);
            for (Integer prefix : set){
                if (set.contains(prefix ^ temp)){
                    res = temp;
                    break;
                }
            }
        }
        return res;
    }
}
