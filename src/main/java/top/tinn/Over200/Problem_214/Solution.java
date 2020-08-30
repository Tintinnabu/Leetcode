package top.tinn.Over200.Problem_214;

import com.sun.javafx.geom.BaseBounds;
import org.junit.jupiter.api.Test;

/**
 * @Author: Tinn
 * @Date: 2020/8/29 8:40
 */
public class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        for (int i = (n - 1) >> 1; i >= 0 ; i--){
            String temp = helper(s, i, i + 1);
            if (temp != null){
                return temp;
            }
            temp = helper(s, i, i);
            if (temp != null){
                return temp;
            }
        }
        return null;
    }

    private String helper(String s, int l, int r ){
        if (r > s.length() / 2){
            return null;
        }
        for (int dis = 0; l - dis >= 0; dis++){
            if (s.charAt(l - dis) != s.charAt(r + dis)){
                return null;
            }
        }
        StringBuilder sb = new StringBuilder(s);
        int j;
        if (l == r){
            j = 2 * r + 1;
        }else{
            j = 2 * r;
        }
        for (; j < s.length(); j++){
            sb.insert(0, s.charAt(j));
        }
        return sb.toString();
    }

    @Test
    public void test(){
        //System.out.println(shortestPalindrome("aacecaaa"));
        //System.out.println(shortestPalindrome("abcd"));
        //System.out.println(shortestPalindrome("abbacd"));
        System.out.println(shortestPalindrome("aabba"));
    }
}
