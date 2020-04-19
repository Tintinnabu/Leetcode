package top.tinn.Problem_242;

/**
 * @ClassName Solution
 * @Description
 * @Author Tinn
 * @Date 2020/4/18 20:51
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] mark = new int[26];
        for (char c : s.toCharArray())
            mark[c - 'a']++;
        for (char c : t.toCharArray()){
            mark[c - 'a']--;
            if (mark[c - 'a'] < 0)
                return false;
        }
        return true;
    }
}
