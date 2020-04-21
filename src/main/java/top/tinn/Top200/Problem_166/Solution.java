package top.tinn.Top200.Problem_166;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution
 * @Description
 * 166. 分数到小数
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
 *
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 *
 * 示例 1:
 *
 * 输入: numerator = 1, denominator = 2
 * 输出: "0.5"
 * 示例 2:
 *
 * 输入: numerator = 2, denominator = 1
 * 输出: "2"
 * 示例 3:
 *
 * 输入: numerator = 2, denominator = 3
 * 输出: "0.(6)"
 * @Author Tinn
 * @Date 2020/4/20 19:49
 */
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) sb.append("-");
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        sb.append(dividend / divisor);
        long reminder = dividend % divisor;
        if (reminder == 0) return sb.toString();
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (reminder != 0){
            if (map.containsKey(reminder)){
                sb.insert(map.get(reminder), "(");
                sb.append(")");
                break;
            }
            map.put(reminder, sb.length());
            reminder *= 10;
            sb.append(reminder / divisor);
            reminder %= divisor;
        }
        return sb.toString();
    }


    @Test
    public void test(){
        //System.out.println(fractionToDecimal(1,2));
        //System.out.println(fractionToDecimal(2,1));
        //System.out.println(fractionToDecimal(1,3));
        System.out.println(fractionToDecimal(-2147483648,-1));
    }
}
