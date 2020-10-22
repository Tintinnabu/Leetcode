package top.tinn.NowCoder.Yuewen_1021.Problem_02;

/**
 * @Author: Tinn
 * @Date: 2020/10/21 19:26
 */
public class Solution {
    public String removeDuplicatedChars (String str) {
        // write code here
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[128];
        for (char c : str.toCharArray()){
            if (!used[c]){
                sb.append(c);
                used[c] = true;
            }
        }
        return sb.toString();
    }
}
