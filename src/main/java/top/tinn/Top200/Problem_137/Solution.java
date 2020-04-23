package top.tinn.Top200.Problem_137;

import org.junit.jupiter.api.Test;

/**
 * @ClassName Solution
 * @Description
 * 137. 只出现一次的数字 II
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,3,2]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 * @Author Tinn
 * @Date 2020/4/21 14:08
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int i = 0; i < 32; i++){
            int mask = 1 << i;
            int count = 0;
            for (int n : nums){
                if ((mask & n) != 0)
                    count++;
            }
            if (count % 3 != 0)
                ret |= mask;
        }
        return ret;
    }
    public int singleNumber2(int[] nums) {
        int x1 = 0, x2 = 0, mask;
        for (int n : nums){
            x2 ^= x1 & n;
            x1 ^= n;
            mask = ~(x1 & x2);
            x2 &= mask;
            x1 &= mask;
        }
        //p = 01
        return x1;
    }

    //k = 5, p = 3 也就是每个数字出现了5 次，只有一个数字出现了 3 次。
    public int singleNumber3(int[] nums) {
        int x1 = 0, x2 = 0, x3 = 0,mask;
        for (int n : nums){
            x3 ^= x2 & x1 &n;
            x2 ^= x1 & n;
            x1 ^= n;
            mask = ~(x3 & ~x2 & x1);
            x3 &= mask;
            x2 &= mask;
            x1 &= mask;
        }
        //return x1 x2都可以 p = (011);
        return x2;
    }

    @Test
    public void test(){
        int[] nums = {1,1,1,1,1,2,2,2};
        System.out.println(singleNumber3(nums));
    }

}
