package top.tinn.剑指offer.Interview_58_1;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/6 19:41
 */
public class Solution {
    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        int left = 0;
        while (left < s.length() && chars[left] == ' ')
            left++;
        int right = s.length() - 1;
        int len = 0;
        while (right >= left){
            while (right >= left && chars[right] == ' '){
                if (len > 0){
                    stringBuilder.append(s, right + 1, right + 1 + len);
                    stringBuilder.append(' ');
                    len = 0;
                }
                right--;
            }
            len++;
            right--;
        }
        stringBuilder.append(s, left, left + len);
        return stringBuilder.toString();
    }
}
