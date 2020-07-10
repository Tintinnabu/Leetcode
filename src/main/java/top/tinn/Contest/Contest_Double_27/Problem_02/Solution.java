package top.tinn.Contest.Contest_Double_27.Problem_02;

import org.junit.jupiter.api.Test;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/30 22:34
 */
public class Solution {
    public boolean hasAllCodes(String s, int k) {
        int mask = (1 << k) - 1;
        boolean[] exist = new boolean[mask + 1];
        int bits = 0;
        for (int i = 0; i < k - 1 && i < s.length(); i++){
            bits <<= 1;
            bits &= mask;
            bits |= (s.charAt(i) - '0');
        }
        for (int i = k - 1; i < s.length(); i++){
            bits <<= 1;
            bits &= mask;
            bits |= (s.charAt(i) - '0');
            exist[bits] = true;
        }
        for (boolean b : exist){
            if (!b){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(hasAllCodes("00110", 2));
    }
}
