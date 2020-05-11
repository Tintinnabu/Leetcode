package top.tinn.剑指offer.Interview_46;

import org.junit.jupiter.api.Test;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/2 12:19
 */
public class Solution {
    public int translateNum(int num) {
        return dps(String.valueOf(num).toCharArray(), 0);
    }

    private int dps(char[] chars, int idx){
        if (idx >= chars.length - 1) return 1;
        int ret = 0;
        if (chars[idx] == '0'){
            ret += dps(chars, idx + 1);
        }else if (chars[idx] == '1'){
            ret = dps(chars, idx + 1) + dps(chars, idx + 2);
        }else if (chars[idx] == '2' && chars[idx + 1] < '6'){
            ret = dps(chars, idx + 1) + dps(chars, idx + 2);
        }else if (chars[idx] == '2' )ret += dps(chars, idx + 2);
        else ret += dps(chars, idx + 1);
        return ret;
    }

    public int translateNum2(int num) {
        int a = 1, b = 1, x, y = num % 10;
        while(num != 0) {
            num /= 10;
            x = num % 10;
            int tmp = 10 * x + y;
            int c = (tmp >= 10 && tmp <= 25) ? a + b : a;
            b = a;
            a = c;
            y = x;
        }
        return a;
    }

    @Test
    public void test(){
        System.out.println(translateNum(21965915));
    }
}
