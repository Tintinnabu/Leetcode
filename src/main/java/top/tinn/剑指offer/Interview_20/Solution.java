package top.tinn.剑指offer.Interview_20;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/7 21:09
 */
public class Solution {

    //two modules A[.[B]][e|EC]  or .B[e|EC]
    private int i = 0;
    public boolean isNumber(String s) {
        if (s == null) return false;
        char[] c = s.trim().toCharArray();
        boolean A = scanInteger(c), B = false, C = false;
        if (i < c.length && c[i] == '.'){
            i++;
            B = scanUnsignedInteger(c);
        }
        if (i < c.length && (c[i] == 'e' || c[i] == 'E')){
            i++;
            C = scanInteger(c);
            if (!C) return false;
        }
        return i == c.length && (A || B);
    }

    private boolean scanInteger(char[] c){
        if (i < c.length && (c[i] == '+' || c[i] == '-'))
            i++;
        return scanUnsignedInteger(c);
    }

    private boolean scanUnsignedInteger(char[] c) {
        int start = i;
        while (i < c.length && c[i] >= '0' && c[i] <= '9') i++;
        //i>start说明扫描到了数字;
        //i<=start说明没有扫描到数字, 此种情况说明要么start越界, 要么s.charAt(start)不是数字
        return i > start;
    }
}
