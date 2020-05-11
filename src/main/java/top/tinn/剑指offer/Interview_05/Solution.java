package top.tinn.剑指offer.Interview_05;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/4/30 10:06
 */
public class Solution {
    public String replaceSpace(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()){
            if (c == ' ')
                cnt += 2;
            cnt += 1;
        }
        char[] chars = new char[cnt];
        int curr = cnt - 1;
        for (int i = s.length() - 1; i >= 0; i--){
            if (s.charAt(i) == ' '){
                chars[curr--] = '0';
                chars[curr--] = '2';
                chars[curr--] = '%';
            }else chars[curr--] = s.charAt(i);
        }
        return String.valueOf(chars);
    }
}
