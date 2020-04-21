package top.tinn.Top200.Problem_179;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName Solution
 * @Description
 * 179. 最大数
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: 210
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * @Author Tinn
 * @Date 2020/4/20 12:41
 */
public class Solution {
    public String largestNumber(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .map(Object::toString)
                .sorted((s1, s2)->{
                    String sum1 = s1 + s2;
                    String sum2 = s2 + s1;
                    for (int i = 0; i < sum1.length(); i++){
                        if (sum1.charAt(i) != sum2.charAt(i))
                            return sum2.charAt(i) - sum1.charAt(i);
                    }
                    return 0;
                })
                .reduce(String::concat)
                .filter(s -> !s.startsWith("0"))
                .orElse("0");
    }

    @Test
    public void test(){
        int[] nums= {3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }
}
