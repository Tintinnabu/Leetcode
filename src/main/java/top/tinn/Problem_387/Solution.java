package top.tinn.Problem_387;

/**
 * @ClassName Solution
 * @Description
 * @Author Tinn
 * @Date 2020/4/19 20:12
 */
public class Solution {
    public int firstUniqChar(String s) {
        int[] mark = new int[26];
        for (char c : s.toCharArray()){
            mark[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++){
            if (mark[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }
}
