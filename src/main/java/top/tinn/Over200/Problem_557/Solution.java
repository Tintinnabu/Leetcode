package top.tinn.Over200.Problem_557;

/**
 * @Author: Tinn
 * @Date: 2020/8/30 9:27
 */
public class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (char c : s.toCharArray()){
            if (c == ' '){
                //process
                ans.append(temp.reverse());
                ans.append(' ');
                temp = new StringBuilder();
            }else{
                temp.append(c);
            }
        }
        ans.append(temp.reverse());
        return ans.toString();
    }
}
