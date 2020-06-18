package top.tinn.Over200.Problem_424;

/**
 * @author Tintinnabu
 * @description
 * @data 2020/6/17
 */
public class Solution {
    private int[] map;
    public int characterReplacement(String s, int k) {
        if (s == null){
            return 0;
        }
        char[] chars = s.toCharArray();
        map = new int[26];
        int l = 0, r = 0;
        int maxChar = 0;
        while (r < chars.length){
            int index = chars[r] - 'A';
            maxChar = Math.max(maxChar, ++map[index]);
            if (maxChar + k < r - l + 1){
                map[chars[l] - 'A']--;
                l++;
            }
            r++;
        }
        return chars.length - l;
    }
}
