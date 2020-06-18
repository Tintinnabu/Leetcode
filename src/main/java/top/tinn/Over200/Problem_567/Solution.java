package top.tinn.Over200.Problem_567;

/**
 * @author Tintinnabu
 * @description
 * @data 2020/6/17
 */
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()){
            return false;
        }
        int[] need = new int[26];
        int[] window = new int[26];
        int num = 0;
        for (char c : s1.toCharArray()){
            if (need[c - 'a'] == 0){
                num++;
            }
            need[c - 'a']++;
        }
        int left = 0, right = 0, valid = 0;
        while(right < s2.length()){
            char c = s2.charAt(right);
            right++;
            if (need[c - 'a'] > 0){
                window[c - 'a']++;
                if (window[c - 'a'] == need[c - 'a']){
                    valid++;
                }
            }
            while(right - left >= s1.length()){
                if (valid == num){
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                if (need[d - 'a'] > 0){
                    if (window[d - 'a'] == need[d - 'a']){
                        valid--;
                    }
                    window[d - 'a']--;
                }
            }
        }
        return false;
    }
}
