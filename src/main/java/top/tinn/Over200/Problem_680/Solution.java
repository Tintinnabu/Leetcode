package top.tinn.Over200.Problem_680;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/19 16:51
 */
public class Solution {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        char[] chars = s.toCharArray();
        while (l < r) {
            if (chars[l] != chars[r]) {
                return isPalindrome(chars, l + 1, r) || isPalindrome(chars, l, r - 1);
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isPalindrome(char[] chars, int l, int r) {
        while (l < r){
            if (chars[l] != chars[r]){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
