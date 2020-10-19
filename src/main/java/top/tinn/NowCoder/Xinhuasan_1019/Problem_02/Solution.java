package top.tinn.NowCoder.Xinhuasan_1019.Problem_02;

import org.junit.jupiter.api.Test;

/**
 * @Author: Tinn
 * @Date: 2020/10/19 20:24
 */
public class Solution {
    String[] dict = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    public String character_auto_complete (String str) {
        // write code here
        if (str == null || str.length() == 0){
            return "No match";
        }
        StringBuilder sb = new StringBuilder();
        for (String reg : dict){
            if (isMatch(reg, str)){
                sb.append(reg).append(" ");
            }
        }
        if (sb.length() == 0) return "No match";
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private boolean isMatch(String reg, String str) {
        if (reg.length() < str.length()){
            return false;
        }
        int i = 0;
        while (i < str.length()){
            if (reg.charAt(i) == str.charAt(i)){
                i++;
            }else {
                break;
            }
        }
        return i == str.length();
    }

    @Test
    public void test(){
        System.out.println(character_auto_complete("S"));
        System.out.println(character_auto_complete("T"));
    }
}
