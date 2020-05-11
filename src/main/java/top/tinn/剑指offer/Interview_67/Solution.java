package top.tinn.剑指offer.Interview_67;

import org.junit.jupiter.api.Test;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/7 20:49
 */
public class Solution {
    public int strToInt(String str) {
        if (str == null || str.length() == 0) return 0;
        char[] s = str.toCharArray();
        int i = 0;
        while (i < s.length && s[i] ==' ') i++;
        if (i == s.length) return 0;
        while (i + 1 < s.length && s[i] == '0' && s[i + 1] == '0') i++;
        if ((s[i] < '0' || s[i] > '9') && s[i] != '+' && s[i] != '-') return 0;
        else if (s[i] == '-') return getAtoi(s, i + 1, false);
        else if (s[i] == '+') return getAtoi(s, i + 1, true);
        return getAtoi(s, i,true);
    }

    private int getAtoi(char[] s, int i, boolean sign) {
        long res = 0;
        while (i < s.length && s[i] >= '0' && s[i] <= '9'){
            res = 10 * res + s[i++] - '0';
            if (sign && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else if (!sign && res - Integer.MAX_VALUE > 1) return Integer.MIN_VALUE;
        }
        return sign ? (int) res : -(int) res;
    }

    @Test
    public void test(){
        System.out.println(strToInt("-2147483647"));
    }
}
