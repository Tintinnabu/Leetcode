package top.tinn.NowCoder.Yuewen_1021.Problem_01;

import org.junit.jupiter.api.Test;

/**
 * @Author: Tinn
 * @Date: 2020/10/21 19:21
 */
public class Solution{
    int count = 0;
    public int palindromeCount (String str) {
        // write code here
        count = 0;
        for (int i = 0; i < str.length(); i++){
            countPalindrome(str, i, i);
            countPalindrome(str, i, i + 1);
        }
        return count;
    }

    private void countPalindrome(String str, int l, int r) {
        while (l >= 0 && r < str.length()){
            if (str.charAt(l) == str.charAt(r)){
                count++;
                l--;
                r++;
            }else return;
        }
    }

    @Test
    public void test(){
        System.out.println(palindromeCount("aaa"));
        System.out.println(palindromeCount("abcb"));
    }
}

