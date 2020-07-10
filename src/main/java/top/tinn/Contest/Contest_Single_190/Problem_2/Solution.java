package top.tinn.Contest.Contest_Single_190.Problem_2;

import org.junit.jupiter.api.Test;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/24 10:35
 */
public class Solution {
    public int maxVowels(String s, int k) {
        if (s == null || s.length() < k){
            return 0;
        }
        int ret = 0;
        char[] chars = s.toCharArray();
        int[] mark = new int[s.length() + 1];
        for (int i = 1; i <= s.length(); i++){
            mark[i] = mark[i - 1] + (isVowels(chars[i - 1]) ? 1 : 0);
            if (i - k >= 0){
                ret = Math.max(ret, mark[i] - mark[i - k]);
            }
        }
        return ret;
    }

    private boolean isVowels(char aChar) {
        return aChar == 'a' || aChar == 'e' || aChar == 'i'
                || aChar == 'o' || aChar == 'u';
    }

    @Test
    public void test(){
        System.out.println(maxVowels("abciiidef", 3));
    }
}
