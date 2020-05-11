package top.tinn.剑指offer.Interview_58_2;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/6 19:41
 */
public class Solution {
    public String reverseLeftWords(String s, int n) {
        char [] chars = s.toCharArray();
        reverse(chars, 0, s.length() - 1);
        reverse(chars, 0, s.length() - 1 - n);
        reverse(chars, s.length() - n, s.length() - 1);
        return String.valueOf(chars);
    }

    private void reverse(char[] s, int left, int right){
        char temp;
        while (left < right){
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
