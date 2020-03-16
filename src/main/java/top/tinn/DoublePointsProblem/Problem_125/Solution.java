package top.tinn.DoublePointsProblem.Problem_125;

import org.junit.jupiter.api.Test;

public class Solution {
    public boolean isPalindrome(String s) {
        int l=0,r=s.length()-1;
        char[] tmp=s.toLowerCase().toCharArray();
        while (l<r){
            while (l<r&&!Character.isLetter(tmp[l])&&!Character.isDigit(tmp[l]))
                l++;
            while (l<r&&!Character.isLetter(tmp[r])&&!Character.isDigit(tmp[r]))
                r--;
            if (tmp[l]==tmp[r]){
                l++;r--;
            }else
                return false;
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(isPalindrome("0P"));
    }
}
