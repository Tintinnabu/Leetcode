package top.tinn.剑指offer.Interview_43;

import org.junit.jupiter.api.Test;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/1 20:47
 */
public class Solution {
    public int countDigitOne(int n) {
        int digit = 1, res = 0, high = n / 10, low = 0, cur = n % 10;
        while (high != 0 || cur != 0){
            if (cur == 0) res += high * digit;
            else if (cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;
            low += cur * digit;
            digit *= 10;
            cur = high % 10;
            high /= 10;
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(countDigitOne(3456));
    }
}
