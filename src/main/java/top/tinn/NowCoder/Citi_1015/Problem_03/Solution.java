package top.tinn.NowCoder.Citi_1015.Problem_03;

/**
 * @Author: Tinn
 * @Date: 2020/10/17 18:52
 */
public class Solution {
    public String solution(String s) {
        char c = s.charAt(0);
        if (c >= 'A' && c <= 'Z') {  // please fix condition
            return "upper";
        } else if (c >= 'a' && c <= 'z') {  // please fix condition
            return "lower";
        } else if (c >= '0' && c <= '9') {  // please fix condition
            return "digit";
        } else {
            return "other";
        }
    }
}
