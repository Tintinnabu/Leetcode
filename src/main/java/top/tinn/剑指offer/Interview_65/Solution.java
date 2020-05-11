package top.tinn.剑指offer.Interview_65;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/6 20:24
 */
public class Solution {
    public int add(int a, int b) {
        int sum, carry;
        do{
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        }while (carry != 0);
        return sum;
    }
}
