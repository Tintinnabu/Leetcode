package top.tinn.Over200.Problem_409;

import org.junit.jupiter.api.Test;

public class Solution {
    public int longestPalindrome(String s) {
        int[] cnt = new int[58];
        for (char c : s.toCharArray()) {
            cnt[c - 'A'] += 1;
        }
        int maxOdd=-1;
        int ret=0;
        for (int value:cnt){
            if (value%2==0) ret+=value;
            else {
                ret+=value-1;
                maxOdd=Math.max(maxOdd,value);
            }
        }
        ret+=(maxOdd==-1?0:1);
        return ret;
    }

    @Test
    public void test(){
        String s="bb";
        System.out.println(longestPalindrome(s));
    }
}
