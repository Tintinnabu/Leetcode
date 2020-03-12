package top.tinn.BinarySearchProblem.Problem_029;

import org.junit.jupiter.api.Test;

/**
 * 29. 两数相除
 *
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend==0) return 0;
        else if (divisor==1) return dividend;
        else if (divisor==-1){
            if (dividend>Integer.MIN_VALUE) return -dividend;
            return Integer.MAX_VALUE;
        }
        else if (dividend>0&&divisor>0)
            return div(dividend,divisor);
        else if (dividend<0&&divisor<0)
            return div(-(long) dividend,-(long)divisor);
        else if (dividend>0&&divisor<0)
            return -div(dividend,-(long) divisor);
        return -div(-(long)dividend,divisor);
    }

    private int div(long a,long b){
        if (a<b) return 0;
        long count=1;
        long tmp=b;
        while (tmp+tmp<=a){
            count=count+count;
            tmp=tmp+tmp;
        }
        return (int)count+div(a-tmp,b);
    }

    @Test
    public void test(){
        System.out.println(divide(-2147483648,-1));
    }
}
