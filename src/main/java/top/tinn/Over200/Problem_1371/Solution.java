package top.tinn.Over200.Problem_1371;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/20 12:07
 */
public class Solution {
    public int findTheLongestSubstring(String s) {
        int[] index = new int[32];
        Arrays.fill(index, Integer.MIN_VALUE);
        index[0] = -1;
        int state = 0;
        int ret = 0;
        for (int i = 0; i < s.length(); i++){
            switch (s.charAt(i)){
                case 'a' : state ^= 1; break;
                case 'e' : state ^= 2; break;
                case 'i' : state ^= 4; break;
                case 'o' : state ^= 8; break;
                case 'u' : state ^= 16; break;
                default: break;
            }
            if (index[state] != Integer.MIN_VALUE){
                ret = Math.max(i - index[state], ret);
            }else {
                index[state] = i;
            }
        }
        return ret;
    }
    @Test
    public void test(){
        System.out.println(findTheLongestSubstring("leetcodeisgreat"));
    }
}
